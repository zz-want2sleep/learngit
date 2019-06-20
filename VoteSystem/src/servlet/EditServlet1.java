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
 * Servlet implementation class EditServlet1
 */
@WebServlet("/EditServlet1")
public class EditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet1() {
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
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String education=request.getParameter("education");
		String occupation=request.getParameter("occupation");
		String []s=request.getParameterValues("specialty");
		String specialty=Zhuce.showSpecialty(s);
		String id=request.getParameter("id");
		String national =request.getParameter("national");
		String province =request.getParameter("province");
		String city =request.getParameter("city");
		String nation =national+" "+province+" "+city;
		Zhuce xg=new Zhuce(name, sex, specialty, education, occupation,Integer.parseInt(id));
		Connection connection=DbConnect.getConnection();
		String sql="update zhuce1 set name=?,sex=?,education=?,occupation=?,specialty=?,nation=? where id=?";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, xg.getName());
			pStatement.setString(2,xg.getSex() );
			pStatement.setString(3,xg.getEducation() );
			pStatement.setString(4,xg.getOccupation() );
			pStatement.setString(5,specialty );
			pStatement.setString(6, nation);
			pStatement.setInt(7, xg.getId());
			int i=pStatement.executeUpdate();
			HttpSession session=request.getSession();
			if(i==1) {
				String sql1="select * from zhuce1";
				pStatement=(PreparedStatement) connection.prepareStatement(sql1);
				rSet=pStatement.executeQuery();
			session.setMaxInactiveInterval(7200);
			session.setAttribute("rs", rSet);
			//response.sendRedirect("loginAction1.jsp");
			RequestDispatcher rDispatche=request.getRequestDispatcher("loginAction1.jsp");
			rDispatche.forward(request, response);
			}else {
				session.setAttribute("message", "修改失败！");
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
