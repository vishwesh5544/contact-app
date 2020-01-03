package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/addcontact")
public class AddContact extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContact() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String contactName = request.getParameter("contactname");
		String contactEmail = request.getParameter("email");
		String contactPhone = request.getParameter("countrycode") + request.getParameter("number");
		String isFavourite = request.getParameter("fav");

		AddContactBean addConBean = new AddContactBean();

		addConBean.setContactName(contactName);
		addConBean.setContactEmail(contactEmail);
		addConBean.setContactPhone(contactPhone);
		addConBean.setContactOf(session.getAttribute("userid").toString());
		addConBean.setIsFavourite(isFavourite);

		AddContactDao addcondao = new AddContactDao();

		try {
			String addContact = addcondao.addContact(addConBean);

			if (addContact.equals("contact_added")) {
				System.out.println("Contact added successfully");
				out.print("<script>alert('Contact added successfully'); window.location = 'index.jsp';</script>");
			} else {
				out.print("<script>alert('Contact addition failed'); window.location = 'add-contact.jsp';</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
