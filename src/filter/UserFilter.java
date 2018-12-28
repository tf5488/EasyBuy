package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserInfo;

public class UserFilter implements Filter {


	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		
		UserInfo user = (UserInfo) session.getAttribute("user");
		if(user!=null){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect("../index.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
