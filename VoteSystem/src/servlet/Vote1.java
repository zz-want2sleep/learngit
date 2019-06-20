package servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import entity.Voter;

/**
 * Servlet implementation class Vote1
 */
@WebServlet("/Vote1")
public class Vote1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Dao dao= new Dao();
     Voter voter=new Voter();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote1() {
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
		HttpSession Session=request.getSession();
		
String proName=(String)Session.getAttribute("proName");
		Dao dao=new Dao();
	List<Voter> list=dao.findVoter(proName);
	request.setAttribute("list", list);
	System.out.println(list.size()+proName);
			RequestDispatcher rDispatche=request.getRequestDispatcher("饼图.jsp");
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
