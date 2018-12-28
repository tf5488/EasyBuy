package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageBean;
import entity.Product;
import service.ProductService;

public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productservice = new ProductService();
		
		int pno1 = 1;
		PageBean<Product> pagebean = null;
		
		
		String cid = request.getParameter("cid");
		String pno = request.getParameter("pno");
		if(pno != null){
			pno1 = Integer.parseInt(pno);
		}
		if(cid != null ){
			int cid1 = Integer.parseInt(cid);
			//System.out.println(cid1);
			//System.out.println(pno1);
			pagebean = productservice.findByPcidPage(cid1,pno1);
		}
		
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("cid", cid);
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
