package servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.News;
import entity.PageBean;
import service.NewsService;

public class ManageNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService newservice = new NewsService();
		
		int pno1 = 1;
		PageBean<News> pagebean = null;
		String temp = request.getParameter("temp");
		// 后台新闻列表
		if(temp.equals("list")){
			String pno = request.getParameter("pno");
			if(pno != null){
				pno1 = Integer.parseInt(pno);
			}
			pagebean = newservice.findByPcidPage(pno1,8);
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("news.jsp").forward(request, response);
		}
		if(temp.equals("modify")){
			String nidStr = request.getParameter("nid");
			if(nidStr != null){
				int nid = Integer.parseInt(nidStr);
				News news = newservice.findByNid(nid);
				request.setAttribute("news", news);
				request.getRequestDispatcher("news-modify.jsp").forward(request, response);
			}
		}
		// 新闻修改
		if(temp.equals("change")){
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String nidStr = request.getParameter("nid");
			if(nidStr != null){
				int nid = Integer.parseInt(nidStr);
				int tep = newservice.changeNews(nid,title,content);
				if(tep > 0){
					response.sendRedirect("manage-result.jsp");
				}else{
					System.out.println("新闻修改失败!");
				}
				
			}
			
		}
		// 增加新闻
		if(temp.equals("add")){
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int tep = newservice.addNews(title, content);
			if (tep > 0) {
				response.sendRedirect("manage-result.jsp");
			} else {
				System.out.println("新闻增加失败!");
			}
		}
		// 删除新闻
		if(temp.equals("dele")){
			PrintWriter out = response.getWriter();
			String pidStr = request.getParameter("id");
			if(pidStr != null){
				int pid = Integer.parseInt(pidStr);
				int tp = newservice.dele(pid);
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
