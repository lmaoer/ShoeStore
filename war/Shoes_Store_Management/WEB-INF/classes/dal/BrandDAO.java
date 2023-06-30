package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Brand;

public class BrandDAO extends DBContext{
	public Brand getBrandById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// create sql statement
			String sql = "select * from Brands where id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			// execute query 
			rs = stmt.executeQuery();
			
			// process result set
			if(rs.next()) {
				// retrieve data from result set row
				String name = rs.getString("name");
				
				// create new instance
				Brand b = new Brand(id,name);
				return b;
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	public List<Brand> list(){
		List<Brand> brands = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// create sql statement
			String sql = "select * from Brands";
			stmt = connection.createStatement();
			
			// execute query 
			rs = stmt.executeQuery(sql);
			
			// process result set
			while(rs.next()) {
				// retrieve data from result set row
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				// create new instance
				Brand b = new Brand(id,name);
			
				// add to list
				brands.add(b);
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return brands;
	}
	
	public static void main(String[] args) {
		BrandDAO b = new BrandDAO();
		List<Brand> list = b.list();
		for(Brand br: list) {
			System.out.println(br.getId() + " " + br.getName());
		}
	}
}
