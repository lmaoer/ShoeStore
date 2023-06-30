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

import dal.BrandDAO;
import model.Brand;


@WebServlet("/brand/*")
public class BrandApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson _gson = null;
	private BrandDAO brandDAO;

	public BrandApi() {
		super();
		_gson = new Gson();
		brandDAO = new BrandDAO();
	}

	private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
		response.setContentType("application/json");

		String res = _gson.toJson(obj);

		PrintWriter out = response.getWriter();

		out.print(res);
		out.flush();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HashMap<String, Brand> listMap = new HashMap();
		List<Brand> list = brandDAO.list();
		for(Brand p: list) {
			listMap.put(String.valueOf(p.getId()), p);
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

		String brandId = splits[1];
		
		if(!listMap.containsKey(brandId)) {
			
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		sendAsJson(response, listMap.get(brandId));
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
