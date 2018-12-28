package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserInfo;
import service.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = request.getParameter("userId");
		String password = request.getParameter("password");
		String randnum = (String) session.getAttribute("numrand");
		String code = request.getParameter("code");
		String msg = null;
		// 验证码的判断
		if(randnum.equals(code)){
			UserService userservice = new UserService();
			UserInfo user = userservice.findById(userName);
			String temp = null;
			if(user != null){
				temp = user.getUserPwd();
			}
			// 登陆用户信息的判断
			if (password.equals(temp)) {
				session.setAttribute("user", user);
				// 设置session有效时长
				session.setMaxInactiveInterval(60*60*24*30);
				response.sendRedirect("index.jsp");
			} else {
				msg = "用户名或密码错误!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			msg = "验证码错误!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
