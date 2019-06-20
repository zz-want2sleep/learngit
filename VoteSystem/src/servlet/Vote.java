package servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import dao.Dao;
import entity.UserRecoder;
import entity.Voter;
import entity.User;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count;
	int count1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
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
		int id=Integer.parseInt(request.getParameter("voter"));
		Date currentTime;
		SimpleDateFormat formatter;
		String dateString;
		
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("loginName");
		if(user==null) {
			session.setAttribute("message", "对不起，你还没有登录，请先登录！");
			RequestDispatcher rDispatche=request.getRequestDispatcher("error6.jsp");
			rDispatche.forward(request, response);
		}else {
		Connection connection=DbConnect.getConnection();
		String sql="select * from users1 where name=?;";
				PreparedStatement pStatement=null;
		ResultSet rSet=null;
		String sql1="select * from voter where voterId=?;";
		PreparedStatement pStatement1=null;
ResultSet rSet1=null;
		try {
			pStatement=(PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, user);
			rSet=pStatement.executeQuery();
			currentTime=new Date();
			formatter =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			dateString =formatter.format(currentTime);
			while(rSet.next()) {
			
			//System.out.println("你好"+dateString);
			if(rSet.getString("time")!=null) {
			Date one=formatter.parse(dateString);
			Date two=formatter.parse(rSet.getString("time"));
			long time1=one.getTime();
			long time2=two.getTime();
			System.out.println(time1);
			System.out.println(time2);
			long r=time1-time2;
			System.out.println(r);
			if(r>=24*60*60*1000) {
				String sql5="update users1 set time=? where name=?";
				PreparedStatement pStatement5=(PreparedStatement) connection.prepareStatement(sql5);
				pStatement5.setString(1, dateString);
				pStatement5.setString(2, user);
				int k=pStatement5.executeUpdate();
				if(k==1) {
					System.out.println(dateString);
				}
				pStatement1=(PreparedStatement) connection.prepareStatement(sql1);
				pStatement1.setInt(1,id);
				rSet1=pStatement1.executeQuery();
				while(rSet1.next()) {
				count=rSet1.getInt("voterIndex");
				count+=1;
			
					String sql2="update voter set voterIndex=? where voterId=?";
					PreparedStatement pStatement2=(PreparedStatement) connection.prepareStatement(sql2);
					pStatement2.setInt(1, count);
					pStatement2.setInt(2, id);
					int i=pStatement2.executeUpdate();
					Dao dao=new Dao();
					UserRecoder userrecoder=new UserRecoder();
					Voter voter=dao.findVoterById(id);
					userrecoder.setrChooseName(voter.getVoterName());
					userrecoder.setrName(user);
					userrecoder.setrProject(voter.getVoterProject());
					userrecoder.setrBool(userrecoder.isBool());
					userrecoder.setrTime(dateString);
					if(dao.findUserRecoderByIdName(id, voter.getVoterProject())!=null) {
						UserRecoder userrecoder2=new UserRecoder();
						userrecoder2=dao.findUserRecoderByName(voter.getVoterProject());
					        int a=userrecoder2.getrIndex();
						userrecoder.setrIndex(a);
						//System.out.println(a+1);
						dao.updateUserRecoder(userrecoder);
					
					}else {
					
						userrecoder.setrIndex(1);
					dao.addUserRecoder(userrecoder);
					}
					if(i==1) {
						session.setAttribute("message","投票成功,项目"+voter.getVoterProject()+",参选人:"+voter.getVoterName()+"当前票数为"+count);
						RequestDispatcher rDispatche=request.getRequestDispatcher("Home.jsp");
		  			rDispatche.forward(request, response);
					}
				
					/*String sql4="update users1 set time=? where name=?";
				PreparedStatement pStatement4=(PreparedStatement) connection.prepareStatement(sql4);
				pStatement4.setString(1, dateString);
				pStatement4.setString(1, user);
				pStatement4.executeUpdate();*/
				}
			}else {
				session.setAttribute("message", "投票失败，一天只能投一票。");
				RequestDispatcher rDispatche=request.getRequestDispatcher("error6.jsp");
				rDispatche.forward(request, response);
			}
			}else {
				String sql6="update users1 set time=? where name=?";
				PreparedStatement pStatement6=(PreparedStatement) connection.prepareStatement(sql6);
				pStatement6.setString(1, dateString);
				pStatement6.setString(2, user);
				int o=pStatement6.executeUpdate();
				if(o==1) {
					String sql11="select * from voter where voterId=?;";
					PreparedStatement pStatement11=null;
			ResultSet rSet11=null;
			pStatement11=(PreparedStatement) connection.prepareStatement(sql11);
			pStatement11.setInt(1,id);
			rSet11=pStatement11.executeQuery();
					while(rSet11.next()) {
					count1=rSet11.getInt("voterIndex")+1;
				}
					Dao dao=new Dao();
					UserRecoder userrecoder=new UserRecoder();
					Voter voter=dao.findVoterById(id);
					userrecoder.setrChooseName(voter.getVoterName());
					userrecoder.setrName(user);
					userrecoder.setrProject(voter.getVoterProject());
					userrecoder.setrBool(userrecoder.isBool());
					userrecoder.setrTime(dateString);
					if(dao.findUserRecoderByName(voter.getVoterProject())!=null) {
						UserRecoder userrecoder1=new UserRecoder();
						userrecoder1=dao.findUserRecoderByName(voter.getVoterProject());
					        int a=userrecoder1.getrIndex();
						userrecoder.setrIndex(a);
						//System.out.println(a+1);
						dao.updateUserRecoder(userrecoder);
						dao.vote(voter);
					}else {
		
						userrecoder.setrIndex(1);
						dao.vote(voter);
					dao.addUserRecoder(userrecoder);
					}
					String name1=voter.getVoterName();
					
						session.setAttribute("message", "投票成功,项目"+voter.getVoterProject()+",参选人:"+name1+"当前票数为"+count1);
						RequestDispatcher rDispatche=request.getRequestDispatcher("Home.jsp");
		  			rDispatche.forward(request, response);
				}
			}
			
			}		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
