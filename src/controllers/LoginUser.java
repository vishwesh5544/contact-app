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
 * Servlet implementation class LoginUser
 */
@WebServlet("/login")
public class LoginUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUser() {
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

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginBean loginbean = new LoginBean();

		loginbean.setEmail(email);
		loginbean.setPassword(password);

		LoginDao logindao = new LoginDao(request);

		try {
			String userValidate = logindao.validate(loginbean, request);

			if (userValidate.equals("valid_user")) {
				System.out.println("User logged in successfully");
				out.print("<script>alert('Logged in successfully'); window.location = 'index.jsp';</script>");
			} else {
				System.out.println("Error Message = " + userValidate);
				HttpSession session = request.getSession();
				session.invalidate();
				out.print(
						"<script>alert('Invalid user - enter correct email/password.'); window.location = 'login.jsp';</script>");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*
		 * finally { try { Connection con = DBConnection.createConnection();
		 * 
		 * con.close();
		 * 
		 * System.out.println("Connection - " + con + " closed"); } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 */	}

}
