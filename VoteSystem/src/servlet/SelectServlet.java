package servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
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
		String sql="select*from zhuce1 where id=?";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		Zhuce zhuce=null;
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			pStatement.setInt(1, Integer.parseInt(id));
			rSet=pStatement.executeQuery();
			String specialty="";
			String nation="";
			while(rSet.next()) {
				String name=rSet.getString("name");
				String sex=rSet.getString("sex");
				String education=rSet.getString("education");
				String occupation=rSet.getString("occupation");
				nation=rSet.getString("nation");
			 specialty=rSet.getString("specialty");
				zhuce=new Zhuce(name, sex, specialty, education, occupation, Integer.parseInt(id));
			}
			HttpSession session=request.getSession();
			session.setAttribute("zhuce", zhuce);
			session.setAttribute("sp", specialty);
			session.setAttribute("nation",nation);
			response.sendRedirect("ZhuceEdit.jsp");
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
