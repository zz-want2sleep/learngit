package servlet1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Project;
import entity.Voter;
import dao.Dao;
/**
 * Servlet implementation class ManagerListVoterServlet
 */
@WebServlet("/ManagerListVoterServlet")
public class ManagerListVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Voter voter=new Voter();
       Dao dao=new Dao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerListVoterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");  
		  String path = "ManagerListVoterServlet?method=listVoter";
		  boolean redirect = false;
		  if(method.equals("listVoter")){        
	          List<Voter> list = dao.findAllVoter();
	          request.setCharacterEncoding("utf-8");
	          request.setAttribute("list",list);
	          path = "managerListVoter.jsp";
		  }else if(method.equals("addVoter")){
			 Voter voter =new Voter();
			  voter.setVoterAge(Integer.parseInt(request.getParameter("age")));
			  voter.setVoterBool(Boolean.parseBoolean(request.getParameter("bool")));
			  voter.setVoterId(Integer.parseInt(request.getParameter("id")));
			  voter.setVoterName(request.getParameter("name"));
			  voter.setVoterProject(request.getParameter("project"));
			  voter.setVoterSex(request.getParameter("sex"));
			  voter.setVoterWord(request.getParameter("word"));
			  dao.addVoter(voter);
			  redirect = true;
		  }else if(method.equals("deleteVoter")){
			  int id = Integer.parseInt(request.getParameter("id"));
			  dao.deleteVoter(id);
			  redirect = true;
		  }else if(method.equals("view")) {
			  List<Voter> list = dao.findVoter(request.getParameter("proName"));
			  request.setCharacterEncoding("utf-8");
	          request.setAttribute("list",list);
	          path = "managerListVoter.jsp";
		  }
		  if(redirect){
	    	  response.sendRedirect(path);
	      }else{	request.getRequestDispatcher(path).forward(request,response);
		  }
	}
}

