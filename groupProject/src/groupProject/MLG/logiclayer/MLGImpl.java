package groupProject.MLG.logiclayer;

import java.sql.SQLException;

import groupProject.MLG.objectlayer.Link;
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
	public User reutrnUserInfo(User user) throws SQLException{
		User tempUser = new User();
		tempUser = impl.getUserInfo(user.getUserName());
		
		
		return tempUser;
		
	}
	public Link returnTestLink(Link link) throws SQLException{
		Link tempLink = new Link();
		tempLink = impl.retrieveTestLink(link.getLinkID());
		
		
		return tempLink;
		
	}
}
