package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.*;
import util.*;
public class Dao {	User user2 = new User();
	public void addVoter(Voter voter){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into voter (voterId,voterName,voterSex,voterWord,voterAge,voterProject,voterBool) values (?,?,?,?,?,?,?)");
			pstmt.setInt(1,voter.getVoterId());
			pstmt.setString(2,voter.getVoterName());
			pstmt.setString(3,voter.getVoterSex());
			pstmt.setString(4,voter.getVoterWord());
			pstmt.setInt(5,voter.getVoterAge());
			pstmt.setString(6,voter.getVoterProject());
			pstmt.setBoolean(7,voter.isVoterBool());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);}	}
	public void addRecoder(Recoder recoder){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into recoder (recoderId,chooseName,chooseProject) values (?,?,?)");
			pstmt.setInt(1,recoder.getRecoderId());
			pstmt.setString(2,recoder.getChooseName());
			pstmt.setString(3,recoder.getChooseProject());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}}
	public void addManager(Manager manager){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into guanli(id,name,pwd)values (?,?,?)");
			pstmt.setInt(1,manager.getManagerId());
			pstmt.setString(2,manager.getManagerName());
			pstmt.setString(3,manager.getManagerPassword());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}	}
	public void addProject(Project project){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into project(proId,proNumber,proName,proShow,ProBool)values (?,?,?,?,?)");
			pstmt.setInt(1,project.getProId());
			pstmt.setInt(2,project.getProNumber());
			pstmt.setString(3,project.getProName());			
			pstmt.setString(4,project.getProShow());
			pstmt.setBoolean(5,project.isProBool());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}	
		}
	public void addUser(User user){
		try{	Connection conn = JdbcUtil.getConnection();
	PreparedStatement pstmt = conn.prepareStatement("insert into users1 (id,name,pwd) values (?,?,?)");
			pstmt.setInt(1,user.getId());			
			pstmt.setString(2,user.getName());
			pstmt.setString(3,user.getPwd());	
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}}
	public void addProRecoder(ProRecoder proRecoder){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into proRecoder (recProId,recProName) values (?,?)");
			pstmt.setInt(1,proRecoder.getRecProId());
			pstmt.setString(2,proRecoder.getRecProName());			
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);}	}
	public void addUserRecoder(UserRecoder userRecoder){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into userrecoder (rId,rIndex,rProject,rName,rChooseName,rBool,rTime) values (?,?,?,?,?,?,?)");
			pstmt.setInt(1,userRecoder.getrId());
			pstmt.setInt(2,userRecoder.getrIndex());
			pstmt.setString(3,userRecoder.getrProject());
			pstmt.setString(4,userRecoder.getrName());		
			pstmt.setString(5,userRecoder.getrChooseName());			
			pstmt.setBoolean(6,userRecoder.isBool());	
			pstmt.setString(7,userRecoder.getrTime());	
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}}
	public void updateUserRecoder(UserRecoder userRecoder){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update userrecoder set rIndex=?,rName=?,rChooseName=?,rBool=?,rTime=? where rProject=?");
			pstmt.setInt(1,userRecoder.getrIndex()+1);
			pstmt.setString(2,userRecoder.getrName());
			pstmt.setString(3,userRecoder.getrChooseName());
			pstmt.setBoolean(4,userRecoder.isBool());
			pstmt.setString(5,userRecoder.getrTime());
			pstmt.setString(6,userRecoder.getrProject());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);}	}
	public void updateFalseProject(Project project){
		try{Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update project set proId=?,proNumber=?,ProShow=?,proBool=? where proName=?");
			pstmt.setInt(1,project.getProId());
			pstmt.setInt(2,project.getProNumber());
			pstmt.setString(3,project.getProShow());
			pstmt.setBoolean(4,false);
			pstmt.setString(5,project.getProName());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}}
	public void updateProject(Project project){
		try{Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update project set proId=?,proNumber=?,ProShow=?,proBool=? where proName=?");
			pstmt.setInt(1,project.getProId());
			pstmt.setInt(2,project.getProNumber()-1);
			pstmt.setString(3,project.getProShow());
			pstmt.setBoolean(4,true);
			pstmt.setString(5,project.getProName());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}}
	public void updateTrueProject(Project project){
		try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update project set proId=?,proNumber=?,ProShow=?,proBool=? where proName=?");
			pstmt.setInt(1,project.getProId());
			pstmt.setInt(2,project.getProNumber());
			pstmt.setString(3,project.getProShow());
			pstmt.setBoolean(4,true);
			pstmt.setString(5,project.getProName());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt,conn);
		}catch(SQLException e){
		    e.printStackTrace();
			throw new RuntimeException(e);	}}
	 public void vote(Voter voter){
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("update voter set voterName=?,voterSex=?,voterWord=?,voterIndex=?,voterAge=?, voterProject=?,voterBool=? where voterId=?");
				pstmt.setString(1,voter.getVoterName());
				pstmt.setString(2,voter.getVoterSex());
				pstmt.setString(3,voter.getVoterWord());
				pstmt.setInt(4,voter.getVoterIndex()+1);
				pstmt.setInt(5,voter.getVoterAge());
				pstmt.setString(6,voter.getVoterProject());
				pstmt.setBoolean(7,voter.isBool());
				pstmt.setInt(8,voter.getVoterId());
				pstmt.executeUpdate();
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);	}
		}	
	 public Voter findVoterById(int id){
			Voter voter = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from voter where voterId = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					voter = new Voter();
					voter.setVoterId(rs.getInt(1));					
					voter.setVoterName(rs.getString(2));
					voter.setVoterSex(rs.getString(3));
					voter.setVoterWord(rs.getString(4));
					voter.setVoterIndex(rs.getInt(8));
					voter.setVoterAge(rs.getInt(5));
					voter.setVoterProject(rs.getString(6));
					voter.setVoterBool(rs.getBoolean(7));
	}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return voter;
		}
	 public Recoder findRecoderById(int id){
			Recoder recoder = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from recoder where voterId = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					recoder = new Recoder();
					recoder.setRecoderId(rs.getInt(1));					
					recoder.setChooseName(rs.getString(2));
					recoder.setChooseProject(rs.getString(3));			
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return recoder;
		}
	 public Voter findVoterByName(String name){
			Voter voter = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from voter where voterName = ?");
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				do{
					voter = new Voter();
					pstmt.setInt(1,voter.getVoterId());
					pstmt.setString(2,voter.getVoterName());
					pstmt.setString(3,voter.getVoterSex());
					pstmt.setString(4,voter.getVoterWord());
					pstmt.setInt(8,voter.getVoterIndex());
					pstmt.setInt(5,voter.getVoterAge());
					pstmt.setString(6,voter.getVoterProject());
					pstmt.setBoolean(7,voter.isBool());					
				}while(rs.next());
				System.out.println(voter.getVoterName());
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return voter;
		}
	 public Voter findVoterByNameandProName(String name,String proName){
			Voter voter = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from voter where voterName=? and voterProject=?");
				pstmt.setString(1, name);
				pstmt.setString(2, proName);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					voter = new Voter();
					voter.setVoterId(rs.getInt(1));
					voter.setVoterName(rs.getString(2));
					voter.setVoterAge(rs.getInt(5));
					voter.setVoterSex(rs.getString(3));
					voter.setVoterWord(rs.getString(4));
					voter.setVoterProject(rs.getString(6));
					voter.setVoterIndex(rs.getInt(8));;
					voter.setVoterBool(rs.getBoolean(7));
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return voter;
		}
	 public Manager findManagerById(int id){
			Manager manager = null; 
			try{	Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from guanli where id = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					manager = new Manager();
					manager.setManagerId(rs.getInt(1));
					manager.setManagerName(rs.getString(2));
					manager.setManagerPassword(rs.getString(3));					
				}
				System.out.println(manager.getManagerName());
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return manager;
		}	 
	 public User findUserByName(String name){
			User user = null; 
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from users1 where name = ?");
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					user = new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setPwd(rs.getString(3));						
				}System.out.println(user.getName());
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return user;
		}	 
	 public Project findProjectById(int id){
			Project project = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from project where proId = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					project = new Project();
					project.setProId(rs.getInt(1));
					project.setProNumber(rs.getInt(2));
					project.setProName(rs.getString(3));					
					project.setProShow(rs.getString(4));	
					project.setProBool(rs.getBoolean(5));
				}System.out.println(project.isProBool());
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return project;
		}
	 public Project findProjectByName(String name){
			Project project = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from project where proName = ?");
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					project = new Project();
					project.setProId(rs.getInt(1));
					project.setProName(rs.getString(2));	
					project.setProNumber(rs.getInt(3));
					project.setProShow(rs.getString(4));	
					project.setProBool(rs.getBoolean(5));
				}JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return project;
		}
	 public ProRecoder findProRecoderById(int id){
			ProRecoder proRecoder = null; 
			try{	Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from proRecoder where recProId = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					proRecoder = new ProRecoder();
					proRecoder.setRecProId(rs.getInt(1));
					proRecoder.setRecProName(rs.getString(2));					
				}System.out.println(proRecoder.getRecProName());
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return proRecoder;
		}
	 public UserRecoder findUserRecoderByIdName(int id,String project){
		 UserRecoder userRecoder = null;
			try{	Connection conn = JdbcUtil.getConnection();
PreparedStatement pstmt = conn.prepareStatement("select * from userrecoder where rId = ? and rProject = ?");
				pstmt.setInt(1, id);
				pstmt.setString(2, project);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					userRecoder = new UserRecoder();
					userRecoder.setrId(rs.getInt(1));
					userRecoder.setrIndex(rs.getInt(2));
					userRecoder.setrProject(rs.getString(3));		
					userRecoder.setrName(rs.getString(4));		
					userRecoder.setrChooseName(rs.getString(5));		
					userRecoder.setrBool(rs.getBoolean(6));					
				}JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return userRecoder;
		}
	 public UserRecoder findUserRecoderById(int id){
		 UserRecoder userRecoder = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from userrecoder where rId = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					userRecoder = new UserRecoder();
					userRecoder.setrId(rs.getInt(1));
					userRecoder.setrIndex(rs.getInt(2));
					userRecoder.setrProject(rs.getString(3));		
					userRecoder.setrName(rs.getString(4));		
					userRecoder.setrChooseName(rs.getString(5));		
					userRecoder.setrBool(rs.getBoolean(6));	
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return userRecoder;
		}
	 public UserRecoder findUserRecoderByName(String project){
		 UserRecoder userRecoder = null; 
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from userrecoder where rProject = ?");
				pstmt.setString(1, project);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					userRecoder = new UserRecoder();
					userRecoder.setrId(rs.getInt(1));
					userRecoder.setrIndex(rs.getInt(2));
					userRecoder.setrProject(rs.getString(3));		
					userRecoder.setrName(rs.getString(4));		
					userRecoder.setrChooseName(rs.getString(5));		
					userRecoder.setrBool(rs.getBoolean(6));	
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return userRecoder;
		}
	 public List<UserRecoder> findUserRecoderByUserName(String name){
		 UserRecoder userRecoder = null; 
		 List<UserRecoder> list=new ArrayList<UserRecoder>();
			try{	Connection conn = JdbcUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from userrecoder where rName = ?");
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					userRecoder = new UserRecoder();
					userRecoder.setrId(rs.getInt(1));
					userRecoder.setrIndex(rs.getInt(2));
					userRecoder.setrProject(rs.getString(3));		
					userRecoder.setrName(rs.getString(4));		
					userRecoder.setrChooseName(rs.getString(5));		
					userRecoder.setrBool(rs.getBoolean(6));
					userRecoder.setrTime(rs.getString(7));
					list.add(userRecoder);		
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<Voter> findVoter(String voterProject){
			List<Voter> list = new ArrayList<Voter>();
			try{	Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from voter where voterProject = ?");
				pstmt.setString(1, voterProject);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Voter voter = new Voter();
					voter.setVoterId(rs.getInt(1));					
					voter.setVoterName(rs.getString(2));
					voter.setVoterSex(rs.getString(3));
					voter.setVoterWord(rs.getString(4));
					voter.setVoterAge(rs.getInt(5));
					voter.setVoterProject(rs.getString(6));
					voter.setVoterBool(rs.getBoolean(7));
					voter.setVoterIndex(rs.getInt(8));
				   list.add(voter);
				}JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<Recoder> findRecoder(int id){
			List<Recoder> list = new ArrayList<Recoder>();
			try{	Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from recoder where recoderId = ?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Recoder recoder = new Recoder();
					recoder.setRecoderId(rs.getInt(1));					
					recoder.setChooseName(rs.getString(2));
					recoder.setChooseProject(rs.getString(3));
				   list.add(recoder);
				}JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<Voter> findAllVoter(){
			List<Voter> list = new ArrayList<Voter>();
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from voter");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Voter voter = new Voter();
					voter.setVoterId(rs.getInt(1));					
					voter.setVoterName(rs.getString(2));
					voter.setVoterSex(rs.getString(3));
					voter.setVoterWord(rs.getString(4));
					voter.setVoterAge(rs.getInt(5));
					voter.setVoterProject(rs.getString(6));
					voter.setVoterBool(rs.getBoolean(7));
				   list.add(voter);
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<Project> findAllProject(){
			List<Project> list = new ArrayList<Project>();
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from project");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Project project = new Project();
					project.setProId(rs.getInt(1));
					project.setProNumber(rs.getInt(2));
					project.setProName(rs.getString(3));
					project.setProShow(rs.getString(4));
					project.setProBool(rs.getBoolean(5));
				   list.add(project);
				}JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<Project> findTrueProject(){
			List<Project> list = new ArrayList<Project>();
			try{	Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from project where ProBool = true");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Project project = new Project();
					project.setProId(rs.getInt(1));
					project.setProNumber(rs.getInt(3));
					project.setProName(rs.getString(2));
					project.setProShow(rs.getString(4));
					project.setProBool(rs.getBoolean(5));
				   list.add(project);
				}JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<Project> findFalseProject(){
			List<Project> list = new ArrayList<Project>();
			try{	Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from project where ProBool = false");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Project project = new Project();
					project.setProId(rs.getInt(1));
					project.setProName(rs.getString(2));
					project.setProNumber(rs.getInt(3));
					project.setProShow(rs.getString(4));
					project.setProBool(rs.getBoolean(5));
				   list.add(project);
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<UserRecoder> findAllUserRecoder(){
			List<UserRecoder> list = new ArrayList<UserRecoder>();
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from userRecoder");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					UserRecoder userRecoder = new UserRecoder();
					userRecoder.setrId(rs.getInt(1));
					userRecoder.setrProject(rs.getString(2));
					userRecoder.setrName(rs.getString(3));
					userRecoder.setrChooseName(rs.getString(4));
					userRecoder.setrBool(rs.getBoolean(5));
				   list.add(userRecoder);
				}JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public List<User> findAllUser(){
			List<User> list = new ArrayList<User>();
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from users1");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getInt(1));					
					user.setName(rs.getString(2));
					user.setPwd(rs.getString(3));
				   list.add(user);
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}
			return list;
		}
	 public void deleteUser(int id){
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from user where id =?");
				pstmt.setInt(1,id);
				pstmt.executeUpdate();
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}}
	 public void deleteProject(int id){
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from project where proId =?");
				pstmt.setInt(1,id);
				pstmt.executeUpdate();
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}	}
	 public void deleteVoter(int id){
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from voter where voterId =?");
				pstmt.setInt(1,id);
				pstmt.executeUpdate();
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}	}
		 public boolean  userLogin(User user1){
		 boolean userLoginBool = false;
			User user = null; 
			try{	Connection conn = JdbcUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from users1 where id = ?");
				pstmt.setInt(1, user1.getId());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					user = new User();
					user.setId(rs.getInt(1));
					user.setPwd(rs.getString(2));				
				}
				if(user1.getPwd()==user.getPwd()){
					userLoginBool = true;
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}			
			return userLoginBool;			
		}
	 public boolean  managerLogin(Manager manager1){
		 boolean managerLoginBool = false;
			Manager manager = null; 
			try{	Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from guanli where id = ?");
				pstmt.setInt(1, manager1.getManagerId());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					manager = new Manager();
					manager.setManagerId(rs.getInt(1));
					manager.setManagerPassword(rs.getString(3));			
				}
				if(manager1.getManagerPassword() == manager.getManagerPassword()){
					managerLoginBool = true;
				}
				JdbcUtil.close(pstmt,conn);
			}catch(SQLException e){
			    e.printStackTrace();
				throw new RuntimeException(e);
			}			
			return managerLoginBool;
		}}