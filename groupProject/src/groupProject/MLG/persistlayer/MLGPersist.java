package groupProject.MLG.persistlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
