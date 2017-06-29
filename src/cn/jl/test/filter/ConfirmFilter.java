package cn.jl.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * 判断当前Session是否有用户登录信息
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 非法请求,跳转到登录界面
		if (req.getSession().getAttribute("auth") == null) {
			// 保存当前用户想要去的url地址
			//	System.out.println("http://localhost:8080/SSH/confirm/confirm.html?a=xxx&b=yyy");

			/*
			 * System.out.println(req.getServletPath()); // /confirm/confirm.html
			 * System.out.println(req.getRealPath("/")); // D:\lolog\tomcat\tomcat6.x\webapps\SSH\
			 * System.out.println(req.getContextPath()); // /SSH
			 * System.out.println(req.getQueryString()); // a=xxx&b=yyy
			 */
			
			String goUrl = req.getServletPath();
			String param = req.getQueryString();
			if(param != null) {
				goUrl = goUrl + "?" + param;
			}
			// 把当前客户想要访问的地址存储到Session中
			req.getSession().setAttribute("goUrl", goUrl);
			System.out.println("goUrl:"+goUrl);
			req.getSession().setAttribute("error", "非法请求,请登录");
			resp.sendRedirect(req.getContextPath() + "/user/login.jsp");
		} else {
			// 继续执行下一个拦截器,或者跳转到目标页面
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
