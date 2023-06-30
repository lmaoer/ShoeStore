package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.OrderDAO;
import model.Customer;
import model.Order;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet("/orders")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO;
       
    public OrdersController() {
        super();
        orderDAO = new OrderDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer c = (Customer)session.getAttribute("user");
		List<Order> list = (List<Order>) session.getAttribute("list_orders");
		
		
		if(c != null && list != null) {
			for(Order o: list) {
				orderDAO.insertOrder(c, o.getProduct(), o.getQuantity());
			}
		}
		double total = (Double) session.getAttribute("total");
		orderDAO.insertBill(c, (int) total);
		
		session.removeAttribute("list_orders");
		session.removeAttribute("total");
		request.setAttribute("orders_msg", "Thanh toán thành công !");
		request.getRequestDispatcher("check_out.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
