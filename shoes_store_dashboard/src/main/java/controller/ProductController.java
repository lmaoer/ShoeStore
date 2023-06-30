package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dal.BrandDAO;
import dal.ProductDAO;
import model.Product;
import model.Util;

@WebServlet("/productDAO")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private BrandDAO brandDAO;


	public ProductController() {
		super();
		productDAO = new ProductDAO();
		brandDAO = new BrandDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String command = request.getParameter("command");
		// update product 
		if(command.equals("load")) {
			Product product = productDAO.getProductById(id);
			request.setAttribute("p", product);
			request.getRequestDispatcher("update_product.jsp").forward(request, response);
		}
		if(command.equals("delete")) {
			productDAO.deleteProduct(id);
			request.setAttribute("message", "Thành công!");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		String image = request.getParameter("image");
		String imageDetail = request.getParameter("imageDetail");
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		Product product =  new Product(id, name, cost, discount, image, imageDetail, brandDAO.getBrandById(brandId));
		if(command.equals("add")) {
			productDAO.insertProduct(product);
		}
		if(command.equals("update")) {
			productDAO.updateProduct(product);
		}
		request.setAttribute("message", "Thành công!");
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}
}
