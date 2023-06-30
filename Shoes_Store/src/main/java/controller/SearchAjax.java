package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dal.ProductDAO;
import model.Product;
import model.Util;

/**
 * Servlet implementation class SearchAjax
 */
@WebServlet("/search")
public class SearchAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ProductDAO productDAO;
    public SearchAjax() {
        super();
        productDAO = new ProductDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		List<Product> list = productDAO.getProductsByKey(key);
		
		
		try{
			PrintWriter out = response.getWriter();
			out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Thế giới giày</title>");
		    out.println("</head>");
		    out.println("<body>");
		    for(Product p: list) {
		    	out.println("<div class=\"product-item\"\r\n"
		    			+ "							onclick=\"window.location.href = 'detail?id=${item.id}'\">\r\n"
		    			+ "							<div class=\"discount\">-"+ p.getDiscount() +"%</div>\r\n"
		    			+ "							<img class=\"product-img\" src=\"img/products_img/"+ p.getImage() +"\"\r\n"
		    			+ "								alt=\"product_image\">\r\n"
		    			+ "\r\n"
		    			+ "							<p class=\"product-name\">"+ p.getName() +" | "+ p.getId() + "</p>\r\n"
		    			+ "							<span class=\"product-price\">"+ String.format("%,d", (int)Util.costAfterDiscount(p.getCost(), p.getDiscount())) +" đ\r\n"
		    			+ "							</span><br> <span class=\"product-cost\">" + String.format("%,d",(int)p.getCost()) + " đ</span>\r\n"
		    			+ "\r\n"
		    			+ "							<span><i class=\"fas fa-eye item-hover\"></i></span>\r\n"
		    			+ "						</div>");
		    }
		    
		    out.println("</body>");
		    out.println("</html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
