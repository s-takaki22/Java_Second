package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Employee;

public class EmployeeDAO {
	// DBアクセスに必要な情報の定数を定義
	// 接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcsample?serverTimezone=GMT";
	// ユーザ
	private static final String USER = "updateUser";
	// パスワード
	private static final String PW = "morijyobi";

	// 引数の Employee インスタンスを元にデータを1件INSERTするメソッド
	public static void registerEmployee(Employee emp) {

		// 発行するSQL
		// ? はプレースホルダといいます。
		// 後の処理で ? に値を埋め込みます。(SQLインジェクション対策)
		String sql = "INSERT INTO employee VALUES(?, ?, ?)";
		
		// 更新件数を格納する変数
		int result = 0;

		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			// プレースホルダに値を設定(型によってメソッドが違います。)
			// 第1引数：何番目の ? に設定するか(1から数える)
			// 第2引数：設定する値
			pstmt.setString(1, emp.getEmployeeNumber());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getAge());

			// SQLの実行(戻り値は更新件数)
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
	}

	// 引数の社員番号を元にデータを1件 DELETE するメソッド
	public static void deleteEmployee(String employeeNumber) {
		String sql = "DELETE FROM employee WHERE employee_number = ?";
		int result = 0;

		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			pstmt.setString(1, employeeNumber);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
	}
}
