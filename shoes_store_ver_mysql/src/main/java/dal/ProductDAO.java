package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Brand;
import model.Product;

public class ProductDAO extends DBConnect {
	public List<Product> list() {
		List<Product> products = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.quantity, p.image, p.status, p.imageDetail,p.brandId,"
					+ " b.name AS brand FROM Products p , Brands b WHERE p.brandId = b.id";
			stmt = connection.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result set
			while (rs.next()) {
				// retrieve data from result set row
				String id = rs.getString("id");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String status = rs.getString("status");
				String imageDetail = rs.getString("imageDetail");
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, quantity, image, status, imageDetail,
						new Brand(brandId, brand));

				// add to list
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public List<Product> getListByPage(List<Product> products, int start, int end) {
		ArrayList<Product> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(products.get(i));
		}
		return arr;
	}

	public List<Product> getProductsByKey(String key) {
		List<Product> products = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.quantity, p.image, p.status, p.imageDetail,p.brandId,"
					+ " b.name AS brand FROM Products p , Brands b WHERE p.brandId = b.id AND p.name LIKE ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + key + "%");
			// execute query
			rs = stmt.executeQuery();

			// process result set
			while (rs.next()) {
				// retrieve data from result set row
				String id = rs.getString("id");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String status = rs.getString("status");
				String imageDetail = rs.getString("imageDetail");
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, quantity, image, status, imageDetail,
						new Brand(brandId, brand));

				// add to list
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public List<Product> getProductsByKeyBrand(String key, int bId) {
		List<Product> products = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.quantity, p.image, p.status, p.imageDetail,p.brandId,"
					+ " b.name AS brand FROM Products p , Brands b WHERE p.brandId = b.id AND p.name LIKE ? AND p.brandId = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + key + "%");
			stmt.setInt(2, bId);
			// execute query
			rs = stmt.executeQuery();

			// process result set
			while (rs.next()) {
				// retrieve data from result set row
				String id = rs.getString("id");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String status = rs.getString("status");
				String imageDetail = rs.getString("imageDetail");
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, quantity, image, status, imageDetail,
						new Brand(brandId, brand));

				// add to list
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	public Product getProductById(String id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.quantity, p.image, p.status, p.imageDetail,p.brandId,"
					+ " b.name AS brand FROM Products p , Brands b WHERE p.brandId = b.id AND p.id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			
			// execute query
			rs = stmt.executeQuery();

			// process result set
			if (rs.next()) {
				// retrieve data from result set row

				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				String status = rs.getString("status");
				String imageDetail = rs.getString("imageDetail");
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, quantity, image, status, imageDetail,
						new Brand(brandId, brand));

				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
