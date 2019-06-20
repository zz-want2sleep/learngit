package servlet;
import java.util.Vector;
public class User {
private static Vector<String> online=new Vector<String>();
public static void addUser(String loginName) {
	online.addElement(loginName);
}
public static void removeUser(String loginName) {
	
	online.removeElement(loginName);
}
public static int getUserCount() {
	return online.size();
}
public static Vector<String> getVector() {
	return online;
}
}
