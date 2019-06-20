package servlet1;


import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import entity.Manager;
import entity.Project;
import entity.User;

/**
 * Servlet implementation class ListProjectServlet
 */
@WebServlet("/ListProjectServlet")
public class ListProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao = new Dao();
	User user = new User();
	Manager manager = new Manager();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProjectServlet() {
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
		  String path = "ListProjectServlet?method=listProject";
		  boolean redirect = false;	 
		  HttpSession session=request.getSession();
		  if(method.equals("userLogin")){
			  User user = new User();
			  user.setId(Integer.parseInt(request.getParameter("id")));			  
			  user.setPwd(request.getParameter("password"));
			  if(dao.userLogin(user)){
				 redirect = true;	
				 request.getSession().setAttribute("user",(session.getAttribute("loginName")));		
				 user = (User)request.getSession().getAttribute("user");
			  }
			  if(!dao.userLogin(user)){ 				  
				  path = "userLogin.jsp";
			  }			 
		  }else if(method.equals("listProject")){        
	          List<Project> list = dao.findTrueProject();
	          request.setAttribute("list",list);
	          path = "listProject.jsp";
		  }
	      if(redirect){
	    	  response.sendRedirect(path);
	      }else{
		      request.getRequestDispatcher(path).forward(request,response);
		  }
	}
}
