package guestbook;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GuestbookConfigServlet extends HttpServlet {
//	private static final Logger log = Logger
//			.getLogger(SignGuestbookServlet.class.getName());

	/**
	 * WME: The HTTP GET request handler
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		if( user!=null && user.getEmail().equals("woutereverse@gmail.com") && user.getUserId().equals("105076256560637784048")){
			//TODO do cool stuff
		}
//		// get value of 'content' parameter of post request
//		String content = req.getParameter("content");
//		Date date = new Date(); 	// current date
//		Greeting greeting = new Greeting(user, content, date);
//
//		// store this new greeting
//		PersistenceManager pm = PMF.get().getPersistenceManager();
//		try{
//			pm.makePersistent(greeting);
//		}finally{
//			pm.close();
//		}
//		
		resp.sendRedirect("/guestbook.jsp");
	}
}