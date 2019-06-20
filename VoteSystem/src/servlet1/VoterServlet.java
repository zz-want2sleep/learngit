package servlet1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import entity.Voter;

/**
 * Servlet implementation class VoterServlet
 */
@WebServlet("/VoterServlet")
public class VoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao=new Dao();
	String proName;
	String path;
	String method;
	int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proName = request.getParameter("proName");
		method= request.getParameter("method");
		//id=Integer.parseInt(request.getParameter("proNumber"));
		if(method.equals("voter")) {
	    path="VoterPage.jsp";
		List<Voter> list=dao.findVoter(proName);
		request.setCharacterEncoding("utf-8");
        request.setAttribute("list",list);
        request.getRequestDispatcher(path).forward(request,response);
	}else if(method.equals("voter1")){
		int id=Integer.parseInt(request.getParameter("voter"));
		path="Vote?voter="+id;
		request.getRequestDispatcher(path).forward(request,response);
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
