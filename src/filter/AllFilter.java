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

public class AllFilter implements Filter {

	public void destroy() {
		System.out.println("销毁过滤器!");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//System.out.println("过滤器作用!");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化过滤器!");
	}

}
