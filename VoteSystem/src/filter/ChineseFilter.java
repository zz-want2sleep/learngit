package filter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class ChineseFilter implements Filter{
private FilterConfig fc;
private String encodingName;
private boolean enable;
@Override
public void destroy() {
}
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	if(enable==true) {
request.setCharacterEncoding(encodingName);
response.setCharacterEncoding(encodingName);
	}
	chain.doFilter(request, response);
}
@Override
public void init(FilterConfig filterConfig) throws ServletException {
	// TODO Auto-generated method stub
	this.fc=filterConfig;
	encodingName=fc.getInitParameter("encoding");
	enable=Boolean.valueOf(fc.getInitParameter("enable"));
}
}
