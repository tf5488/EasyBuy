package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import entity.Order;
import entity.OrderDetail;
import entity.UserInfo;
import service.OrderDetailService;
import service.OrderService;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2812036443380895818L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		OrderService orderservice = new OrderService();
		OrderDetailService ods = new OrderDetailService();
		// 获取当前用户
		UserInfo user = (UserInfo)session.getAttribute("user");
		String temp = request.getParameter("temp");
		if(user != null){
			String jsonStr = null;
			if(temp.equals("user")){
				// top部分的显示用户昵称以及购物车数量
				jsonStr = JSON.toJSONString(user);
				out.print(jsonStr.toString());
			}else if(temp.equals("order")){
				Order order = orderservice.findByUser(user.getUserId());
				// 判断购物车是否存在
				if(order.getOid() == null){
					Order od = new Order();
					String oid = UUID.randomUUID().toString().replace("-", "").substring(0, 13);
					od.setUserid(user.getUserId());
					od.setOid(oid);
					od.setStatus(0);
					od.setType(1);
					// 初始化购物车
					int ostemp = orderservice.add(od);
					if(ostemp > 0 ){
						response.sendRedirect("UserServlet?temp=order");
					}else{
						request.setAttribute("msg","购物车初始化失败!");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}else{
					String oid = order.getOid();
					List<OrderDetail> odlist = ods.findByOid(oid);
					// 用于显示top的购物车数量
					jsonStr = JSON.toJSONString(odlist.size());
					out.print(jsonStr.toString());
				}
				
			}
		}
		out.flush();
		out.close();
	}

}
