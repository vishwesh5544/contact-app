package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Fav
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Fav" })
public class Fav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Fav() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		FavBean favBean = new FavBean();
		favBean.setContactid(request.getParameter("contactid"));
		favBean.setUserid(session.getAttribute("userid").toString());

		FavDao favDao = new FavDao();

		try {

			String fav = favDao.fav(favBean);

			if (fav.equals("success")) {
				System.out.println("Marked as favourite");
			} else {
				System.out.println("[FAILED] Could add as favorite contact");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
