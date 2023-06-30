package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.UserDAO;
import model.Customer;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO login;

	public LoginController() {
		super();
		login = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("user");
		if(customer == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("nm");
		String password = request.getParameter("pwd");

		// check account
		Customer customer = login.checkAccount(user, password);
		if (customer == null) {
			request.setAttribute("loginError", "Tài khoản hoặc mật khẩu không chính xác!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// set session for user login
		HttpSession session = request.getSession();
		session.setAttribute("user", customer);
		response.sendRedirect("index.jsp");
	}
}
