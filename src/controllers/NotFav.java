package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NotFav
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/NotFav" })
public class NotFav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotFav() {
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
		HttpSession session = request.getSession();

		NotFavBean notFavBean = new NotFavBean();

		notFavBean.setContactid(request.getParameter("contactid"));
		notFavBean.setUserid(session.getAttribute("userid").toString());
		
		NotFavDao notFavDao = new NotFavDao();
		
		try {
			String notFav  = notFavDao.notFav(notFavBean);
			
			if(notFav.equals("success")) {
				System.out.println("Marked as not favourite");
			} else {
				System.out.println("[FAILED] Could not remove favorite contacts");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
