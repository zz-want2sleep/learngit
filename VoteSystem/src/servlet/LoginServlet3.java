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
 * Servlet implementation class Loginservlet3
 */
@WebServlet("/LoginServlet3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet3() {
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
	
		Connection connection =DbConnect.getConnection();
		String sql="select * from guanli";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			rSet=pStatement.executeQuery();
			HttpSession session =request.getSession();
			session.setMaxInactiveInterval(7200);
			session.setAttribute("rs", rSet);
			//response.sendRedirect("loginAction1.jsp");
			RequestDispatcher rDispatche=request.getRequestDispatcher("loginAction2.jsp");
			rDispatche.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
