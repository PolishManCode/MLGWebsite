package groupProject.MLG.objectlayer;



public class User {
private int userID;
private String fname;
private String lname;
private String userName;
private String password;
private String game;
private String email;
private String profilePic;




public User(String fname, String lname, String userName, String password, String game, String email) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.userName = userName;
	this.password = password;
	this.game = game;
	this.email = email;
}
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
public User(int id, String fname, String lname, String userName, String password, String game, String email, String profilePic) {
	super();
	this.userID = id;
	this.fname = fname;
	this.lname = lname;
	this.userName = userName;
	this.password = password;
	this.game = game;
	this.profilePic = profilePic;
	this.email = email;
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

public String getProfilePic() {
	return profilePic;
}

public void setProfilePic(String profilePic) {
	this.profilePic = profilePic;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



}
