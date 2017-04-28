package groupProject.MLG.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import groupProject.MLG.boundary.TemplateProcessor;
import groupProject.MLG.logiclayer.MLGImpl;
import groupProject.MLG.objectlayer.Link;
import groupProject.MLG.objectlayer.User;

/**
 * Servlet implementation class MLGServlet
 */
@WebServlet("/MLGServlet")
public class MLGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MLGImpl test = new MLGImpl();
	User testUserRegister = new User();
	User testUserLogin = new User();
	private User userToken = new User();
	private String templateDir = "/WEB-INF/templates";
	private TemplateProcessor tmplProcess;
	private boolean guestCheck = true;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MLGServlet() {
        super();
        test.Connect();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tmplProcess = new TemplateProcessor(templateDir, getServletContext());
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("inside of servlet");
		String paramater = request.getParameter("param");
		System.out.println(request.getParameter("param"));
		
		if(request.getParameter("register")!=null){
			System.out.println("In register");
			testUserRegister.setFname(request.getParameter("fname"));
			testUserRegister.setLname(request.getParameter("lname"));
			testUserRegister.setUserName(request.getParameter("userName"));
			testUserRegister.setPassword(request.getParameter("pass"));
			testUserRegister.setGame(request.getParameter("game"));
			testUserRegister.setEmail(request.getParameter("email"));
			
			test.create(testUserRegister);
			goToLogin(request, response);

		}
		else if(request.getParameter("login")!=null){
			System.out.println("In Login");
			testUserLogin.setUserName(request.getParameter("userName"));
			System.out.println(request.getParameter("userName"));
			testUserLogin.setPassword(request.getParameter("pass"));
			System.out.println(request.getParameter("pass"));
			boolean check = false;
			try {
				check = test.check(testUserLogin);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(check==true){
				System.out.println("Login Successful");
				System.out.println(testUserLogin.getFname() + " " + testUserLogin.getLname());
				HttpSession session = request.getSession(true);
		        if(session!=null)
		        session.setAttribute("name", testUserLogin.getUserName());
				setUserToken(testUserLogin);
				goToHomePage(request, response);
				
				
			}
			else{
				System.out.println("Login Unsuccessful");
				goTologinError(request, response);
			}
		}
		else if(paramater.equals("noLogIn")){
			HttpSession session = request.getSession(true);
	        if(session!=null)
	        session.setAttribute("name", "guest");
			goToGuestHomePage(request, response);
		}
		else{
			loggedIn(request, response);
		}
		
	}
	public void showGame(String name, boolean guestOrNot, HttpServletRequest request, HttpServletResponse response)
	{
		List<Link> top = test.getTopTen(name);
		for (Link l : top)
		{
			l.setPlayerName(test.getUserNameFromId(l.getUserID()));
		}
		
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "game.ftl";
		root.put("topList", top);
		root.put("gameName", name);
		
		root.put("guest", guestCheck);
		tmplProcess.processTemplate(templateName, root, request, response);
	}
	
	
	

	private void goToGuestHomePage(HttpServletRequest request, HttpServletResponse response) {
		guestCheck=false;
		System.out.println("Back to HomePage");
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		root.put("guest", guestCheck);
		
		String templateName = "homepage.ftl";
		List<Link> topTen = test.getTopTen(null);
		for (Link l : topTen)
		{
			l.setPlayerName(test.getUserNameFromId(l.getUserID()));
		}
		
		root.put("topList", topTen);
		
		
		tmplProcess.processTemplate(templateName, root, request, response);
		
	}
	private void goToGuest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("name") +" User is logged in");
		
		System.out.println(request.getParameter("param"));
		String paramater = request.getParameter("param");
		if(paramater.equals("home")){
			guestCheck=false;
			System.out.println("Back to HomePage");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			root.put("guest", guestCheck);
			
			String templateName = "homepage.ftl";
			List<Link> topTen = test.getTopTen(null);
			for (Link l : topTen)
			{
				l.setPlayerName(test.getUserNameFromId(l.getUserID()));
			}
			
			root.put("topList", topTen);
			
			
			tmplProcess.processTemplate(templateName, root, request, response);
		
		}
		else if(paramater.equals("games")){
			System.out.println("Inside of Games");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "games.ftl";
			
			guestCheck = false;
			root.put("guest", guestCheck);
			tmplProcess.processTemplate(templateName, root, request, response);
		}

		else if(paramater.equals("recruitment")){
			System.out.println("Inside of recruit");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "recruit.ftl";
			
			List<User> list1 = test.getPlayersFromGame("CSGO");
			List<User> list2 = test.getPlayersFromGame("Overwatch");
			List<User> list3 = test.getPlayersFromGame("League of Legends");
			
			
			root.put("list1", list1);
			root.put("list2", list2);
			root.put("list3", list3);
			guestCheck = false;
			root.put("guest", guestCheck);
			
			tmplProcess.processTemplate(templateName, root, request, response);
		}
		else if(paramater.equals("logOutIn")){
			System.out.println("Inside of logoutin");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "login.ftl";
			session.invalidate();
			
			tmplProcess.processTemplate(templateName, root, request, response);
		}
		else if(paramater.equals("worldofwarcraft")){
			guestCheck = false;
			showGame("World of Warcraft", guestCheck, request, response);
		}
		else if(paramater.equals("callofdutyaw")){
			guestCheck = false;
			showGame("Call of Duty, Advanced Warfare", guestCheck, request, response);
		}
		else if(paramater.equals("csgo")){
			guestCheck = false;
			showGame("CSGO", guestCheck, request, response);
		}
		else if(paramater.equals("dota2")){
			guestCheck = false;
			showGame("DOTA 2", guestCheck, request, response);
		}
		else if(paramater.equals("halo5")){
			guestCheck = false;
			showGame("Halo 5", guestCheck, request, response);
		}
		else if(paramater.equals("hearthstone")){
			guestCheck = false;
			showGame("DOTA 2", guestCheck, request, response);
		}
		else if(paramater.equals("heroesofthestorm")){
			guestCheck = false;
			showGame("Heroes of the Storm", guestCheck, request, response);
		}
		else if(paramater.equals("leagueoflegends")){
			guestCheck = false;
			showGame("League of Legend", guestCheck, request, response);
		}
		else if(paramater.equals("overwatch")){
			guestCheck = false;
			showGame("Overwatch", guestCheck, request, response);
		}
		else if(paramater.equals("smite")){
			guestCheck = false;
			showGame("Smite", guestCheck, request, response);
		}
		else if(paramater.equals("starcraft")){
			guestCheck = false;
			showGame("Starcraft II", guestCheck, request, response);
		}
		else if(paramater.equals("callofdutybo3")){
			guestCheck = false;
			showGame("Call of Duty, Black Ops3", guestCheck, request, response);
		}
		else if(paramater.equals("gearsofwar4")){
			guestCheck = false;
			showGame("Gears of War 4", guestCheck, request, response);	
		}
		
		
	
	}
	private void loggedIn(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("name") +" User is logged in");
		
		System.out.println(request.getParameter("param"));
		String paramater = request.getParameter("param");
		String userOrGuest = "guest";
		System.out.println(session.getAttribute("name"));
		if(session.getAttribute("name").equals(userOrGuest)){
			goToGuest(request, response);
		}
		else{
		if(paramater.equals("home")){
			
			guestCheck = true;

			System.out.println("Back to HomePage");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			root.put("guest", guestCheck);
			
			String templateName = "homepage.ftl";
			List<Link> topTen = test.getTopTen(null);
			for (Link l : topTen)
			{
				l.setPlayerName(test.getUserNameFromId(l.getUserID()));
			}
			
			root.put("topList", topTen);
			
			
			tmplProcess.processTemplate(templateName, root, request, response);
		
		}
		else if(paramater.equals("addLink")){
			Link newLink = new Link();
			
			newLink.setLink(request.getParameter("link"));
			newLink.setGame(request.getParameter("linkGame"));
			
			User testUser = new User();
			testUser.setUserName((String) session.getAttribute("name"));
			System.out.println(session.getAttribute("name") +" User is logged in");
			try {
				testUser= test.reutrnUserInfo(testUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(testUser.getUserID());
			newLink.setUserID(testUser.getUserID());
			
			test.createLink(newLink);
			
			
			System.out.println("Inside of addLink");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "games.ftl";
			
			guestCheck = true;
			root.put("guest", guestCheck);
			tmplProcess.processTemplate(templateName, root, request, response);
			
		}
		else if(paramater.equals("games")){
			System.out.println("Inside of Games");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "games.ftl";
			
			guestCheck = true;
			root.put("guest", guestCheck);
			tmplProcess.processTemplate(templateName, root, request, response);
		}
		
		else if(paramater.equals("recruitment")){
			System.out.println("Inside of recruit");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "recruit.ftl";
			
			List<User> list1 = test.getPlayersFromGame("CSGO");
			List<User> list2 = test.getPlayersFromGame("Overwatch");
			List<User> list3 = test.getPlayersFromGame("League of Legends");
			
			
			root.put("list1", list1);
			root.put("list2", list2);
			root.put("list3", list3);
			guestCheck = true;
			root.put("guest", guestCheck);
			
			tmplProcess.processTemplate(templateName, root, request, response);
		}
		else if(paramater.equals("logOutIn")){
			System.out.println("Inside of logoutin");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "login.ftl";
			
			tmplProcess.processTemplate(templateName, root, request, response);
		}
		
		else if(paramater.equals("profile")){
			System.out.println("Our user is: " + userToken.getFname()+ " "+ userToken.getLname());
			User testUser = new User();
			testUser.setUserName((String) session.getAttribute("name"));
			System.out.println(session.getAttribute("name") +" User is logged in");
			try {
				testUser= test.reutrnUserInfo(testUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("User Name: "+testUser.getFname() + " " + testUser.getLname());
			System.out.println("UserID: "+ testUser.getUserID());
			System.out.println("UserName: " + testUser.getUserName());
			System.out.println("Password: " + testUser.getPassword());
			
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "profile.ftl";
			int id = testUser.getUserID();
			String userName = testUser.getUserName();
			String fname = testUser.getFname();
			String lname = testUser.getLname();
			String password = testUser.getPassword();
			String game = testUser.getGame();
			String email = testUser.getEmail();
			
			root.put("userId", id);
			root.put("fName", fname);
			root.put("lName", lname);
			root.put("user", userName);
			root.put("game", game);
			root.put("password", password);
			root.put("email", email);
			
			if (testUser.getProfilePic() != null)
			{
				root.put("profilePicName", "profile_pics/" + testUser.getProfilePic());
			}
			else
			{
				root.put("profilePicName", "http://placehold.it/750x450");
			}
			
			guestCheck = true;
			root.put("guest", guestCheck);
			tmplProcess.processTemplate(templateName, root, request, response);
			
		}
		else if(paramater.equals("editInfo")){
			test.changeUserInfo(Integer.parseInt(request.getParameter("user_id")),
					request.getParameter("FName"),
					request.getParameter("LName"),
					request.getParameter("UName"),
					request.getParameter("Password"),
					request.getParameter("game"),
					request.getParameter("email"));
			User changedUser= new User();
			String usName = request.getParameter("UName");
			changedUser.setUserName(usName);
			try {
				changedUser= test.reutrnUserInfo(changedUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("name", changedUser.getUserName());
			
			
			System.out.println("Our user is: " + userToken.getFname()+ " "+ userToken.getLname());
			User testUser = new User();
			testUser.setUserName((String) session.getAttribute("name"));
			System.out.println(session.getAttribute("name") +" User is logged in");
			try {
				testUser= test.reutrnUserInfo(testUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("User Name: "+testUser.getFname() + " " + testUser.getLname());
			System.out.println("UserID: "+ testUser.getUserID());
			System.out.println("UserName: " + testUser.getUserName());
			System.out.println("Password: " + testUser.getPassword());
			
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "profile.ftl";
			int id = testUser.getUserID();
			String userName = testUser.getUserName();
			String fname = testUser.getFname();
			String lname = testUser.getLname();
			String password = testUser.getPassword();
			String game = testUser.getGame();
			String email = testUser.getEmail();
			
			root.put("userId", id);
			root.put("fName", fname);
			root.put("lName", lname);
			root.put("user", userName);
			root.put("game", game);
			root.put("password", password);
			root.put("email", email);
			
			if (testUser.getProfilePic() != null)
			{
				root.put("profilePicName", "profile_pics/" + testUser.getProfilePic());
			}
			else
			{
				root.put("profilePicName", "http://placehold.it/750x450");
			}
			
			guestCheck = true;
			root.put("guest", guestCheck);
			tmplProcess.processTemplate(templateName, root, request, response);
			
		}
		else if(paramater.equals("changeProfilePic"))
		{
			if (request.getParameter("profilePicName") != null)
			{
				test.setProfilePic(Integer.parseInt(request.getParameter("user_id")), request.getParameter("profilePicName"));
				
				User testUser = new User();
				testUser.setUserName((String) session.getAttribute("name"));
				System.out.println(session.getAttribute("name") +" User is logged in");
				try {
					testUser= test.reutrnUserInfo(testUser);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
				SimpleHash root = new SimpleHash(db.build());
				String templateName = "profile.ftl";
				int id = testUser.getUserID();
				String userName = testUser.getUserName();
				String fname = testUser.getFname();
				String lname = testUser.getLname();
				String password = testUser.getPassword();
				String game = testUser.getGame();
				String email = testUser.getEmail();
				
				root.put("userId", id);
				root.put("fName", fname);
				root.put("lName", lname);
				root.put("user", userName);
				root.put("game", game);
				root.put("password", password);
				root.put("email", email);
				
				if (testUser.getProfilePic() != null)
				{
					root.put("profilePicName", "profile_pics/" + testUser.getProfilePic());
				}
				else
				{
					root.put("profilePicName", "http://placehold.it/750x450");
				}
				
				guestCheck = true;
				root.put("guest", guestCheck);
				tmplProcess.processTemplate(templateName, root, request, response);
			}
		}
		else if(paramater.equals("vote") && request.getParameter("videoID") != null)
		{
			test.castVote(Integer.parseInt(request.getParameter("videoID")), request.getParameter("like").equals("1") ? true : false);
			try {
				response.sendRedirect("MLGServlet?param=games");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(paramater.equals("worldofwarcraft")){
			guestCheck = true;
			showGame("World of Warcraft", guestCheck, request, response);
		}
		else if(paramater.equals("callofdutyaw")){
			guestCheck = true;
			showGame("Call of Duty, Advanced Warfare", guestCheck, request, response);
		}
		else if(paramater.equals("csgo")){
			guestCheck = true;
			showGame("CSGO", guestCheck, request, response);
		}
		else if(paramater.equals("dota2")){
			guestCheck = true;
			showGame("DOTA 2", guestCheck, request, response);
		}
		else if(paramater.equals("halo5")){
			guestCheck = true;
			showGame("Halo 5", guestCheck, request, response);
		}
		else if(paramater.equals("hearthstone")){
			guestCheck = true;
			showGame("DOTA 2", guestCheck, request, response);
		}
		else if(paramater.equals("heroesofthestorm")){
			guestCheck = true;
			showGame("Heroes of the Storm", guestCheck, request, response);
		}
		else if(paramater.equals("leagueoflegends")){
			guestCheck = true;
			showGame("League of Legend", guestCheck, request, response);
		}
		else if(paramater.equals("overwatch")){
			guestCheck = true;
			showGame("Overwatch", guestCheck, request, response);
		}
		else if(paramater.equals("smite")){
			guestCheck = true;
			showGame("Smite", guestCheck, request, response);
		}
		else if(paramater.equals("starcraft")){
			guestCheck = true;
			showGame("Starcraft II", guestCheck, request, response);
		}
		else if(paramater.equals("callofdutybo3")){
			guestCheck = true;
			showGame("Call of Duty, Black Ops3", guestCheck, request, response);
		}
		else if(paramater.equals("gearsofwar4")){
			guestCheck = true;
			showGame("Gears of War 4", guestCheck, request, response);	
		}
		}
	}
	private void goTologinError(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "loginError.ftl";
		tmplProcess.processTemplate(templateName, root, request, response);
		
	}
	private void goToHomePage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		guestCheck = true;

		System.out.println("Back to HomePage");
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		root.put("guest", guestCheck);
		
		String templateName = "homepage.ftl";
		List<Link> topTen = test.getTopTen(null);
		for (Link l : topTen)
		{
			l.setPlayerName(test.getUserNameFromId(l.getUserID()));
		}
		
		root.put("topList", topTen);
		
		
		tmplProcess.processTemplate(templateName, root, request, response);
		
	}
	private void goToLogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "login.ftl";
		tmplProcess.processTemplate(templateName, root, request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public User getUserToken() {
		return userToken;
	}
	public void setUserToken(User userToken) {
		this.userToken = userToken;
	}

}
