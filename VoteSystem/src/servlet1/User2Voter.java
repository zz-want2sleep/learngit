package servlet1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import entity.Project;
import entity.Voter;


/**
 * Servlet implementation class User2Voter
 */
@WebServlet("/User2Voter")
public class User2Voter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Dao dao=new Dao();
       Voter voter=new Voter();
       int number;
       String proName;
       String path;
       HttpSession session;
       int i;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User2Voter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		path="UserView.jsp";
		number = Integer.parseInt(request.getParameter("proNumber")); 
		proName = request.getParameter("proName");  
		session=request.getSession();
		Voter voter=dao.findVoterByNameandProName((String)session.getAttribute("loginName"),proName);
		//List<Voter> list=dao.findVoter(proName);
		//i=list.size();
		if(number>0) {
			if(voter==null) {
			path="add2.jsp";
			request.setAttribute("proName", proName);
			request.getRequestDispatcher(path).forward(request,response);}else{
				path="error7.jsp";
				request.getRequestDispatcher(path).forward(request,response);
			}
		}else if(number<=0) {
			 List<Project> list1 = dao.findTrueProject();
        request.setCharacterEncoding("utf-8");
        request.setAttribute("list",list1);
        request.setAttribute("name", proName);
        request.setAttribute("message1","项目参选人数已满！");
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
