package servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageBean;
import entity.UserInfo;
import service.UserService;

public class ManageIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userservice = new UserService();
		
		int pno1 = 1;
		String temp = request.getParameter("temp");
		// 首页用户列表
		if(temp.equals("list")){
			String pno = request.getParameter("pno");
			if(pno != null){
				pno1 = Integer.parseInt(pno);
			}
			PageBean<UserInfo> pagebean = userservice.findByPcidPage(pno1,5);
			
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		//用户修改页面
		if(temp.equals("modify")){
			String uname = request.getParameter("uname");
			UserInfo user = userservice.findById(uname);
			request.setAttribute("user", user);
			request.getRequestDispatcher("user-modify.jsp").forward(request, response);
		}
		//用户信息修改
		if(temp.equals("change")){
			UserInfo user = new UserInfo();
			String userid = request.getParameter("uid");
			if(userid != null){
				int userId = Integer.parseInt(userid);
				user.setUserId(userId);
			}
			String userName = request.getParameter("userName");
			String name = request.getParameter("name");
			String passWord = request.getParameter("passWord");
			String sex = request.getParameter("sex");
			if(sex != null){
				int sex1 = Integer.parseInt(sex);
				user.setUserSex(sex1);
			}
			String birthyear = request.getParameter("birthyear");
			String birthmonth = request.getParameter("birthmonth");
			String birthday = request.getParameter("birthday");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String status = request.getParameter("status");
			if(status != null){
				int stat = Integer.parseInt(status);
				user.setStatus(stat);
			}
			String birth = birthyear+"-"+birthmonth+"-"+birthday;
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			try {
				date = format.parse(birth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date time = new Date(date.getTime());
			
			user.setUsername(userName);
			user.setNickName(name);
			user.setUserPwd(passWord);
			user.setBirthday(time);
			user.setMobile(mobile);
			user.setAddress(address);
			
			int tep = userservice.change(user);
			if(tep > 0){
				response.sendRedirect("manage-result.jsp");
			}else{
				System.out.println("用户信息更新失败!");
			}
		}
		//用户修改页面
		if (temp.equals("dele")) {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("id");
			if(username != null){
				int tp = userservice.dele(username);
				if(tp > 0){
					out.write("删除成功!");
				}else{
					out.write("删除失败!");
				}
				out.flush();
				out.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
