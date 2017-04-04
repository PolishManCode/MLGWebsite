package groupProject.MLG.persistlayer;

public abstract class DbAccessConfiguration 
{
	static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
	
	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/MLG"; //  "jdbc:mysql://localhost:3306/imdb?autoReconnect=true&useSSL=false";
	
	static final String DB_CONNECTION_USERNAME = "root";
	
	static final String DB_CONNECTION_PASSWORD = "password";
}
