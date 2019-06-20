package servlet1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import dao.Dao;
import entity.Project;
/**
 * Servlet implementation class ManagerHistoryProject
 */
@WebServlet("/ManagerHistoryProject")
public class ManagerHistoryProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao = new Dao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerHistoryProject() {
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
		request.setCharacterEncoding("utf-8");
		  String method = request.getParameter("method");  
		  String path = "ManagerHistoryProject?method=managerListHistoryProject";
		  boolean redirect = false;	 
		  if(method.equals("managerListHistoryProject")){        
	          List<Project> list = dao.findFalseProject();
	          request.setAttribute("list",list);
	          path = "managerListHistoryProject.jsp";     
		  }else if(method.equals("list")){ 
	          redirect = true;   }
	      if(redirect){
	    	  response.sendRedirect(path);
	      }else{
		      request.getRequestDispatcher(path).forward(request,response);
		  }
	}
}
