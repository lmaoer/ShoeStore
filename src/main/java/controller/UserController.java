package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.UserDAO;
import model.Customer;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
	
    public UserController() {
        super();
        userDAO = new UserDAO();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		if(command.equals("logout")) {
			session.removeAttribute("user");
			session.removeAttribute("list_orders");
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");

		if(command.equals("add")) {
			String name = request.getParameter("name");
			String username = request.getParameter("user");
			
			if(userDAO.checkUsernameExist(username) != null) {
				request.setAttribute("notice", "Tên tài khoản đã tồn tại");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			
			String phone = request.getParameter("phone");
			if(phone != null && !phone.equals("")) {
				Pattern pattern = Pattern.compile("^\\d{10}$");
			    Matcher matcher = pattern.matcher(phone);
			
				if(!matcher.matches()) {
					request.setAttribute("notice", "Số điện thoại không hợp lệ");
					request.getRequestDispatcher("register.jsp").forward(request, response);
					return;
				}
			}
			String password = request.getParameter("pwd");
			String city = request.getParameter("city");
			
			userDAO.userRegister(new Customer(name, phone, city, username, password));
			request.setAttribute("notice", "Đăng ký thành công ✔");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else if(command.equals("update")) {
			String name = request.getParameter("name");
		
			String phone = request.getParameter("phone");
			if(phone != null && !phone.equals("")) {
				Pattern pattern = Pattern.compile("^\\d{10}$");
			    Matcher matcher = pattern.matcher(phone);
			
				if(!matcher.matches()) {
					request.setAttribute("notice", "Số điện thoại không hợp lệ");
					request.getRequestDispatcher("update_user.jsp").forward(request, response);
					return;
				}
			}
			String city = request.getParameter("city");
			
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("user");
			userDAO.updateUser(name, phone, city, customer.getId());
			request.setAttribute("notice", "Cập nhật thành công ✔");
			request.getRequestDispatcher("update_user.jsp").forward(request, response);
		}else if(command.equals("changepwd")) {
			String old = request.getParameter("old");
			String new1 = request.getParameter("new");
			String new2 = request.getParameter("new2");
			
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("user");
			
			if(!old.equals(customer.getPassword())) {
				request.setAttribute("notice", "Mật khẩu cũ không chính xác!");
				request.getRequestDispatcher("change_password.jsp").forward(request, response);
				return;
			}
			
			if(!new2.equals(new1)) {
				request.setAttribute("notice", "Không trùng khớp mật khẩu");
				request.getRequestDispatcher("change_password.jsp").forward(request, response);
				return;
			}
			
			userDAO.updatePwd(new1,customer.getId());
			request.setAttribute("notice", "Cập nhật mật khẩu thành công ✔");
			request.getRequestDispatcher("change_password.jsp").forward(request, response);
		}
	}

}
