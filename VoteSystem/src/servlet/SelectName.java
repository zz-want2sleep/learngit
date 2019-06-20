package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;


/**
 * Servlet implementation class SelectName
 */
@WebServlet("/SelectName")
public class SelectName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectName() {
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
		String username=request.getParameter("name");
		int flage=0;
		String sql="select name from zhuce1";
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		LinkedList<String> list=new LinkedList<String>();
		LinkedList<String> changelist=new LinkedList<String>();
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);

			rSet=pStatement.executeQuery();

			while(rSet.next()) {
				String name=rSet.getString("name");
				
		list.add(name);
				
			}
			while(list.peek()!=null) {
				String a=list.poll();
				if(a.equals(username)) {
					out.print("用户名重复，请重新输入！");
					list.add(a);
					flage=1;
					changelist.add(a);
					break;
				}
				changelist.add(a);
			}
			while(changelist.peek()!=null) {
				String b=changelist.poll();
				list.add(b);
			}
			if(username==""||username.equals(" ")) {
				out.print("用户名不能为空，请重新输入！");
				flage=1;
			}
		
			if(flage==0) {
				out.print(username);
			out.print("用户名可用！");}
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
