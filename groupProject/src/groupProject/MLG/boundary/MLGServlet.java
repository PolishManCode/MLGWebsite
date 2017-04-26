package groupProject.MLG.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
		if(request.getParameter("register")!=null){
			System.out.println("In register");
			testUserRegister.setFname(request.getParameter("fname"));
			testUserRegister.setLname(request.getParameter("lname"));
			testUserRegister.setUserName(request.getParameter("userName"));
			testUserRegister.setPassword(request.getParameter("pass"));
			
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
		else{
			loggedIn(request, response);
		}
		
	}

	private void loggedIn(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("name") +" User is logged in");
		
		System.out.println(request.getParameter("param"));
		String paramater = request.getParameter("param");
		if(paramater.equals("home")){
			Link testLink = new Link();
			testLink.setLinkID(214);
			System.out.println("Checking link #: "+testLink.getLinkID());
			try {
				testLink= test.returnTestLink(testLink);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Link ID: "+testLink.getLinkID());
			System.out.println("Link: "+ testLink.getLink());
			System.out.println("Game: " + testLink.getGame());
			System.out.println("VoteCount: " + testLink.getVoteCount());
			
			Link testLink2 = new Link();
			testLink2.setLinkID(215);
			System.out.println("Checking link #: "+testLink2.getLinkID());
			try {
				testLink2= test.returnTestLink(testLink2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("Back to HomePage");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "homepage.ftl";
			String link = testLink.getLink();
			root.put("link", link);
			String link2 = testLink2.getLink();
			root.put("link2", link2);
			tmplProcess.processTemplate(templateName, root, request, response);
		
		}
		else if(paramater.equals("games")){
			System.out.println("Inside of Games");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "games.ftl";
			tmplProcess.processTemplate(templateName, root, request, response);
		}
		else if(paramater.equals("recruit")){
			System.out.println("Inside of recruit");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "recruit.ftl";
			tmplProcess.processTemplate(templateName, root, request, response);
		}
		else if(paramater.equals("recruitment")){
			System.out.println("Inside of recruitment");
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			String templateName = "recruit.ftl";
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
			String userName = testUser.getUserName();
			String fname = testUser.getFname();
			String lname = testUser.getLname();
			String password = testUser.getPassword();
			String game = testUser.getGame();
			root.put("fName", fname);
			root.put("lName", lname);
			root.put("user", userName);
			root.put("game", game);
			root.put("password", password);
			tmplProcess.processTemplate(templateName, root, request, response);
			
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
		Link testLink = new Link();
		testLink.setLinkID(214);
		System.out.println("Checking link #: "+testLink.getLinkID());
		try {
			testLink= test.returnTestLink(testLink);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Link ID: "+testLink.getLinkID());
		System.out.println("Link: "+ testLink.getLink());
		System.out.println("Game: " + testLink.getGame());
		System.out.println("VoteCount: " + testLink.getVoteCount());
		
		Link testLink2 = new Link();
		testLink2.setLinkID(215);
		System.out.println("Checking link #: "+testLink2.getLinkID());
		try {
			testLink2= test.returnTestLink(testLink2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Back to HomePage");
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "homepage.ftl";
		String link = testLink.getLink();
		root.put("link", link);
		String link2 = testLink2.getLink();
		root.put("link2", link2);
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
