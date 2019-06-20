package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OurselfInfo
 */
@WebServlet("/OurselfInfo")
public class OurselfInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OurselfInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
  PrintWriter out=response.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<title>请求对象自身信息</title>");
out.println("</head>");
out.println("<body>");
out.println("使用Servlet获取发出请求对象信息<br>");
out.println("表单提交方式："+request.getMethod()+"<br>");
out.println("使用协议："+request.getProtocol()+"<br>");
out.println("Remote 主机："+request.getRemoteAddr()+"<br>");
out.println("Servlet地址："+request.getRequestURI()+"<br>");
out.println("</font></body>");
out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
