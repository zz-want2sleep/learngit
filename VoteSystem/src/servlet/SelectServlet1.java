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
 * Servlet implementation class SelectServlet1
 */
@WebServlet("/SelectServlet1")
public class SelectServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet1() {
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
		String id=request.getParameter("id");
		String sql="select*from users1 where id=?";
		PreparedStatement pStatement=null;
		//Zhuce zhuce=new Zhuce();
		ResultSet rSet=null;
		String name;
		String pwd;
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			pStatement.setInt(1, Integer.parseInt(id));
			rSet=pStatement.executeQuery();
			//rSet.absolute(Integer.parseInt(id));
			rSet.next();
			 name=rSet.getString("name");
			 pwd=rSet.getString("pwd");
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("pwd", pwd);
			session.setAttribute("id", id);
			//zhuce.bijiao3(name, id);
			RequestDispatcher rd=request.getRequestDispatcher("密码修改.jsp");
			 rd.forward(request, response);
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
