package groupProject.MLG.logiclayer;

import java.sql.SQLException;

import groupProject.MLG.objectlayer.User;
import groupProject.MLG.persistlayer.MLGPersist;

public class MLGImpl {

	private MLGPersist impl = new MLGPersist();

	public void Connect()
	{
		impl.Init();
	}
	
	public void Disconnect()
	{
		impl.UnInit();
	}
	
	
	public void create(User user)
	{
		impl.createUser(user.getFname(), user.getLname(), user.getUserName(), user.getPassword());
	}
	
	public boolean check(User user) throws SQLException{
		return impl.checkUser(user.getUserName(), user.getPassword());
		
	}
}
