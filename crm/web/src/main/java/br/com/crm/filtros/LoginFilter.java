package br.com.crm.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	
	private static final String PAGINA_LOGIN = "/crm/pages/login.xhtml";
	private static final String USUARIO = "usuario";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse res = (HttpServletResponse) response;
		if (req.getSession().getAttribute(USUARIO) == null) {
			res.sendRedirect(PAGINA_LOGIN);
		} else {
			chain.doFilter(request, response);
		}		
	}

	@Override
	public void destroy() {
		
	}

}
