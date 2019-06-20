package servlet;

import java.util.LinkedList;
import java.util.Queue;




public class Zhuce {
private int id;
private String name;
private String sex;
private String[] specialty;
private String education;
private String occupation;
private String loginName;
private String PWD;
public static Queue<String> a=new LinkedList<String>();
public static Queue<String> b=new LinkedList<String>();
public static Queue<String> aa=new LinkedList<String>();
public static Queue<String> bb=new LinkedList<String>();


public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
	a.add(loginName);
}
public String getPWD() {
	return PWD;
}
public void setPWD(String pWD) {
	
	this.PWD = pWD;
	b.add(PWD);
}
public boolean bijiao(String a1,String b1) {
	boolean c=false;
	while(a.peek()!=null) {	
		String a0=a.poll();
		String b0=b.poll();
		if(a1.equals(a0)) {
			c=true;
		}
		aa.add(a0);
		bb.add(b0);
		}
		while(aa.peek()!=null) {
			String a0=aa.poll();
			String b0=bb.poll();
			a.add(a0);
			b.add(b0);
		}
	return c;
}

public boolean bijiao2(String a1) {
	boolean c=false;
	int k=0;
	while(a.peek()!=null) {
		String a0=a.poll();
		String b0=b.poll();
		if(a1.equals(a0))
			k++;
		
			aa.add(a0);
			bb.add(b0);
	}
	if(k!=0) {
		c=true;
	}
	while(aa.peek()!=null) {
		String a11=aa.poll();
		String b11=bb.poll();
		a.add(a11);
		b.add(b11);
	}
return c;
}
public void bijiao3(String a1,String b1) {
	
	while(a.peek()!=null) {	
		String a0=a.poll();
		String b0=b.poll();
		if(a1.equals(a0)&&b1.equals(b0)) {
		}else {
		aa.add(a0);
		bb.add(b0);
		}
		}
		while(aa.peek()!=null) {
			String a0=aa.poll();
			String b0=bb.poll();
			a.add(a0);
			b.add(b0);
		}

}
public Zhuce() {
	super();
}
public Zhuce(String name,String sex,String specialty,String education,String occupation,int id) {
	super();
	this.name=name;
	this.sex=sex;
	this.education=education;
	this.occupation=occupation;
	this.id=id;
}
public Zhuce(String name,String sex,String specialty,String education,String occupation) {
	super();
	this.name=name;
	this.sex=sex;
	this.education=education;
	this.occupation=occupation;

}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String[] getSpecialty() {
	return specialty;
}
public void setSpecialty(String[] specialty) {
	this.specialty = specialty;
}
public static String showSpecialty(String[]s) {
	String string=" ";
	if(s.equals(null)) {
		return string;
	}
	else {
	for(int i=0;i<s.length;i++) {
		string+=s[i]+" ";
		} 
		return string;
	}
}

public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
}
