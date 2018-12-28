package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Product;
import service.ProductService;

public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService productservice = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pro = request.getParameter("pro");
		Product product = null;
		if(pro != null){
			int prono = Integer.parseInt(pro);
			product = productservice.findById(prono);
			Cookie cook = null;
			Cookie[] cooks = request.getCookies();
			for (Cookie cookie : cooks) {
				if (cookie.getName().equals("prock")) {
					cook = cookie;
					String newValue = cook.getValue() + prono+",";
					cook.setValue(newValue);
					//System.out.println(newValue);
					break;
				}
			}
			if(cook == null){
				cook = new Cookie("prock", prono+",");
				//System.out.println(cook.getValue());
			}
				
			
			response.addCookie(cook);
			request.setAttribute("product", product);
			
			request.getRequestDispatcher("product-view.jsp").forward(request, response);
			
			
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
