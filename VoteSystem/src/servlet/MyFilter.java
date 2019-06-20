package servlet;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
private FilterConfig fc;
private String encodingName;
private boolean enable;
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
	    throws IOException, ServletException {
		// TODO Auto-generated method stub
if(enable==true) {
	arg0.setCharacterEncoding(encodingName);
	arg1.setCharacterEncoding(encodingName);
}
arg2.doFilter(arg0, arg1);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		this.fc=filterConfig;
		encodingName=fc.getInitParameter("encoding");
		enable=Boolean.valueOf(fc.getInitParameter("enable"));
	}

}
