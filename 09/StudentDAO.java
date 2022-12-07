package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Student;

public class StudentDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/school_management?serverTimezone=Asia/Tokyo";
	private static final String USER = "AppUser";
	private static final String PW = "morijyobi";

	private static void loadDriver() {
		try {
			// JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 引数の Student インスタンスを元にデータを1件INSERTするメソッド
	public static int registerStudent(Student student) {
		loadDriver();
		
		String sql = "INSERT INTO students VALUES(null, ?, ?, ?, ?)";

		// return用の変数
		int result = 0;
		
		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getGrade());
			pstmt.setString(3, student.getEmail());
			pstmt.setString(4, student.getGender());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
}
