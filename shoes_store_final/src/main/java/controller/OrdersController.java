package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;
import model.Order;
import model.Util;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet("/orders")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    public OrdersController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("hn", "vn"));
		HttpSession session = request.getSession();
		Customer c = (Customer)session.getAttribute("user");
		List<Order> list = (List<Order>) session.getAttribute("list_orders");
		
		String recepient = request.getParameter("recepient");
		if(recepient == null || recepient.equals("")) {
			request.setAttribute("recepientnull", "Vui lòng nhập địa chỉ email!");
			request.getRequestDispatcher("check_out.jsp").forward(request, response);
			return;
		}
		
		double total = (Double) session.getAttribute("total");
		// in hóa đơn
		if(c != null && list != null) {
			String html = "<div style=\"font-family: san-serif; color: #333; width: 600px\">\r\n"
					+ "        <h1>Order Confirmation</h1>\r\n"
					+ "        <hr>\r\n"
					+ "        <h2>Purchased by</h2>\r\n"
					+ "        <p><b>Name: </b>" + c.getName() + " </p>\r\n"
					+ "        <p><b>Email: </b>" + recepient + " </p>\r\n"
					+ "        <p><b>Purchase Date: </b>" + new Date().toString() +" </p>\r\n"
					+ "        <hr>\r\n"
					+ "        <h3>Receipt Details</h3>\r\n"
					+ "        <p><b>List:</b></p>\r\n"
					+ "        <ul>\r\n"
					
					
					//+ "            <li>Giày adidas 2.500.000đ</li>\r\n"
					+ Util.receiptList(list)
					
					
					+ "        </ul>\r\n"
					+ "        <p><b>List Price:</b> " + numberFormat.format(total) + "</p>\r\n"
					+ "        <p><b>Tax:</b> 0đ</p>\r\n"
					+ "        <p><b>Total:</b> " + numberFormat.format(total) + "</p>\r\n"
					+ "        <hr>\r\n"
					+ "        <p style=\"color: #777\">Thế giới giày 96A Trần Phú, P. Mộ Lao, Hà Đông, Hà Nội - Hotline:\r\n"
					+ "            0362957746</p>\r\n"
					+ "    </div>";
			// System.out.println(html);
			try {
				Util.sendMail(recepient, html);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		session.removeAttribute("list_orders");
		session.removeAttribute("total");
		request.setAttribute("orders_msg", "Thanh toán thành công !");
		request.getRequestDispatcher("check_out.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
