package groupProject.MLG.logiclayer;

import java.sql.SQLException;
import java.util.List;

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
		impl.createUser(user.getFname(), user.getLname(), user.getUserName(), user.getPassword(), user.getGame(), user.getEmail());
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

	public List<Link> getTopTen(String game) {
		// TODO Auto-generated method stub
		return impl.getTopTen(game);
	}

	public String getUserNameFromId(int userID) {
		// TODO Auto-generated method stub
		return impl.getUserNameFromId(userID);
	}
	public List<User> getPlayersFromGame(String game)
	{
		return impl.getPlayersFromGame(game);
	}
	
	public void castVote(int linkId, boolean like)
	{
		impl.castVote(linkId, like);
	}
	public void changeUserInfo(int userId, String Fname, String LName, String Uname, String password, String game, String email) {
		impl.changeUserInfo(userId, Fname, LName, Uname, password, game, email);
	}
	
	public void setProfilePic(int userId, String picName)
	{
		impl.setProfilePic(userId, picName);
	}

	public User reutrnUserInfoByID(int userID) throws SQLException {
		// TODO Auto-generated method stub
		User tempUser = new User();
		tempUser = impl.getUserInfoFromID(userID);
		
		
		return tempUser;
		
	}

	public void createLink(Link newLink) {
		// TODO Auto-generated method stub
		impl.creatLink(newLink.getLink(), newLink.getGame(), newLink.getUserID());
		
	}
}
