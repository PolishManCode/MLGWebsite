package groupProject.MLG.objectlayer;



public class User {
private int userID;
private String fname;
private String lname;
private String userName;
private String password;
private String game;


public User(String fname, String lname, String userName, String password) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.userName = userName;
	this.password = password;
}
public User(String fname, String lname, String userName, String password, String game) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.userName = userName;
	this.password = password;
	this.game = game;
}

public User() {
	super();
	this.fname = "";
	this.lname = "";
	this.userName = "";
	this.password = "";
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
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

public int getUserID() {
	return userID;
}

public void setUserID(int userID) {
	this.userID = userID;
}
public String getGame() {
	return game;
}
public void setGame(String game) {
	this.game = game;
}



}
