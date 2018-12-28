package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.UserInfo;

import service.UserService;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7272670058153599805L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		UserService userservice = new UserService();
		String temp = request.getParameter("temp");
		if(temp.equals("verify")){
			String username = request.getParameter("userId");
			UserInfo user = userservice.findById(username);
			boolean msg = true;
			if(user != null){
				msg = true; // 不能用
			}else{
				msg=  false; // 能用
			}
			String jsonStr = JSON.toJSONString(msg);
			out.println(jsonStr.toString());
			out.flush();
			out.close();
		}
		if(temp.equals("reqister")){
			String username = request.getParameter("userId");
			String nickName = request.getParameter("userName");
			String userPwd = request.getParameter("password");
			String sexname = request.getParameter("sex");
			int userSex = 0;
			if(sexname != null){
				userSex = Integer.parseInt(sexname);
			}
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			String birth = request.getParameter("birthday");
			Date birthday = null;
			try {
				birthday = format.parse(birth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String identityCode = request.getParameter("identityCode");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			int status = 0;
			int tmp = userservice.newuser(username,nickName,userPwd,userSex,birthday,identityCode,email,mobile,address,status);
			if(tmp != 0){
				UserInfo user = userservice.findById(username);
				request.getSession().setAttribute("user", user);
				request.getSession().setMaxInactiveInterval(60*60*30);
				response.sendRedirect("reg-result.jsp");
			}else{
				String msg = "用户注册失败,请重新注册!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
		
	}

}
