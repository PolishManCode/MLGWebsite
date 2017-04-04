package groupProject.MLG.persistlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccessImpl 
{
	Connection dbCon = null;
	
    public void Connect()
    {
		try {
			Class.forName(DbAccessConfiguration.DRIVE_NAME);
			dbCon = DriverManager.getConnection(DbAccessConfiguration.CONNECTION_URL, 
												DbAccessConfiguration.DB_CONNECTION_USERNAME, 
												DbAccessConfiguration.DB_CONNECTION_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
	
	public ResultSet retrieve (String query)
	{
		ResultSet rset = null;
		try {
			Statement stmt = dbCon.createStatement();
			rset = stmt.executeQuery(query);
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rset;
	}

	public int create (String query)
	{
		
		return 0;
	}
	
	public int update (String query)
	{
		return 0;
	}
	
	public int delete (String query)
	{
		return 0;
	}
	
	public void disconnect()
	{
		try {
			if (dbCon != null) {
				dbCon.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement newPrepStm(String sql)
	{
		//Create a prepared statement
		java.sql.PreparedStatement stm = null;
		try {
			stm = dbCon.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stm;
	}
	
	public ResultSet exeStm(java.sql.PreparedStatement stm)
	{
		//Execute a prepared statement and return the results
		ResultSet rows = null;
		try {
			rows = stm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int exeStmUpdate(java.sql.PreparedStatement stm)
	{
		try {
			return stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
