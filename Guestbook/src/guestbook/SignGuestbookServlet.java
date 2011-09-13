package guestbook;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class SignGuestbookServlet extends HttpServlet {
//	private static final Logger log = Logger
//			.getLogger(SignGuestbookServlet.class.getName());

	/**
	 * WME: The HTTP POST request handler
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		// get value of 'content1' parameter of post request
		String content1 = req.getParameter("content1");
		Date date = new Date(); 	// current date
		Greeting greeting1 = new Greeting(user, content1, date);

		// get value of 'content2' parameter of post request
		String content2 = req.getParameter("content2");
		Greeting greeting2 = new Greeting(user, content2, date);
		
		// store this new greeting
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(greeting1);
			pm.makePersistent(greeting2);
		}finally{
			pm.close();
		}
		
		resp.sendRedirect("/guestbook.jsp");
	}
}