package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// 学生のデータを全件取得する
	public static List<Student> selectAllStudents() {
		loadDriver();
		
		// 返却用変数
		List<Student> result = new ArrayList<>();

		String sql = "SELECT * FROM students";
		
		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String name = rs.getString("name");
					int grade = rs.getInt("grade");
					String email = rs.getString("email");
					String gender = rs.getString("gender");

					Student employee = new Student(name, grade, email, gender);
					
					result.add(employee);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
}
