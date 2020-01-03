package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveContact
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RemoveContact" })
public class RemoveContact extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);

		HttpSession session = request.getSession();

		RemoveContactBean removeContactBean = new RemoveContactBean();
		removeContactBean.setContactid(request.getParameter("contactid"));
		removeContactBean.setUserid(session.getAttribute("userid").toString());

		RemoveContactDao removeContactDao = new RemoveContactDao();

		try {

			String removeContact = removeContactDao.removeContact(removeContactBean);

			if (removeContact.equals("success")) {
				System.out.println("Contact Removed");
			} else {
				System.out.println("[ERROR] Contact remove - failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
