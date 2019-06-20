package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
	String admin=request.getParameter("uname0");
	String pwd=request.getParameter("upwd0");
	String pwd0;
	Connection connection =DbConnect.getConnection();
		String sql="select*from guanli";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			rSet=pStatement.executeQuery();
			rSet.absolute(1);
		 pwd0=rSet.getString("pwd");
	
		if(admin.equals("admin")&&pwd.equals(pwd0)) {
			HttpSession session =request.getSession();
			String sql1="select*from users1";
			try {
				pStatement=(PreparedStatement) connection.prepareStatement(sql1);
				rSet=pStatement.executeQuery();
				session.setMaxInactiveInterval(7200);
				session.setAttribute("rs", rSet);
				session.setAttribute("loginName","管理员");
				//response.sendRedirect("loginAction1.jsp");
				RequestDispatcher rDispatche=request.getRequestDispatcher("管理员管理界面.jsp");
				rDispatche.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			response.sendRedirect("error0.jsp");
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	//}
//	else {
		//response.sendRedirect("error.jsp");
	}
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
