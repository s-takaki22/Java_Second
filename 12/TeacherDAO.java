package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Teacher;

public class TeacherDAO {

	// DBへのConnectionを取得(参考：これまで教えていたやり方)
//	private static Connection getConnection() throws URISyntaxException, SQLException {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	    String username = "postgres";
//	    String password = "morijyobi";
//	    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
//
//	    return DriverManager.getConnection(dbUrl, username, password);
//	}
	
	// DBへのConnectionを取得（本番環境/テスト環境 切り替え用）
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	// 引数の Student インスタンスを元にデータを1件INSERTするメソッド
	public static int registerTeacher(Teacher teacher) {
		String sql = "INSERT INTO teacher VALUES(default, ?, ?, current_timestamp)";
		int result = 0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, teacher.getName());
			pstmt.setInt(2, teacher.getAge());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
}
