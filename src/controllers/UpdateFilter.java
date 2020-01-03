package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UpdateFilter
 */
@WebFilter("/UserUpdate")
public class UpdateFilter implements Filter
{

	/**
	 * Default constructor.
	 */
	public UpdateFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		// place your code here
		if (request.getParameter("firstname").isEmpty() && request.getParameter("lastname").isEmpty()
				&& request.getParameter("email").isEmpty() && request.getParameter("pwd").isEmpty()) {
			out.print("<script>alert('Empty form cannot be submitted'); window.location = 'index.jsp'</script>");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

}
