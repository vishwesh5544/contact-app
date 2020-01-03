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
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdate() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		UserUpdateBean updateBean = new UserUpdateBean();
		UserUpdateDao updateDao = new UserUpdateDao(request);

		updateBean.setUserEmail(session.getAttribute("email").toString());
		updateBean.setUserid(session.getAttribute("userid").toString());

		if (request.getParameter("lastname").isEmpty() && request.getParameter("email").isEmpty()
				&& request.getParameter("pwd").isEmpty()) {

			updateBean.setFirstname(request.getParameter("firstname"));

			try {
				String updatedao = updateDao.updateFirstname(updateBean);

				if (updatedao.equals("success")) {
					out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (request.getParameter("email").isEmpty() && request.getParameter("pwd").isEmpty()) {
			updateBean.setLastname(request.getParameter("lastname"));

			try {
				String updatedao = updateDao.updateLastname(updateBean);

				if (updatedao.equals("success")) {
					out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!request.getParameter("firstname").isEmpty()) {

				updateBean.setFirstname(request.getParameter("firstname"));

				try {
					String updatedao = updateDao.updateFirstname(updateBean);

					if (updatedao.equals("success")) {
						out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else if (request.getParameter("pwd").isEmpty()) {
			updateBean.setEmail(request.getParameter("email"));

			try {
				String updatedao = updateDao.updateEmail(updateBean);

				if (updatedao.equals("success")) {
					out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!request.getParameter("firstname").isEmpty()) {

				updateBean.setFirstname(request.getParameter("firstname"));

				try {
					String updatedao = updateDao.updateFirstname(updateBean);

					if (updatedao.equals("success")) {
						out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if (!request.getParameter("lastname").isEmpty()) {
				updateBean.setLastname(request.getParameter("lastname"));

				try {
					String updatedao = updateDao.updateLastname(updateBean);

					if (updatedao.equals("success")) {
						out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (!request.getParameter("pwd").isEmpty()) {
			if (request.getParameter("pwd").equals(request.getParameter("cpwd"))) {
				updateBean.setPassword(request.getParameter("pwd"));

				try {
					String updatedao = updateDao.updatePassword(updateBean);

					if (updatedao.equals("success")) {
						out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				if (!request.getParameter("firstname").isEmpty()) {

					updateBean.setFirstname(request.getParameter("firstname"));

					try {
						String updatedao = updateDao.updateFirstname(updateBean);

						if (updatedao.equals("success")) {
							out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				if (!request.getParameter("lastname").isEmpty()) {
					updateBean.setLastname(request.getParameter("lastname"));

					try {
						String updatedao = updateDao.updateLastname(updateBean);

						if (updatedao.equals("success")) {
							out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (!request.getParameter("email").isEmpty()) {
					updateBean.setEmail(request.getParameter("email"));

					try {
						String updatedao = updateDao.updateEmail(updateBean);

						if (updatedao.equals("success")) {
							out.print("<script>alert('Update successful'); window.location = 'index.jsp'</script>");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
	}
}
