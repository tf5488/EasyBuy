package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Comment;
import entity.PageBean;
import service.CommentService;

public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService coservice = new CommentService();
		
		int pno1 = 1;
		PageBean<Comment> pagebean = null;
		String flag = request.getParameter("flag");
		if(flag.equals("page")){
			String pno = request.getParameter("pno");
			if(pno != null){
				pno1 = Integer.parseInt(pno);
			}
			pagebean = coservice.findByPcidPage(pno1,3);
		}
		
		
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
