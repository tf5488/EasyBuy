package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageBean;
import entity.Product;
import service.ProductService;

public class ProListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tep = 1;
		ProductService productservice = new ProductService();
		String noStr = request.getParameter("pageno");
		if(noStr != null){
			tep = Integer.parseInt(noStr);
		}
		PageBean<Product> pagebean = productservice.findPage(tep,8);
		
		request.setAttribute("pagebean", pagebean);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
