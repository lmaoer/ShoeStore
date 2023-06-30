package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;

@WebServlet("/update")
public class UpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String itemId = request.getParameter("itemId"); // product id
		HttpSession session = request.getSession();
		List<Order> listOrders = (List<Order>) session.getAttribute("list_orders");
		
		if(command.equals("delete")) {
			for(Order o: listOrders) {
				if(o.getProduct().getId().equals(itemId)) {
					listOrders.remove(o);
					break;
				}
			}
			
		}
		if(command.equals("increase")) {
			for(Order o: listOrders) {
				if(o.getProduct().getId().equals(itemId)) {
					o.setQuantity(o.getQuantity()+1);
					break;
				}
			}
		}
		if(command.equals("decrease")) {
			for(Order o: listOrders) {
				if(o.getProduct().getId().equals(itemId)) {
					if(o.getQuantity()==1) {
						listOrders.remove(o);
						break;
					}else {
						o.setQuantity(o.getQuantity()-1);
						break;
					}
				}
			}
		}
		response.sendRedirect("cart");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
