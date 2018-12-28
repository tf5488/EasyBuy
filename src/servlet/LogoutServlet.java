package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5967081510030254471L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 失效session
		request.getSession().invalidate();
		Cookie[] cook = request.getCookies();
		// 失效cookie 近期预览
		for (Cookie cookie : cook) {
			if(cookie.getName().equals("prock")){
				cookie.setMaxAge(0);
			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
