package br.com.crm.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Classe Filter que converte os caracteres para o formato utf-8
 */
 /*
	Configuração a ser adicionada no web.xml:
	
  	<filter>
  		<filter-name>CharSetFilter</filter-name>
  		<filter-class>br.com.project.CharSetFilter</filter-class>
  			<init-param>
   			<param-name>requestEncoding</param-name>
   			<param-value>UTF-8</param-value>
  		</init-param>
 	</filter>
 
 	<filter-mapping>
  		<filter-name>CharSetFilter</filter-name>
  		<url-pattern>/*</url-pattern>
 	</filter-mapping>
*/	
public class CharSetFilter implements Filter
{
	/**
	 * Armazena o encoding a ser usado
	 */
	private String encoding;

	/**
	 * Pega o encode da requisição, caso seja informado seta como padrão utf-8
	 */
	public void init(FilterConfig config) throws ServletException
	{
		encoding = config.getInitParameter("requestEncoding");

		if (encoding == null)
			encoding = "UTF-8";
	}

	/**
	 * Seta a codificação para a resposta (ServletResponse)	 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException,
			ServletException
	{
		if (null == request.getCharacterEncoding())
			request.setCharacterEncoding(encoding);

		/**
		 * Set the default response content type and encoding
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		next.doFilter(request, response);
	}

	public void destroy()
	{
	}
}