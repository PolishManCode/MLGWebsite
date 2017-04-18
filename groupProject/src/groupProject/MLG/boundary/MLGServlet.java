package groupProject.MLG.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import groupProject.MLG.logiclayer.MLGImpl;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MLGServlet() {
        super();
        test.Connect();
        // TODO Auto-generated constructor stub
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
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html> <html > <head> <meta charset='UTF-8'> <title>MLG Sign up page</title>      <link rel='stylesheet' href='css/home.css'> </head><body> <div id='login'>   <h1>Welcome to MLG Recruitment Website!</h1> <form action='MLGServlet' method='post'>  <div class='field-wrap'><label>User Name<span class='req'>*</span> </label> <input type ='text' name='userName' required autocomplete='off'/>          </div>                   <div class='field-wrap'>            <label>              Password<span class='req'>*</span>            </label>            <input type ='password' name='pass' required autocomplete='off'/>         </div>                   <p class='forgot'><a href='#'>Forgot Password?</a></p>                  <button name='login' class='button button-block'/>Log In</button>                    </form>        </div>              </div><!-- tab-content -->     </div> <!-- /form -->	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>  	<script src='WEB-INF/lib/jquery.min.js'></script><script src='js/home.js' type ='text/javascript'></script></body></html>");

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
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html><html>  <head>    <meta charset='UTF-8'>    <title>Home</title>    <link rel='stylesheet' type='text/css' href='css/login.css'>  </head>  <body>    <div id = 'homelogo'>      <a href= index.html> <img src='pictures/logo.png' alt='Recruit Gaming Home' style='width:172px;height:92px;'>    </div>    <ul>      <li><a href='index.html'>Home</a></li>      <li><a href='games.html'>Games</a></li>      <li><a href='recruits.html'>Recruits</a></li>      <li><a href='recruiting.html'>Recruiting</a></li>      <li><a href='profile.html'>Profile</a></li>    </ul>    <div id = 'login'>      <a href=login.html>Log in</a>    </div>  </body></html>");
			}
			else{
				System.out.println("Login Unsuccessful");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html> <html > <head> <meta charset='UTF-8'> <title>Login Unsuccessful</title></head><body><h3>Login Unsuccessful</h3></body></html>");
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
