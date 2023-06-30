package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dal.ProductDAO;
import model.Product;

@WebServlet("/product/*")
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson _gson = null;
	private ProductDAO productDAO;
   
    public ProductAPI() {
        super();
        _gson = new Gson();
      productDAO = new ProductDAO();
    }

 
    private void sendAsJson(
    		HttpServletResponse response, 
    		Object obj) throws IOException {
    		
    		response.setContentType("application/json");
    		
    		String res = _gson.toJson(obj);
    		     
    		PrintWriter out = response.getWriter();
    		  
    		out.print(res);
    		out.flush();
    	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Product> listMap = new HashMap();
		List<Product> list = productDAO.list();
		for(Product p: list) {
			listMap.put(p.getId(), p);
		}
		
		String pathInfo = request.getPathInfo();
		/* System.out.println(pathInfo); */

		if(pathInfo == null || pathInfo.equals("/")){

			sendAsJson(response, listMap);
			return;
		}

		String[] splits = pathInfo.split("/");
		/* System.out.println(splits); */
		if(splits.length != 2) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
			
		}

		String productId = splits[1];
		
		if(!listMap.containsKey(productId)) {
			
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		sendAsJson(response, listMap.get(productId));
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
