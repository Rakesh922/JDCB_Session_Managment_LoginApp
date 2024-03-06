

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mycom.pojo.User;
/**
 * Servlet implementation class ServletOne
 */
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username, password;
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		//set values to pojo
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		
		// add the pojo to the session attribute
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		out.println("In Servlet One");
		out.println("User: "+username);
		out.println("<a href=\"ServletTwo\">Click to Proceed!</a>");
		
		
	}

}
