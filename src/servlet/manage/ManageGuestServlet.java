package servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comment;
import entity.PageBean;
import service.CommentService;

public class ManageGuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentService coservice = new CommentService();
		
		int pno1 = 1;
		PageBean<Comment> pagebean = null;
		String temp = request.getParameter("temp");
		// 留言的分页显示
		if(temp.equals("list")){
			String pno = request.getParameter("pno");
			if (pno != null) {
				pno1 = Integer.parseInt(pno);
			}
			pagebean = coservice.findByPcidPage(pno1,6);
			
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);
		}
		
		// 用于跳转修改页面
		if(temp.equals("modify")){
			String ecidStr = request.getParameter("ecid");
			if(ecidStr != null){
				int ecid = Integer.parseInt(ecidStr);
				Comment comm = coservice.findById(ecid);
				request.setAttribute("comm", comm);
				request.getRequestDispatcher("guestbook-modify.jsp").forward(request, response);
			}
		}
		
		// 回复和修改留言
		if(temp.equals("change")){
			String ecidStr = request.getParameter("ecid");
			String replyContent = request.getParameter("replyContent");
			if(ecidStr != null){
				int ecid = Integer.parseInt(ecidStr);
				int tep = coservice.change(ecid,replyContent);
				if(tep > 0){
					response.sendRedirect("manage-result.jsp");
				}else{
					System.out.println("留言操作失败!");
				}
			}
		}
		
		// 删除留言
		if(temp.equals("dele")){
			PrintWriter out = response.getWriter();
			String pidStr = request.getParameter("id");
			if(pidStr != null){
				int pid = Integer.parseInt(pidStr);
				int tp = coservice.dele(pid);
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
