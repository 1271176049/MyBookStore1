package edu.sdp.com.manager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class HttpFilter implements Filter {
	private FilterConfig filterConfig;

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public HttpFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		doFilter(req, resp, chain);
	}

	public abstract void doFilter(HttpServletRequest reqeust, HttpServletResponse response, FilterChain chain);

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

	public void init() {

	};
}
