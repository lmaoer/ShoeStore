package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.ProductDAO;
import model.Product;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
    public DetailController() {
        super();
        productDAO = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Product p = productDAO.getProductById(id);
		if(p!= null) {
			request.setAttribute("item", p);
		}else {
			request.setAttribute("msg", "Có lỗi xảy ra!");
		}
		List<Product> list = productDAO.list();
		List<Product> temp = new ArrayList<Product>();
		for(int i = 0; i < 6; i++) {
			temp.add(list.get(i));
		}
		request.setAttribute("products_list", temp);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
