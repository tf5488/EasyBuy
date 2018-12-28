package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Address;
import entity.UserInfo;

public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressService ads = new AddressService();
		HttpSession session = request.getSession();
		// 获取当前用户
		UserInfo user = (UserInfo) session.getAttribute("user");
		if(user != null){
			int uid = user.getUserId();
			
			String temp = request.getParameter("temp");
			if(temp.equals("add")){
				PrintWriter out = response.getWriter();
				String val = request.getParameter("val");
				int tp = ads.add(uid,val);
				if(tp > 0){
					out.write("添加成功!");
				}else{
					out.write("添加失败!");
				}
				out.flush();
				out.close();
			}
			
			if(temp.equals("list")){
				List<Address> adlist = ads.findByUid(uid);
				String tt = request.getParameter("tt");
				String pidStr = request.getParameter("pid");;
				if(pidStr != null){
					int pid = Integer.parseInt(pidStr);
					session.setAttribute("pid", pid);
				}
				request.setAttribute("tt",tt);
				request.setAttribute("adlist",adlist);
				request.getRequestDispatcher("address.jsp").forward(request, response);
			}
		}else{
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
