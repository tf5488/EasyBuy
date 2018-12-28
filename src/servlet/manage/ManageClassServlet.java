package servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.CateGory;
import entity.PageBean;
import service.CateGoryService;

public class ManageClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CateGoryService cgservice = new CateGoryService();
		String temp = request.getParameter("temp");
		// 商品分类列表
		if(temp.equals("list")){
			int pno = 1;
			PageBean<CateGory> pagebean = null;
			String pnoStr = request.getParameter("pno");
			if(pnoStr!= null){
				pno = Integer.parseInt(pnoStr);
			}
			pagebean = cgservice.findPage(pno,8);
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("productClass.jsp").forward(request, response);
		}
		//商品分类修改页面数据
		if(temp.equals("modify")){
			CateGory cg = null;
			String cidStr = request.getParameter("cid");
			if(cidStr!= null){
				int cid = Integer.parseInt(cidStr);
				// 子类对象
				cg = cgservice.findById(cid);
				request.setAttribute("cg", cg);
				// 页面的父类选择
				List<CateGory> cglist = cgservice.findParent();
				request.setAttribute("cglist", cglist);
				
				request.getRequestDispatcher("productClass-modify.jsp").forward(request, response);
			}
		}
		//商品分类修改
		if(temp.equals("change")){
			String pidStr = request.getParameter("parentId");
			String className = request.getParameter("className");
			if(pidStr!= null){
				int pid = Integer.parseInt(pidStr);
				String cidStr = request.getParameter("cid");
				if(cidStr != null){
					int cid = Integer.parseInt(cidStr);
					int i = cgservice.change(cid,className,pid);
					if(i > 0){
						response.sendRedirect("manage-result.jsp");
					}else{
						System.out.println("分类修改失败!");
					}
				}
			}
		}
		// 增加页面的分类显示
		if(temp.equals("addlist")){
			List<CateGory> cglist = cgservice.findParent();
			request.setAttribute("cglist", cglist);
			request.getRequestDispatcher("productClass-add.jsp").forward(request, response);
		}
		// 新建分类
		if(temp.equals("add")){
			String pidStr = request.getParameter("parentId");
			String className = request.getParameter("className");
			if(pidStr!= null){
				int pid = Integer.parseInt(pidStr);
				int i = cgservice.addClass(className, pid);
				if (i > 0) {
					response.sendRedirect("manage-result.jsp");
				} else {
					System.out.println("分类新建失败!");
				}
			}
		}
		// 删除
		if (temp.equals("dele")) {
			PrintWriter out = response.getWriter();
			String pidStr = request.getParameter("id");
			if (pidStr != null) {
				int pid = Integer.parseInt(pidStr);
				int tp = cgservice.dele(pid);
				if (tp > 0) {
					out.write("删除成功!");
				} else {
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
