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
 * Servlet implementation class ADD2
 */
@WebServlet("/ADD2")
public class ADD2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADD2() {
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
	
		Connection connection=DbConnect.getConnection();
		PreparedStatement pStatement=null;
		ResultSet rSet=null;	
		String sql1="select* from guanli ";
		HttpSession session =request.getSession();
	
		try {
				pStatement=(PreparedStatement) connection.prepareStatement(sql1);
				rSet=pStatement.executeQuery();
				session.setMaxInactiveInterval(7200);
				session.setAttribute("rs0", rSet);
			//session.setMaxInactiveInterval(7200);
			//session.setAttribute("rs", rSet);
			RequestDispatcher rDispatche=request.getRequestDispatcher("管理员修改密码.jsp");
			rDispatche.forward(request, response);
				
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.setAttribute("message", "显示信息失败！");
			RequestDispatcher rDispatche=request.getRequestDispatcher("error4.jsp");
			rDispatche.forward(request, response);
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
