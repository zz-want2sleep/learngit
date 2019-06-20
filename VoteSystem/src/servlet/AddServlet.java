package servlet;

import java.io.IOException;
import servlet.Zhuce;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		try {
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String education=request.getParameter("education");
		String occupation=request.getParameter("occupation");
		String []strings=request.getParameterValues("specialty");
		String specialty=Zhuce.showSpecialty(strings);
		String national =request.getParameter("national");
		String province =request.getParameter("province");
		String city =request.getParameter("city");
		String nation =national+" "+province+" "+city;
		Zhuce tj=new Zhuce(name, sex, specialty, education, occupation);
		Connection connection=DbConnect.getConnection();
		String sql="insert into zhuce1(name,sex,education,occupation,specialty,nation) values(?,?,?,?,?,?)";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, tj.getName());
			pStatement.setString(2, tj.getSex());
			pStatement.setString(3, tj.getEducation());
			pStatement.setString(4, tj.getOccupation());
			pStatement.setString(5, specialty);
			pStatement.setString(6, nation);
			int i=pStatement.executeUpdate();
			HttpSession session =request.getSession();
			if(i==1) {
				String sql1="select* from zhuce1";
				pStatement=(PreparedStatement) connection.prepareStatement(sql1);
				rSet=pStatement.executeQuery();
			session.setMaxInactiveInterval(7200);
			session.setAttribute("rs", rSet);
			response.sendRedirect("loginAction.jsp");
			}
			else {
				session.setAttribute("message", "添加失败！");
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("error2.jsp");
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
