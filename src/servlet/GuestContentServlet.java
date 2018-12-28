package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserInfo;
import service.CommentService;

public class GuestContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = null;
		HttpSession session = request.getSession();
		CommentService coservice = new CommentService();
		
		UserInfo user = (UserInfo) session.getAttribute("user");
		if (user != null) {
			String guestName = user.getUsername();
			String guestContent = request.getParameter("guestContent");
			msg = coservice.creatcomm(guestName, guestContent);
		}
		
		request.setAttribute("msg",msg);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
