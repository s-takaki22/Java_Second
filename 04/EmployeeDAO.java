package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Employee;

public class EmployeeDAO {
	// DBアクセスに必要な情報の定数を定義
	// 接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcsample?serverTimezone=GMT";
	// ユーザ
	private static final String USER = "updateUser";
	// パスワード
	private static final String PW = "morijyobi";

	//1件のみ検索するSELECT文を実行するメソッドのサンプル
	//引数は検索する学生のID
	public static Employee selectEmployee(String selectEmployeeNumber){
		
		// 実行するSQL
		String sql = "SELECT * FROM employee WHERE employee_number = ?";
				
		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			// プレースホルダに値をセット
			pstmt.setString(1, selectEmployeeNumber);
			
			// SQL実行！
			// ResultSetもcloseする必要があるのでtry-with-resources文を使う
			try (ResultSet rs = pstmt.executeQuery()){
				
				// カーソルを下に1つずらす。next()の戻り値はboolean型
				if(rs.next()) {
					// ResultSetからデータを取り出す
					// getStringやgetIntなど型に応じたメソッドがある。
					// 引数はカラム名を指定する。(SQLのASで別名にしている場合はそちらを指定)
					String employeeNumber = rs.getString("employee_number");
					String name = rs.getString("name");
					int age = rs.getInt("age");

					// Employeeクラスのインスタンスを作って返却する。
					Employee result = new Employee(employeeNumber, name, age);
					return result;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 途中でExceptionが発生した場合や取得結果が0件の場合はnullを返す。
		return null;
	}

	// 全従業員を取得するメソッド
	public static List<Employee> selectAllEmployee(){
		
		// 実行するSQL
		String sql = "SELECT * FROM employee";
		
		// 返却用のListインスタンス
		List<Employee> result = new ArrayList<>();
				
		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			// SQL実行！
			// ResultSetもcloseする必要があるのでtry-with-resources文を使う
			try (ResultSet rs = pstmt.executeQuery()){
				
				// next()がfalseを返すまでループ
				while(rs.next()) {

					// n行目のデータを取得
					String employeeNumber = rs.getString("employee_number");
					String name = rs.getString("name");
					int age = rs.getInt("age");

					// n件目のインスタンスを作成
					Employee employee = new Employee(employeeNumber, name, age);
					
					// インスタンスをListに追加
					result.add(employee);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
	// LIKEを使ったキーワード検索(部分一致)
	public static List<Employee> searchEmployeeByName(String keyword){
		
		// 実行するSQL
		String sql = "SELECT * FROM employee WHERE name LIKE ?";
		// ダメな例 String sql = "SELECT * FROM employee WHERE name LIKE %?%";
		// なぜなら値を埋め込むとSELECT * FROM employee WHERE name LIKE %'keyword'%となるから。
		
		// 返却用のListインスタンス
		List<Employee> result = new ArrayList<>();
				
		try (
				Connection con = DriverManager.getConnection(URL, USER, PW);	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			
			// %や_はここで文字列結合する。そうすると'%keyword%'となる。
			pstmt.setString(1, "%" + keyword + "%");
			
			// SQL実行！
			// ResultSetもcloseする必要があるのでtry-with-resources文を使う
			try (ResultSet rs = pstmt.executeQuery()){
				
				// next()がfalseを返すまでループ
				while(rs.next()) {

					// n行目のデータを取得
					String employeeNumber = rs.getString("employee_number");
					String name = rs.getString("name");
					int age = rs.getInt("age");

					// n件目のインスタンスを作成
					Employee employee = new Employee(employeeNumber, name, age);
					
					// インスタンスをListに追加
					result.add(employee);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
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
