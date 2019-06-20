package servlet1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import entity.Project;
import entity.Recoder;
import entity.Voter;

/**
 * Servlet implementation class UserListVoterServlet
 */
@WebServlet("/UserListVoterServlet")
public class UserListVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Dao dao=new Dao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListVoterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Voter voter =new Voter();
		Recoder recoder=new Recoder();
		String path="UserView.jsp";
		  voter.setVoterAge(Integer.parseInt(request.getParameter("age")));
		  voter.setVoterBool(Boolean.parseBoolean(request.getParameter("bool")));
		  voter.setVoterId(Integer.parseInt(request.getParameter("id")));
		  voter.setVoterName(request.getParameter("name"));
		  voter.setVoterProject(request.getParameter("project"));
		  voter.setVoterSex(request.getParameter("sex"));
		  voter.setVoterWord(request.getParameter("word"));
		  dao.addVoter(voter);
		  recoder.setChooseName(request.getParameter("name"));
		  recoder.setChooseProject(request.getParameter("project"));
		  recoder.setRecoderId(Integer.parseInt(request.getParameter("id")));
		  dao.addRecoder(recoder);
		 Project project= dao.findProjectByName(request.getParameter("project"));
		 dao.updateProject(project);
		  List<Project> list = dao.findTrueProject();
          request.setCharacterEncoding("utf-8");
          request.setAttribute("list",list);
		  request.getRequestDispatcher(path).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
