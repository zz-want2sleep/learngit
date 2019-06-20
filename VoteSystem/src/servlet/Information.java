package servlet;

public class Information {
private String name;
private String sex;
private String education;
private String occupation;
private String aihao;
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
public String getAihao() {
	return aihao;
}
public void setAihao(String aihao) {
	this.aihao = aihao;
}
public String Issex(String s){
	if(s.equals("男")){
		return "男";
	}else 
		return "女";
}

}
