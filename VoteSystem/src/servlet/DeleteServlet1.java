package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class DeleteServlet1
 */
@WebServlet("/DeleteServlet1")
public class DeleteServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet1() {
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
		PrintWriter out=response.getWriter();
		Connection connection=DbConnect.getConnection();
		String id=request.getParameter("id");
		String sql="delete from users1 where id=?";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		//Zhuce zhuce=null;
		HttpSession session=request.getSession();
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
		  pStatement.setInt(1, Integer.parseInt(id));
int i=pStatement.executeUpdate();
if(i==1) {
	String sql1="select *from users1";
	pStatement=(PreparedStatement) connection.prepareStatement(sql1);
rSet=pStatement.executeQuery();	
session.setMaxInactiveInterval(7200);
session.setAttribute("rs", rSet);
RequestDispatcher rDispatche=request.getRequestDispatcher("管理员管理界面.jsp");
rDispatche.forward(request, response);
//response.sendRedirect("管理员管理界面.jsp");
}else
{
	session.setAttribute("message", "删除失败！");
	response.sendRedirect("error.jsp");
}
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
