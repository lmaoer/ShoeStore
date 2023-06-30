
package dal;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Base64_DAO extends DBConnect_mysql {
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

	public List<String> imageBase64() {
		List<String> list = new ArrayList<String>();
		String sqlString = "select * from base64";

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = connection.createStatement();

			rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				Blob blob = rs.getBlob("img");

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();

				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				list.add(base64Image);
				inputStream.close();
				outputStream.close();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public static void main(String[] args) {
//		Base64_DAO base64_DAO = new Base64_DAO(); //
//		base64_DAO.writeBlob("C:\\Users\\NC.DESKTOP-8TG1B6T\\Desktop\\1.jpg");
//		List<String> list = base64_DAO.imageBase64();
//		System.out.println(list.get(0));
		try {
		File f = new File("E:\\Long\\Learn\\eclipse-default-workspace\\shoes_store_final\\src\\main\\webapp\\img\\products_img\\ultra-boost-shoes-black-af5141-01-standard.jpg");
        FileInputStream fin = new FileInputStream(f);
        byte imagebytearray[] = new byte[(int)f.length()];
        fin.read(imagebytearray);
        String imagetobase64 = Base64.getEncoder().encodeToString(imagebytearray);
        System.out.println(imagetobase64);
        System.out.println(1);
        fin.close();
		}catch(Exception e) {
        	System.out.println(e);
        }
	}
}
