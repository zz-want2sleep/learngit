package servlet1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import dao.Dao;
import entity.Manager;
import entity.Project;
import entity.User;
/**
 * Servlet implementation class ManagerListProjectServlet
 */
@WebServlet("/ManagerListProjectServlet")
public class ManagerListProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao = new Dao();
	User user = new User();
	Manager manager = new Manager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerListProjectServlet() {
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
		  String path = "ManagerListProjectServlet?method=listProject";
		  boolean redirect = false;	 
		  if(method.equals("listProject")){        
	          List<Project> list = dao.findTrueProject();
	          request.setCharacterEncoding("utf-8");
	          request.setAttribute("list",list);
	          path = "managerListProject.jsp";
		  }else if(method.equals("addProject")){
			  Project project = new Project();
			  project.setProId(Integer.parseInt(request.getParameter("id")));
project.setProNumber(Integer.parseInt(request.getParameter("number")));
	project.setProName(request.getParameter("name"));			 
	project.setProShow(request.getParameter("show"));			 
	project.setProBool(Boolean.parseBoolean(request.getParameter("bool")));
			  dao.addProject(project);
			  redirect = true;
		  }else if(method.equals("stopProject")){
			  String name = request.getParameter("proName");
			  dao.updateFalseProject(dao.findProjectByName(name));
			  redirect = true;
		  }else if(method.equals("startProject")){
			  String name = request.getParameter("proName");
			  dao.updateTrueProject(dao.findProjectByName(name));
			  redirect = true;
		  }
		  if(redirect){
	    	  response.sendRedirect(path);
	      }else{	request.getRequestDispatcher(path).forward(request,response);
		  }
	}
}