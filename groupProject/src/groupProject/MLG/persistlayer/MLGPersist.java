package groupProject.MLG.persistlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void createUser(String fname, String lname, String userName, String password, String game, String email)
	{
		
		PreparedStatement stmt = database.newPrepStm("insert into users(fname, lname, userName, password, game, email) values(?, ?, ?, ?, ?, ?)");
		
		try {
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, userName);
			stmt.setString(4, password);
			stmt.setString(5, game);
			stmt.setString(6, email);
			
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
		String firstName = null, lastName = null, uName = null, password = null, game = null, email = null, profilePic = null;
		
		
		if(rs.next()) {
			id = rs.getInt("User_ID");
			System.out.println(id);
			firstName = rs.getString("fname");
			System.out.println(firstName);
			lastName = rs.getString("lname");
			uName = rs.getString("userName");
			password = rs.getString("password");
			game = rs.getString("game");
			email = rs.getString("email");
			profilePic = rs.getString("profile_pic");
		}
		infoUser.setFname(firstName);
		infoUser.setLname(lastName);
		infoUser.setPassword(password);
		infoUser.setUserID(id);
		infoUser.setUserName(uName);
		infoUser.setGame(game);
		infoUser.setEmail(email);
		infoUser.setProfilePic(profilePic);
		
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
	public List<Link> getTopTen(String game) 
	{
		List<Link> links = new ArrayList<Link>();
		String str = null;
		
		if (game != null)
		{
			str = "SELECT * from links WHERE game = " + "\'" + game + "\'" + " order by voteCount DESC LIMIT 10";
		}
		else
		{
			str = "SELECT * from links order by voteCount DESC LIMIT 10";
		}
		
		System.out.println(str);
		
		PreparedStatement stmt = database.newPrepStm(str);
		ResultSet rs = database.exeStm(stmt);
		
		try {
			while (rs.next())
			{
				Link link = new Link(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				links.add(link);
			}
		} catch (SQLException e) {
		}
		
		return links;
	}
	public List<User> getPlayersFromGame(String game) 
	{
		List<User> users = new ArrayList<User>();
		String str = null;
		
		if (game != null)
		{
			str = "SELECT * from users WHERE game = " + "\'" + game + "\'";
		}
		
		System.out.println(str);
		
		PreparedStatement stmt = database.newPrepStm(str);
		ResultSet rs = database.exeStm(stmt);
		
		try {
			while (rs.next())
			{
				int id = 0;
				String fname = null, lname = null, userName = null, password = null, gameDB = null, email = null, profile_pic = null;
				
				
				id = rs.getInt("User_ID");
				System.out.println(id);
				
				fname = rs.getString("fname");
				System.out.println(fname);
				
				lname = rs.getString("lname");
				System.out.println(lname);
				
				userName = rs.getString("userName");
				System.out.println(userName);
				
				password = rs.getString("password");
				System.out.println(password);
				
				gameDB = rs.getString("game");
				System.out.println(gameDB);
				
				email = rs.getString("email");
				System.out.println(email);
				
				profile_pic = rs.getString("profile_pic");
				System.out.println(profile_pic);
				
				User user = new User(id, 
						fname,
						lname,
						userName,
						password,
						gameDB,
						email,
						profile_pic
						);

				users.add(user);
			}
		} catch (SQLException e) {
		}
		
		return users;
	}

	public String getUserNameFromId(int userId) {
		PreparedStatement stmt = database.newPrepStm("select userName from users where User_ID = ?");

		try {
			stmt.setInt(1, userId);
			
		} catch (SQLException e) {
		}
		
		ResultSet rs = database.exeStm(stmt);
		
		try {
			if (rs.next())
			{
				return rs.getString(1);
			}
		} catch (SQLException e) {

		}
		
		return null;
	}

	public void changeUserInfo(int userId, String fname, String lName, String uname, String password, String game, String email) {
		String str = "UPDATE users set";
		boolean first = true;
		
		System.out.println("Change Info, New Info ");
		System.out.println(userId);
		System.out.println(fname);
		System.out.println(lName);
		System.out.println(uname);
		System.out.println(password);
		System.out.println(game);
		System.out.println(email);
		
		if (fname != null && fname.length() > 0)
		{
			str += " fname = " + "\'" + fname + "\'";
			first = false;
		}
		
		if (lName != null && lName.length() > 0)
		{
			if (!first)
				str += ",";
			str += " lname = " + "\'" + lName + "\'";		
		}
		
		if (uname != null && uname.length() > 0)
		{
			if (!first)
				str += ",";
			str += " userName = " + "\'"+ uname + "\'";	
		}
		if (password != null && password.length() > 0)
		{
			if (!first)
				str += ",";
			str += " password = " + "\'" + password + "\'";
		}
		
		if (game != null && game.length() > 0)
		{
			if (!first)
				str += ",";
			str += " game = " + "\'" + game + "\'";	
		}
		
		
		if (email != null && email.length() > 0)
		{
			if (!first)
				str += ",";
			str += " email = " + "\'" + email + "\'";
		}
		
		str += " WHERE User_ID = " + userId;
		System.out.println(str);
		PreparedStatement stmt = database.newPrepStm(str);
		
		database.exeStmUpdate(stmt);
	}

	public void setProfilePic(int userId, String picName) 
	{
		PreparedStatement stmt = database.newPrepStm("update users set profile_pic = ? where User_ID = ?");
		try {
			stmt.setString(1, picName);
			stmt.setInt(2, userId);
			
		} catch (SQLException e) {
		}
		
		database.exeStmUpdate(stmt);
	}

	public void castVote(int linkId, boolean like) {
		String str = null;
		if (like)
		{
			str = "update links set voteCount = voteCount + 1 where link_ID = " + linkId;
		}
		else
		{
			str = "update links set voteCount = voteCount - 1 where link_ID = " + linkId + " and voteCount > 0";
		}
		
		PreparedStatement stmt = database.newPrepStm(str);
		database.exeStmUpdate(stmt);
	}

	public User getUserInfoFromID(int userID) throws SQLException {
		System.out.println("Inside checkUser");
		System.out.println("User ID: " + userID);
		User infoUser = new User();
		PreparedStatement stmt = database.newPrepStm("select * from users where User_ID = ?");
		try {
			stmt.setLong(1, userID);
			
		} catch (SQLException e) {
		}
		ResultSet rs = database.exeStm(stmt);
		int id = 0;
		String firstName = null, lastName = null, uName = null, password = null, game = null, email = null, profilePic = null;
		
		
		if(rs.next()) {
			id = rs.getInt("User_ID");
			System.out.println(id);
			firstName = rs.getString("fname");
			System.out.println(firstName);
			lastName = rs.getString("lname");
			uName = rs.getString("userName");
			password = rs.getString("password");
			game = rs.getString("game");
			email = rs.getString("email");
			profilePic = rs.getString("profile_pic");
		}
		infoUser.setFname(firstName);
		infoUser.setLname(lastName);
		infoUser.setPassword(password);
		infoUser.setUserID(id);
		infoUser.setUserName(uName);
		infoUser.setGame(game);
		infoUser.setEmail(email);
		infoUser.setProfilePic(profilePic);
		
		return infoUser;
		
		
		
	}

	public void creatLink(String link, String game, int userID) {
		// TODO Auto-generated method stub
PreparedStatement stmt = database.newPrepStm("insert into links(link, game, User_ID) values(?, ?, ?)");
		
		try {
			stmt.setString(1, link);
			stmt.setString(2, game);
			stmt.setLong(3, userID);
			
			
		} catch (SQLException e) {
		}
		
		database.exeStmUpdate(stmt);
		
	}
	
}
