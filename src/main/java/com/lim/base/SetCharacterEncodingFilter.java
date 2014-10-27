package com.lim.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetCharacterEncodingFilter implements Filter {
	
	private String encoding ="";
	
	public void destroy() {
		// TODO Auto-generated method stub

	} 

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		 request.setCharacterEncoding(encoding);
		 response.setCharacterEncoding(encoding);
		 filterChain.doFilter(request, response);
			
		/*// Session属于http范畴，把以ServletRequest对象需要先转换成HttpServletRequest对象
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		 
		String contextPath = req.getContextPath();
		String url = req.getRequestURI();
		int pathLength = contextPath.length();
		// 如果session不为空，则可以浏览其它页面
		if (session.getAttribute("username") != null || url.length() == pathLength + 1) {
			filterChain.doFilter(request, response);
		} else {
				req.getRequestDispatcher("/error.jsp").forward(request, response);
		}*/

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		encoding= filterConfig.getInitParameter("encoding");
	}

}
