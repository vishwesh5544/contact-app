package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/register")
public class RegisterUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUser() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (request.getParameter("pwd1").equals(request.getParameter("pwd2"))) {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("pwd1");

			RegisterBean registerbean = new RegisterBean();

			registerbean.setFirstname(firstname);
			registerbean.setLastname(lastname);
			registerbean.setEmail(email);
			registerbean.setPassword(password);

			RegisterDao registerdao = new RegisterDao();

			try {
				String registerUser = registerdao.register(registerbean);

				if (registerUser.equals("register_successful")) {
					System.out.println("User registered successfully");
					out.print("<script>alert('Registration successful'); window.location = 'index.jsp';</script>");
				} else {
					out.print("<script>alert('Registration failed'); window.location = 'index.jsp';</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			out.print("<script>alert('Passwords do not match.'); window.location = 'login.jsp';</script>");
		}

	}

}
