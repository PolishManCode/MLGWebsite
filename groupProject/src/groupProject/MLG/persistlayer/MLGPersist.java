package groupProject.MLG.persistlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import groupProject.MLG.objectlayer.Link;
import groupProject.MLG.objectlayer.User;

public class MLGPersist {
private DbAccessImpl database = new DbAccessImpl();
	
	public void Init()
	{
		database.Connect();
	}
	
	public void UnInit()
	{
		database.disconnect();
	}

	public void createUser(String fname, String lname, String userName, String password)
	{
		
		PreparedStatement stmt = database.newPrepStm("insert into users(fname, lname, userName, password) values(?, ?, ?, ?)");
		
		try {
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, userName);
			stmt.setString(4, password);
			
		} catch (SQLException e) {
		}
		
		database.exeStmUpdate(stmt);
		
	}
	public boolean checkUser(String userName, String password) throws SQLException{
		System.out.println("Inside checkUser");
		System.out.println(userName +" " + password);
		PreparedStatement stmt = database.newPrepStm("select count(*) from users where userName = ? and password =?");
		try {
			stmt.setString(1, userName);
			stmt.setString(2, password);
			
		} catch (SQLException e) {
		}
		ResultSet rs = database.exeStm(stmt);
		int rowcount =0;
		rs.next();
		rowcount = rs.getInt(1);
		if ( rowcount >0){
			return true;
		}
		else{
			return false;
		}
		
	}
	public User getUserInfo(String userName) throws SQLException{
		System.out.println("Inside checkUser");
		System.out.println(userName);
		User infoUser = new User();
		PreparedStatement stmt = database.newPrepStm("select * from users where userName = ?");
		try {
			stmt.setString(1, userName);
			
		} catch (SQLException e) {
		}
		ResultSet rs = database.exeStm(stmt);
		int id = 0;
		String firstName = null, lastName = null, uName = null, password = null, game = null;
		
		
		if(rs.next()) {
			id = rs.getInt("User_ID");
			System.out.println(id);
			firstName = rs.getString("fname");
			System.out.println(firstName);
			lastName = rs.getString("lname");
			uName = rs.getString("userName");
			password = rs.getString("password");
			game = rs.getString("game");
		}
		infoUser.setFname(firstName);
		infoUser.setLname(lastName);
		infoUser.setPassword(password);
		infoUser.setUserID(id);
		infoUser.setUserName(uName);
		infoUser.setGame(game);
		
		return infoUser;
	
	}
	public void createLink(String link, String game)
	{
		
		PreparedStatement stmt = database.newPrepStm("insert into links(link, game) values(?, ?)");
		
		try {
			stmt.setString(1, link);
			stmt.setString(2, game);
			
		} catch (SQLException e) {
		}
		
		database.exeStmUpdate(stmt);
		
	}
	public Link retrieveTestLink(int linkID) throws SQLException
	{
		
		PreparedStatement stmt = database.newPrepStm("select * from links where Link_ID = ?");
		Link testLink = new Link();
		System.out.println("Inside of retrieveTestLink and link id is: " +linkID);
		try {
			stmt.setInt(1, linkID);
			
		} catch (SQLException e) {
		}
		
		ResultSet rs = database.exeStm(stmt);
		int id = 0;
		String link = null, game = null;
		int voteCount = 0;
		int userID = 0;
		
		
		if(rs.next()) {
			id = rs.getInt("Link_ID");
			System.out.println(id);
			link = rs.getString("link");
			System.out.println(link);
			game = rs.getString("game");
			voteCount = rs.getInt("voteCount");
			userID = rs.getInt("User_ID");
		}
		testLink.setLink(link);
		testLink.setLinkID(id);
		testLink.setGame(game);
		testLink.setUserID(userID);
		testLink.setVoteCount(voteCount);
		
		return testLink;
		
	}
	
}
