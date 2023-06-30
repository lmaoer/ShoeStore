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

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private BrandDAO brandDAO;


	public ProductController() {
		super();
		productDAO = new ProductDAO();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// return list product to view
		listProduct(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		String costlv = request.getParameter("costlv");

		String key = request.getParameter("key");
		if (key == null)
			key = "";
		String brand = request.getParameter("brand");
		if (brand == null || brand == "") {
			brand = "";
			products = productDAO.getProductsByKey(key);
		} else {
			int brandId = Integer.parseInt(brand);
			products = productDAO.getProductsByKeyBrand(key, brandId);
		}

		int pageSelected;
		String page = request.getParameter("page");
		if (page == null)
			pageSelected = 1;
		else
			pageSelected = Integer.parseInt(page);

		List<Product> temp = new ArrayList<Product>();
		if (costlv == null || costlv == "") {
			costlv = ""; // all
			for (Product p : products) {
				temp.add(p);
			}
		} else {
			if (costlv.equals("1")) {
				for (Product p : products) {
					if (Util.costAfterDiscount(p.getCost(), p.getDiscount()) < 1000000)
						temp.add(p);
				}
			} else if (costlv.equals("2")) {
				for (Product p : products) {
					if (Util.costAfterDiscount(p.getCost(), p.getDiscount()) <= 2000000
							&& Util.costAfterDiscount(p.getCost(), p.getDiscount()) >= 1000000)
						temp.add(p);
				}
			} else {
				for (Product p : products) {
					if (Util.costAfterDiscount(p.getCost(), p.getDiscount()) > 2000000)
						temp.add(p);
				}
			}
		}

		/*
		 * int numperpage = 12; // number of items in a page int size = temp.size(); int
		 * num = (size % numperpage == 0) ? (size / numperpage) : (size / numperpage +
		 * 1); // number of page int start = (pageSelected - 1) * numperpage; int end =
		 * Math.min(pageSelected * numperpage, size);
		 * 
		 * List<Product> new_list = productDAO.getListByPage(temp, start, end);
		 */

		// sort
		String sortFilter = request.getParameter("sort");
		if (sortFilter == null || sortFilter.equals("default")) {
			sortFilter = "default";
		} else {
			if (sortFilter.equals("price-asc")) {
				Collections.sort(temp, new Comparator<Product>() {
					@Override
					public int compare(Product o1, Product o2) {
						return Double.compare(Util.costAfterDiscount(o1.getCost(), o1.getDiscount()), Util.costAfterDiscount(o2.getCost(), o2.getDiscount()));
					}
				});
			} else if (sortFilter.equals("price-desc")) {
				Collections.sort(temp, new Comparator<Product>() {
					@Override
					public int compare(Product o1, Product o2) {
						return Double.compare(Util.costAfterDiscount(o2.getCost(), o2.getDiscount()), Util.costAfterDiscount(o1.getCost(), o1.getDiscount()));
					}
				});
			} else {
				Collections.sort(temp, new Comparator<Product>() {
					@Override
					public int compare(Product o1, Product o2) {
						return o1.getName().compareToIgnoreCase(o2.getName());
					}
				});
			}
		}
		
		int numperpage = 12; // number of items in a page
		int size = temp.size();
		int num = (size % numperpage == 0) ? (size / numperpage) : (size / numperpage + 1); // number of page
		int start = (pageSelected - 1) * numperpage;
		int end = Math.min(pageSelected * numperpage, size);

		List<Product> new_list = productDAO.getListByPage(temp, start, end);

		request.setAttribute("page", pageSelected); // handle active link
		request.setAttribute("num", num); // send number of pages to display in view
		request.setAttribute("products_list", new_list);
		request.setAttribute("key", key);
		request.setAttribute("costlv", costlv);
		request.setAttribute("brand", brand);
		request.setAttribute("sort", sortFilter);
		if (new_list.size() == 0)
			request.setAttribute("msg", "Không tìm thấy sản phẩm !");
		// send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
		dispatcher.forward(request, response);
	}
	

}
