package dal;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import model.Brand;
import model.Product;

public class ProductDAO extends DBConnect {
	// convert image into byte array, and then convert to base64 string format
	private String img2base64(Blob blob) {
		String base64Image = "";
		try {
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			byte[] imageBytes = outputStream.toByteArray();

			base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return base64Image;
	}

	public List<Product> list() {
		List<Product> products = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.image, p.imageDetail,p.brandId,"
					+ " b.name AS brand FROM Products p , Brands b WHERE p.brandId = b.id";
			stmt = connection.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result set
			while (rs.next()) {
				String id = rs.getString("id");

				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				String image = img2base64(rs.getBlob("image"));
				String imageDetail = img2base64(rs.getBlob("imageDetail"));
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, image, imageDetail, new Brand(brandId, brand));

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
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.image, p.imageDetail,p.brandId,"
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
				String image = img2base64(rs.getBlob("image"));
				String imageDetail = img2base64(rs.getBlob("imageDetail"));
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, image, imageDetail, new Brand(brandId, brand));

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
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.image, p.imageDetail,p.brandId,"
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
				String image = img2base64(rs.getBlob("image"));
				String imageDetail = img2base64(rs.getBlob("imageDetail"));
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, image, imageDetail, new Brand(brandId, brand));

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
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.image, p.imageDetail,p.brandId,"
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

				String image = img2base64(rs.getBlob("image"));
				String imageDetail = img2base64(rs.getBlob("imageDetail"));
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				// create new instance
				Product p = new Product(id, name, cost, discount, image, imageDetail, new Brand(brandId, brand));

				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	public void writeBlob(String filename) {
		try {
			String sql = "insert into base64 values(?)";
			PreparedStatement st = connection.prepareStatement(sql);
			File file = new File(filename);
			FileInputStream input = new FileInputStream(file);

			st.setBinaryStream(1, input);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	*/

	private Blob base64toBlob(String base64) {
		Blob b = null;
		byte[] decodedByte = Base64.getDecoder().decode(base64);

		try {
			b = new SerialBlob(decodedByte);
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public void insertProduct(Product p) {
		try {
			// VALUES(id,name,cost,discount,image:base64,imageDetail:base64,brandId)
			String sql = "INSERT INTO Products VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, p.getId());
			st.setString(2, p.getName());
			st.setInt(3, p.getCost());
			st.setInt(4, p.getDiscount());
			if (!p.getImage().equals("")) {
				st.setBlob(5, base64toBlob(p.getImage()));
			} else {
				Blob blob = null;
				st.setBlob(5, blob);
			}

			if (!p.getImageDetail().equals("")) {
				st.setBlob(6, base64toBlob(p.getImageDetail()));
			} else {
				Blob blob = null;
				st.setBlob(6, blob);
			}

			st.setInt(7, p.getBrand().getId());

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	public void tmp2() {
		

		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p.id, p.name, p.cost, p.discount, p.image, p.imageDetail,p.brandId,"
					+ " b.name AS brand FROM tmp p , Brands b WHERE p.brandId = b.id";
			stmt = connection.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result set
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int discount = rs.getInt("discount");
				String image = rs.getString("image");
				String imageDetail = rs.getString("imageDetail");
				int brandId = rs.getInt("brandId");
				String brand = rs.getString("brand");

				tmp(id, name, cost, discount, image, imageDetail, brandId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	public void tmp(String id, String name, int cost, int discount, String image, String imageDetail, int brandId) {
		try {
			// VALUES(id,name,cost,discount,image:base64,imageDetail:base64,brandId)
			String sql = "INSERT INTO Products VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, name);
			st.setInt(3, cost);
			st.setInt(4, discount);
			String path = "E:\\Long\\Learn\\eclipse-default-workspace\\shoes_store_final\\src\\main\\webapp\\img\\products_img\\";
			if (!image.equals("")) {
				
				File file = new File(path+image);
				FileInputStream input = new FileInputStream(file);

				st.setBinaryStream(5, input);
			} else {
				Blob blob = null;
				st.setBlob(5, blob);
			}

			if (!imageDetail.equals("")) {
				File file = new File(path+imageDetail);
				FileInputStream input = new FileInputStream(file);

				st.setBinaryStream(6, input);
			} else {
				Blob blob = null;
				st.setBlob(6, blob);
			}

			st.setInt(7, brandId);

			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 */
}
