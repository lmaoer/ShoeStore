package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.BrandDAO;
import dal.ProductDAO;
import model.Brand;
import model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	public ProductController() {
		super();
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// read the "command" parameter
		String command = request.getParameter("command");

		if (command == null) {
			command = "LIST";
		}

		// route to the appropriate method
		switch (command) {
		case "LIST":
			listProducts(request, response);
			break;
		case "ADD":
			addProducts(request, response);
			break;
		case "DELETE":
			deleteProducts(request, response);
			break;
		case "LOAD":
			loadProducts(request, response);
			break;
		case "UPDATE":
			updateProducts(request, response);
			break;
		default:
			listProducts(request, response);
		}
	}
	

	private void updateProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String old_id = request.getParameter("old_id");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		double cost = Double.parseDouble(request.getParameter("cost"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String image = request.getParameter("image");
		String status = request.getParameter("status");
		String imageDetail = request.getParameter("imageDetail");
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		BrandDAO brandDAO = new BrandDAO();
		Brand b = brandDAO.getBrandById(brandId);
		if(b==null) {
			request.setAttribute("msg", "Lỗi brand ID không hợp lệ !!");
			request.getRequestDispatcher("/update_product.jsp").forward(request, response);
			return;
		}else {
			Product product = new Product(id,name,cost,discount,quantity,image,status,imageDetail,b);
			productDAO.update(product, old_id);
		}
		
		listProducts(request, response);
	}

	private void loadProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Product product = productDAO.load(id);
		request.setAttribute("p", product);
		request.getRequestDispatcher("/update_product.jsp").forward(request, response);
	}

	private void deleteProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		productDAO.delete(id);
		
		listProducts(request, response);
	}

	private void addProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		double cost = Double.parseDouble(request.getParameter("cost"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String image = request.getParameter("image");
		String status = request.getParameter("status");
		String imageDetail = request.getParameter("imageDetail");
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		BrandDAO brandDAO = new BrandDAO();
		Brand b = brandDAO.getBrandById(brandId);
		if(b==null) {
			request.setAttribute("msg", "Lỗi brand ID không hợp lệ !!");
			request.getRequestDispatcher("/add_product.jsp").forward(request, response);
			return;
		}else {
			Product product = new Product(id,name,cost,discount,quantity,image,status,imageDetail,b);
			productDAO.add(product);
		}
		
		listProducts(request, response);
	}

	private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		if(key==null) key = "";
		List<Product> products = productDAO.search(key);
		int page, numperpage = 12;
		int size = products.size();
		int num = (size%numperpage==0)?(size/numperpage):(size/numperpage+1);
		String xpage = request.getParameter("page");
		if (xpage == null)
			page = 1;
		else
			page = Integer.parseInt(xpage);

		int start = (page - 1) * numperpage;
		int end = Math.min(page * numperpage, size);

		List<Product> new_list = productDAO.getListByPage(products, start, end);
		
		request.setAttribute("page", page);
		request.setAttribute("num", num); 
		request.setAttribute("products_list", new_list);
		request.setAttribute("key", key);
		// send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/products.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
