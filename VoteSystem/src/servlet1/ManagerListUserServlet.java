package servlet1;

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

import servlet.DbConnect;

/**
 * Servlet implementation class ManagerListUserServlet
 */
@WebServlet("/ManagerListUserServlet")
public class ManagerListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerListUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection =DbConnect.getConnection();
		String sql="select*from guanli";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		HttpSession session =request.getSession();
		if(session.getAttribute("loginName").equals("管理员")) {
			
			String sql1="select*from users1";
			try {
				pStatement=(PreparedStatement) connection.prepareStatement(sql1);
				rSet=pStatement.executeQuery();
				session.setMaxInactiveInterval(7200);
				session.setAttribute("rs", rSet);
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
