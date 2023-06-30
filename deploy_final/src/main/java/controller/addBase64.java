package controller;

import java.io.IOException;
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
 * Servlet implementation class addBase64
 */
@WebServlet("/addProductBase64")
public class addBase64 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBase64() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//(id,name,cost,discount,image:base64,imageDetail:base64,brandId)
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		String image = request.getParameter("image");
		String imageDetail = request.getParameter("imageDetail");
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		
		BrandDAO brandDAO = new BrandDAO();
		Product p = new Product(id,name,cost,discount,image,imageDetail,brandDAO.getBrandById(brandId));
		ProductDAO productDAO = new ProductDAO();
		productDAO.insertProduct(p);
		request.setAttribute("success", "thanh cong !");
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

}
