package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.ProductDAO;
import model.Customer;
import model.Order;
import model.Product;
import model.Util;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	public CartController() {
		super();
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("user");
		if(customer == null) {
			// login before 
			response.sendRedirect("login.jsp");
			return;
		}
		
		List<Order> listOrders = (List<Order>) session.getAttribute("list_orders");
		if(listOrders != null && listOrders.size() > 0) {
			double total = Util.totalPrice(listOrders);
			session.setAttribute("total", total);
		}else {
			session.setAttribute("total", 0);
		}

		// render order list
		response.sendRedirect("cart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("user");
		if(customer == null) {
			// login before 
			response.sendRedirect("login.jsp");
			return;
		}
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String id = request.getParameter("item_id");

		List<Order> listOrders = (List<Order>) session.getAttribute("list_orders");

		if (listOrders == null) {
			listOrders = new ArrayList<Order>();
			session.setAttribute("list_orders", listOrders);
		}

		boolean check = false;
		for (Order o : listOrders) {
			// product exist: add quantity
			if (o.getProduct().getId().equals(id)) {
				o.setQuantity(o.getQuantity() + quantity);
				check = true;
				break;
			}
		}
		if (!check) {
			listOrders.add(new Order(productDAO.getProductById(id), quantity));
		}

		double total = Util.totalPrice(listOrders);
		session.setAttribute("total", total);

		response.sendRedirect("detail?id=" + id);
	}
}
