package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
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
  HttpSession session=request.getSession(true);
  out.println("Session ID:"+session.getId()+"<br>");
  out.println("创建时间："+session.getCreationTime()+"<br>");
  out.println("有效时间："+session.getMaxInactiveInterval()+"s<br>");
  out.println("上次访问时间："+session.getLastAccessedTime()+"<br>");
  session.setAttribute("MySession", "Helllo Session!");
  Enumeration<?> sessions=session.getAttributeNames();
  out.print("Session的内容：<br>");
  while(sessions.hasMoreElements()) {
  	String str = (String)sessions.nextElement();
  	String value = (String) session.getAttribute(str);
  out.print(str+"="+value+"<br>");
  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
