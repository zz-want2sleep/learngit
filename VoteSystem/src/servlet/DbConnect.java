package servlet;
import java.sql.*;
public class DbConnect {
public static Connection con;
public static Connection getConnection() {
	try {
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
	String url = "jdbc:mysql://localhost/mysql?user=root&password=zhangzhe"+"&useUnicode=true&characterEncoding=utf-8&useSSL=true";
	con=DriverManager.getConnection(url);
	System.out.println("数据库连接成功！");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return con;
}

}
