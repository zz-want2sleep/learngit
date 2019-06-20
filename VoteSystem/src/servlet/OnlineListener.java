package servlet;


import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		User.addUser(String.valueOf(se.getValue()));
		System.out.println("session("+se.getSession().getId()+")增加属性"+se.getName()+"值为"+se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		User.removeUser(String.valueOf(se.getValue()));
		System.out.println(se.getValue()+"属性已移除");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		String oldValue=String.valueOf(se.getValue());
		String newValue=String.valueOf(se.getSession().getAttribute(se.getName()));
		User.removeUser(oldValue);
		User.addUser(newValue);
		System.out.println(oldValue+"属性已更改为"+newValue);
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionCreated(se);
		System.out.println("会话已建立！");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionDestroyed(se);
	System.out.println("会话已销毁！");
	}

}
