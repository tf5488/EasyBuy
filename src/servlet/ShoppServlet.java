package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.UserInfo;
import service.OrderDetailService;
import service.OrderService;
import service.ProductService;

public class ShoppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrderService os = new OrderService();
		OrderDetailService ods = new OrderDetailService();
		ProductService productservice = new ProductService();
		
		String temp = request.getParameter("temp");
		if(temp.equals("add")){
			String pidStr = request.getParameter("pid");
			if(pidStr != null){
				int pid = Integer.parseInt(pidStr);
				Product pro = productservice.findById(pid);
				UserInfo user = (UserInfo)session.getAttribute("user");
				if(user == null){
					response.sendRedirect("index.jsp");
				}else{
					// 根据当前用户进行购物车查询
					Order order = os.findByUser(user.getUserId());
					// 判断购物车是否存在此商品
					int p = ods.findByPid(pid,order.getOid());
					if(p > 0){
						// 将商品存进orderDetail 中
						OrderDetail orderdetail = new OrderDetail();
						orderdetail.setEid(order.getOid());
						orderdetail.setPid(pro.getPid());
						orderdetail.setCost(pro.getPrice());
						int odstemp = ods.add(orderdetail);
						if(odstemp > 0){
							response.sendRedirect("ShoppServlet?temp=list");
						}else{
							request.setAttribute("msg","购物车添加失败!");
							request.getRequestDispatcher("product-view.jsp").forward(request, response);
						}
					}else{
						response.sendRedirect("ShoppServlet?temp=list");
					}
					
				}
				
			}
		}
		
		if(temp.equals("list")){
			UserInfo user = (UserInfo)session.getAttribute("user");
			if(user != null){
				// 根据当前用户进行购物车查询
				Order order = os.findByUser(user.getUserId());
				// 建立一个容器
				Map<OrderDetail, Product> shopMap = new LinkedHashMap<>();
				// 根据购物车查询购物车内容
				String oid = order.getOid();
				List<OrderDetail> odlist = ods.findByOid(oid);
				if(odlist.size() != 0){
					// 如果有进入购物车
					for (OrderDetail odt : odlist) {
						int pid = odt.getPid();
						Product pr = productservice.findById(pid);
						shopMap.put(odt, pr);
					}
					request.setAttribute("shopMap", shopMap);
					request.getRequestDispatcher("shopping.jsp").forward(request, response);
				}else{
					// 如果购物车没有商品  跳转首页
					response.sendRedirect("index.jsp");
				}
			}
		}
		
		if(temp.equals("update")){
			PrintWriter out = response.getWriter();
			String numStr = request.getParameter("number");
			if(numStr != null){
				int num = Integer.parseInt(numStr);
				// 需要订单编号  商品ID 和 修改数量
				String idStr = request.getParameter("id");
				if(idStr != null){
					int id = Integer.parseInt(idStr);
					UserInfo user = (UserInfo)session.getAttribute("user");
					// 根据当前用户进行购物车查询
					Order order = os.findByUser(user.getUserId());
					int upnum = ods.update(order.getOid(),id,num);
					if(upnum > 0){
						// 成功后不做任何处理
					}else{
						out.write("修改失败");
					}
					out.flush();
					out.close();
				}
			}
			
		}
		
		if(temp.equals("delet")){
			PrintWriter out = response.getWriter();
			System.out.println("delet");
			// 需要订单编号 商品ID
			String idStr = request.getParameter("id");
			if (idStr != null) {
				int id = Integer.parseInt(idStr);
				UserInfo user = (UserInfo) session.getAttribute("user");
				// 根据当前用户进行购物车查询
				Order order = os.findByUser(user.getUserId());
				int upnum = ods.delet(order.getOid(), id);
				if (upnum > 0) {
					out.write("删除成功!");
				} else {
					out.write("删除失败!");
				}
				out.flush();
				out.close();
			}
		}
		
		// 添加订单
		if(temp.equals("pro")){
			// 创建容器
			Order order = new Order();
			OrderDetail od = new OrderDetail();
			
			// 商品ID
			int pid = (int) session.getAttribute("pid");
			System.out.println(pid);
			Product pro = productservice.findById(pid);
			od.setPid(pid);
			// 购买数量
			od.setQuantity(1);
			// 价格
			double price = pro.getPrice();
			od.setCost(price);
			// 制造单号
			String oid = UUID.randomUUID().toString().replace("-", "").substring(0, 13);
			order.setOid(oid);
			od.setEid(oid);
			// 获得当前用户
			UserInfo user = (UserInfo) session.getAttribute("user");
			order.setUserid(user.getUserId());
			// 获得地址
			String add = request.getParameter("address");
			order.setAddress(add);
			// 订单总价
			double cost = price*1;
			order.setCost(cost);
			// 增加订单操作
			int odtemp = os.creat(order);
			int odstemp = ods.add(od);
			if(odtemp > 0 && odstemp >0){
				response.sendRedirect("shopping-result.jsp");
			} else {
				request.setAttribute("msg", "订单提交失败!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		
		if(temp.equals("shop")){
			// 获得地址
			String add = request.getParameter("address");
			// 获得购物车的订单号
			UserInfo user = (UserInfo) session.getAttribute("user");
			Order order = os.findByUser(user.getUserId());
			String oid = order.getOid();
			// 修改购物车的状态 >>> 订单
			int ostemp = os.change(oid ,add);
			if(ostemp >0){
				// 减掉库存
				// 1.获取订单中的数据
				Map<Integer, Integer> shopmap = new LinkedHashMap<>();
				List<OrderDetail> odlist = ods.findByOid(oid);
				for (OrderDetail od : odlist) {
					shopmap.put(od.getPid(), od.getQuantity());
				}
				// 2.进行数据的修改
				@SuppressWarnings("unused")
				int gtemp = productservice.changeStock(shopmap);
				response.sendRedirect("shopping-result.jsp");
			} else {
				request.setAttribute("msg", "订单提交失败!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
