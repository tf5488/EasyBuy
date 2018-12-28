package servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Oder;
import entity.PageBean;
import service.OrderService;

public class ManageOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderservice = new OrderService();
		String temp = request.getParameter("temp");
		// 订单列表分页
		if(temp.equals("list")){
			PageBean<Map<Oder, List<Oder>>> pagebean = null;
			int pno1 = 1;
			String pno = request.getParameter("pno");
			if(pno != null){
				pno1 = Integer.parseInt(pno);
			}
			pagebean = orderservice.findPage(pno1,2);
			request.setAttribute("pagebean", pagebean);
			request.setAttribute("tp", "list");
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
		// 查找指定订单  (模糊查询)
		if(temp.equals("find")){
			PageBean<Map<Oder, List<Oder>>> pagebean = null;
			int pno1 = 1;
			String pno = request.getParameter("pno");
			if(pno != null){
				pno1 = Integer.parseInt(pno);
			}
			String entityIdStr = request.getParameter("entityId");
			String userName = request.getParameter("userName");
			String tt = null;
			if(entityIdStr != "" && entityIdStr != null){
				int entityId = Integer.parseInt(entityIdStr);
				pagebean = orderservice.findPageById(pno1,2,entityId);
				tt = "&entityId="+entityIdStr;
			}
			if(userName != ""){
				pagebean = orderservice.findPage(pno1,2,userName);
				tt = "&userName="+userName;
			}
			request.setAttribute("pagebean", pagebean);
			request.setAttribute("tp", "find");
			request.setAttribute("tt", tt);
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
		// 修改指定新闻
		if(temp.equals("change")){
			PrintWriter out = response.getWriter();
			String oid = request.getParameter("oid");
			String tp = request.getParameter("tp");
			int changetemp = orderservice.changeStu(oid, tp);
			if(changetemp > 0){
				out.write("修改成功!");
			}else{
				out.write("修改失败!");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
