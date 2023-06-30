package dal;

import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Brand;
import model.Product;

public class ProductDAO extends DBContext {
	public List<Product> list() {
		List<Product> products = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			// create sql statement
			String sql = "select p.id, p.name, p.cost, p.discount, p.quantity, p.image, p.status, p.imageDetail,p.brandId,"
					+ " b.name as brand from Products p , Brands b where p.brandId = b.id";
			stmt = connection.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result set
			while (rs.next()) {
				// retrieve data from result set row
				String id = rs.getString("id");
				String name = rs.getString("name");
				double cost = rs.getFloat("cost");
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

		} catch (Exception e) {
			System.out.println(e);
		}

		return products;
	}

	public void add(Product product) {
		PreparedStatement stmt = null;

		try {
			String sql = "insert into Products values(?,?,?,?,?,?,?,?,?)";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getCost());
			stmt.setInt(4, product.getDiscount());
			stmt.setInt(5, product.getQuantity());
			stmt.setString(6, product.getImage());
			stmt.setString(7, product.getStatus());
			stmt.setString(8, product.getImageDetail());
			stmt.setInt(9, product.getBrand().getId());

			stmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void delete(String id) {
		PreparedStatement stmt = null;
		try {
			String sql = "delete from Products where id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Product load(String id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// create sql statement
			String sql = "select p.id, p.name, p.cost, p.discount, p.quantity, p.image, p.status, p.imageDetail,p.brandId,"
					+ " b.name as brand from Products p , Brands b where p.brandId = b.id and p.id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, id);
			// execute query
			rs = stmt.executeQuery();

			// process result set
			if (rs.next()) {
				// retrieve data from result set row

				String name = rs.getString("name");
				double cost = rs.getFloat("cost");
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

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public void update(Product product, String old_id) {
		PreparedStatement stmt = null;
		try {
			String sql = "update Products set id=?,name=?,cost=?,discount=?,quantity=?,"
					+ " image=?,status=?,imageDetail=?,brandId=? where id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getCost());
			stmt.setInt(4, product.getDiscount());
			stmt.setInt(5, product.getQuantity());
			stmt.setString(6, product.getImage());
			stmt.setString(7, product.getStatus());
			stmt.setString(8, product.getImageDetail());
			stmt.setInt(9, product.getBrand().getId());
			stmt.setString(10, old_id);
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<Product> getListByPage(List<Product> products, int start, int end) {
		ArrayList<Product> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(products.get(i));
		}
		return arr;
	}

	public List<Product> search(String key) {
		List<Product> products = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// create sql statement
			String sql = "select p.id, p.name, p.cost, p.discount, p.quantity, p.image, p.status, p.imageDetail,p.brandId,"
					+ " b.name as brand from Products p , Brands b where p.brandId = b.id and p.name like ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + key + "%");

			// execute query
			rs = stmt.executeQuery();

			// process result set
			while (rs.next()) {
				// retrieve data from result set row
				String id = rs.getString("id");
				String name = rs.getString("name");
				double cost = rs.getFloat("cost");
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

		} catch (Exception e) {
			System.out.println(e);
		}

		return products;
	}
}
