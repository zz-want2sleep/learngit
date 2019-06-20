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
 * Servlet implementation class Login1
 */
@WebServlet("/Login1")
public class Login1 extends HttpServlet {
	Zhuce zhuce=new Zhuce();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1() {
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
		
		HttpSession session =request.getSession();
		String loginName=request.getParameter("loginName");
		int id=Integer.parseInt((String)session.getAttribute("id"));
		zhuce.bijiao3(loginName, (String)session.getAttribute("pwd"));
		if(zhuce.bijiao2(loginName)){
			session.setAttribute("message", "用户名已经被注册!");
			response.sendRedirect("error5.jsp");
		}else {
		String pWD=request.getParameter("PWD");
request.setAttribute("loginName", loginName);	
			zhuce.setLoginName(loginName);
		request.setAttribute("PWD", pWD);
		zhuce.setPWD(pWD);
		Connection connection=DbConnect.getConnection();
		String sql="update users1 set name=?,pwd=? where id=?";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		
	try {
		pStatement=(PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, loginName);
		pStatement.setString(2, pWD);
		pStatement.setInt(3,id);
		int i=pStatement.executeUpdate();
		if(i==1) {
			String sql1="select* from users1 where id=?";

				pStatement=(PreparedStatement) connection.prepareStatement(sql1);
				pStatement.setInt(1,id);
				rSet=pStatement.executeQuery();
			session.setMaxInactiveInterval(7200);//session存在时间
			//request.setAttribute("rs1", rSet);
			session.setAttribute("rs1", rSet);
			session.setAttribute("loginName", loginName);
			while(rSet.next()) {
				if(loginName.equals(rSet.getString("name"))) {
			session.setAttribute("id", rSet.getInt("id"));
	rSet.absolute(1);
				break;
				}
			}
			 RequestDispatcher rd=request.getRequestDispatcher("用户管理界面.jsp");
			 rd.forward(request, response);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		 RequestDispatcher rd=request.getRequestDispatcher("error3.jsp");
		 rd.forward(request, response);
	}
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
