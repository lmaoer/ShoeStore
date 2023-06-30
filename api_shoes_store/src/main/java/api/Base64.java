
package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.Base64_DAO;
import model.Product_base64img;


@WebServlet("/Base64")
public class Base64 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Base64_DAO base64_DAO;
    
    public Base64() {
        super();
        base64_DAO = new Base64_DAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = base64_DAO.imageBase64();
		List<Product_base64img> data = new ArrayList<Product_base64img>();
		
		for(String i: list) {
			data.add(new Product_base64img(i));
		}
		request.setAttribute("data", data);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base64 = request.getParameter("base64");
		
		request.setAttribute("base64", base64);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
