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

import dal.ProductDAO;
import model.Product;

import com.google.gson.Gson;

@WebServlet("/load/*")
public class LoadMore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private Gson _gson = null;

	public LoadMore() {
		super();
		productDAO = new ProductDAO();
		_gson = new Gson();
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
		HashMap<String, Product> listMap = new HashMap();

		String pathInfo = request.getPathInfo();

		int st = 0;
		if (pathInfo == null || pathInfo.equals("/")) {
			st = 0;

		}

		String[] splits = pathInfo.split("/");
		/* System.out.println(splits); */
		if (splits.length != 2) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;

		}

		String offset = splits[1];

		st = Integer.parseInt(offset);

		List<Product> list = productDAO.listOffset(st);
		for (Product p : list) {
			listMap.put(p.getId(), p);
		}
		sendAsJson(response, listMap);
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
