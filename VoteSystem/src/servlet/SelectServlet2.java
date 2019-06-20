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
 * Servlet implementation class SelectServlet2
 */
@WebServlet("/SelectServlet2")
public class SelectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet2() {
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
		String pwd=request.getParameter("pwd");
		String sql="update guanli set pwd=?";
		String sql1="select* from guanli";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1,pwd);
			int i=pStatement.executeUpdate();
			if(i==1) {
				try {
					pStatement=(PreparedStatement) connection.prepareStatement(sql1);
					rSet=pStatement.executeQuery();
					rSet.absolute(1);
					 pwd=rSet.getString("pwd");
					HttpSession session=request.getSession();
					//session.setAttribute("pwd", pwd);
					session.setAttribute("rs0", rSet);
					//zhuce.bijiao3(name, id);
					RequestDispatcher rd=request.getRequestDispatcher("管理员修改密码.jsp");
					 rd.forward(request, response);}
				 catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
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
