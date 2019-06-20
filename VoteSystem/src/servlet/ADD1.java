package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Dao;
import entity.UserRecoder;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ADD1
 */
@WebServlet("/ADD1")
public class ADD1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<UserRecoder> list;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADD1() {
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
  		String sql1="select * from zhuce1 where id=?";
  		HttpSession session =request.getSession();
  		String userName=(String) session.getAttribute("loginName");
  		String id1=request.getParameter("id");
  		int id=Integer.parseInt(id1);
  		String sp;
  		try {
  				pStatement=(PreparedStatement) connection.prepareStatement(sql1);
  				pStatement.setInt(1,id);
  				rSet=pStatement.executeQuery();
  				session.setMaxInactiveInterval(7200);
  				session.setAttribute("rs0", rSet);
  				while(rSet.next()) {
  				sp=rSet.getString("specialty");
  				session.setAttribute("sp", sp);		
  				}
  				//request.setAttribute("list", rSet); 				
  			//session.setMaxInactiveInterval(7200);
  			//session.setAttribute("rs", rSet);		
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  			session.setAttribute("message", "显示信息失败！");
  			RequestDispatcher rDispatche=request.getRequestDispatcher("error4.jsp");
  			rDispatche.forward(request, response);
	 		}
  		Dao dao=new Dao();
	       list=dao.findUserRecoderByUserName(userName);
		request.setAttribute("list", list);
		for(UserRecoder list:list) {
			System.out.println(list.getrTime());
		}
  		RequestDispatcher rDispatche=request.getRequestDispatcher("用户基本信息.jsp");
			rDispatche.forward(request, response);	 
  	}
  	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
