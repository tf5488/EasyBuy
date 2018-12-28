package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.News;
import service.NewsService;

public class NewsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService newservice = new NewsService();
		String temp = request.getParameter("nid");
		if(temp != null){
			int nid = Integer.parseInt(temp);
			News news = newservice.findByNid(nid);
			request.setAttribute("news", news);
			request.getRequestDispatcher("news-view.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
