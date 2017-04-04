package groupProject.MLG.objectlayer;



public class User {
private String name;
private String userName;
private String password;

public User(String name, String userName, String password) {
	super();
	this.name = name;
	this.userName = userName;
	this.password = password;
}
public User() {
	// TODO Auto-generated constructor stub
	this.name = null;
	this.userName = null;
	this.password = null;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




}
