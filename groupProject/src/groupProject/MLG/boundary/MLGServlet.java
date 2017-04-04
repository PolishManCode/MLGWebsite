package groupProject.MLG.boundary;

import java.io.IOException;
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
			testUserRegister.setName(request.getParameter("name"));
			testUserRegister.setUserName(request.getParameter("userName"));
			testUserRegister.setPassword(request.getParameter("pass"));
			
			test.create(testUserRegister);

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
				
			}
			else{
				System.out.println("Login Unsuccessful");
				
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
