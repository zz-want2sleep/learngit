package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	Zhuce zhuce=new Zhuce();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Connection connection =DbConnect.getConnection();
		
		
		
		
	String admin=request.getParameter("uname");
	String pwd=request.getParameter("upwd");
	String rem=request.getParameter("rem");
	if("y".equals(rem)) {
		Cookie nameCookie =new Cookie("username",admin);
		Cookie pwdCookie =new Cookie("password", pwd);
		nameCookie.setMaxAge(60*60*24*3);
		pwdCookie.setMaxAge(60*60*60*3);
		response.addCookie(pwdCookie);
		response.addCookie(nameCookie);
	}
	
	
	if(session.getAttribute("loginName")!=null) {	
		ResultSet rSet1=null;
		String sql1=null;
		String name1=(String)session.getAttribute("loginName");
		if(name1.equals("管理员")) {
			 sql1="select * from guanli where name=?";
			 try {
					PreparedStatement pStatement = connection.prepareStatement(sql1);
					pStatement.setString(1, "admin");
					rSet1=pStatement.executeQuery();

					//session.setMaxInactiveInterval(7200);	
					
					rSet1.beforeFirst();
				session.setAttribute("rs", rSet1);
					
				RequestDispatcher rDispatche=request.getRequestDispatcher("管理员管理界面.jsp");
				rDispatche.forward(request, response);
					//response.sendRedirect("管理员管理界面.jsp");
					return;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("操作错误！");
					e.printStackTrace();
				     }
		}else {
			System.out.println("有错误！");
	 sql1="select * from users1 where name=?";}
	//rSet.absolute(1);
	try {
		PreparedStatement pStatement = connection.prepareStatement(sql1);
		pStatement.setString(1, (String)session.getAttribute("loginName"));
		rSet1=pStatement.executeQuery();

		//session.setMaxInactiveInterval(7200);
		
		session.setAttribute("rs1", rSet1);
		//response.sendRedirect("用户管理界面.jsp");
		RequestDispatcher rDispatche=request.getRequestDispatcher("用户管理界面.jsp");
		rDispatche.forward(request, response);
		return ;
	} catch (Exception e) {
		// TODO: handle exception
	
		e.printStackTrace();
	     }
	}	else {		
//	if(zhuce.bijiao(admin,pwd)) {
	
		String sql="select * from users1";
		
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			pStatement=connection.prepareStatement(sql);
			//pStatement.setString(1, admin);
			rSet=pStatement.executeQuery();
			ResultSet rSet1=null;
			String sql2="select * from users1 where name=?";
			//rSet.absolute(1);
			while(rSet.next()) {
				if(admin.equals(rSet.getString("name"))&&pwd.equals(rSet.getString("pwd"))){
			try {
				pStatement=connection.prepareStatement(sql2);
				pStatement.setString(1, admin);
				rSet1=pStatement.executeQuery();
				session.setMaxInactiveInterval(7200);
		while(rSet1.next()) {
			session.setAttribute("id", rSet1.getInt(1));
		}
				rSet1.beforeFirst();
				session.setAttribute("rs1", rSet1);
				session.setAttribute("loginName",admin);
				//response.sendRedirect("loginAction1.jsp");
				RequestDispatcher rDispatche=request.getRequestDispatcher("用户管理界面.jsp");
				rDispatche.forward(request, response);
				return;
			} catch (Exception e) {
				System.out.println("有错误！");
				// TODO: handle exception
				e.printStackTrace();
			     }
	
			  }
			}
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("error1.jsp");
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			System.out.println("有错误！");
			// TODO: handle exception
			
			e.printStackTrace();
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
