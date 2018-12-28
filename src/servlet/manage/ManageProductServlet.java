package servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.CateGory;
import entity.PageBean;
import entity.Product;
import service.CateGoryService;
import service.ProductService;

public class ManageProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		int tep = 1;
		ProductService productservice = new ProductService();
		CateGoryService cgservice = new CateGoryService();
		String temp = request.getParameter("temp");
		// 产品页面的分类列表(通用)
		List<CateGory> parentlist = cgservice.findParent();
		Map<CateGory, List<CateGory>> cgmap = new LinkedHashMap<>();
		for (CateGory cg : parentlist) {
			int cid = cg.getCid();
			List<CateGory> childtlist = cgservice.findChildByParent(cid);
			cgmap.put(cg, childtlist);
		}
		// 产品列表
		if(temp.equals("list")){
			String noStr = request.getParameter("pno");
			if(noStr != null){
				tep = Integer.parseInt(noStr);
			}
			PageBean<Product> pagebean = productservice.findPage(tep,5);
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		// 产品修改界面的跳转
		if(temp.equals("modify")){
			String pidStr = request.getParameter("pid");
			if(pidStr != null){
				int pid = Integer.parseInt(pidStr);
				Product pro = productservice.findById(pid);
				request.setAttribute("pro", pro);
				request.setAttribute("cgmap", cgmap);
				request.getRequestDispatcher("product-modify.jsp").forward(request, response);
			}
		}
		// 新增产品页面的跳转
		if(temp.equals("add")){
			request.setAttribute("cgmap", cgmap);
			request.getRequestDispatcher("product-add.jsp").forward(request, response);
		}
		// 删除指定商品
		if(temp.equals("dele")){
			PrintWriter out = response.getWriter();
			String pidStr = request.getParameter("id");
			if(pidStr != null){
				int pid = Integer.parseInt(pidStr);
				int tp = productservice.dele(pid);
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
