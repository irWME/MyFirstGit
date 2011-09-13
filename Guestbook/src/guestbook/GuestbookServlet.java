package guestbook;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GuestbookServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		if(user != null){
			//WME: text/html instead of text/plain allows me to output html 
			resp.setContentType("text/html");
			
			resp.getWriter().println("<hr/>");
			resp.getWriter().println("Bonjour et Bienvenue, " + user.getNickname() +"!");
			resp.getWriter().println("<hr/>");
			resp.getWriter().println("<a href='" + userService.createLogoutURL("/") + "'>Log Out</a>");
		}
		else{
			resp.sendRedirect( userService.createLoginURL(req.getRequestURI()) );
		}
	}
}
