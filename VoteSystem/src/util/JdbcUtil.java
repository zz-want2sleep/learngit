package util;

import java.sql.*;
public class JdbcUtil{
	static{
	   try{ Class.forName("com.mysql.jdbc.Driver");
	   System.out.println("数据库连接成功！");
	   }catch(ClassNotFoundException e){
		   e.printStackTrace();
	   }	}
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost/mysql?user=root&password=zhangzhe"+"&useUnicode=true&characterEncoding=utf-8&useSSL=true";
				return DriverManager.getConnection(url);
	}
		public static void close(Statement stmt,Connection conn)throws SQLException{
	     stmt.close();
		 conn.close();
	}
	public static void close(ResultSet rs,Statement stmt,Connection conn)throws SQLException{
	     rs.close();
		 close(stmt,conn);
	}
    
}