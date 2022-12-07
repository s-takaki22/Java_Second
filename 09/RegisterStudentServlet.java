package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.Student;

/**
 * Servlet implementation class RegisterStudentServlet
 */
@WebServlet("/RegisterStudentServlet")
public class RegisterStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		
		// フォーム入力内容の取得
		String name = request.getParameter("name");
		String gradeStr = request.getParameter("grade");
		String email = request.getParameter("email");
		String gen = request.getParameter("gender");
		
		// 適宜、値の変換
		int grade = Integer.parseInt(gradeStr);
		String gender = gen.equals("0") ? "男" : "女";
		
		// 入力された情報を元にインスタンスを生成
		Student student = new Student(name, grade, email, gender);
		
		// SQL実行
		int result = StudentDAO.registerStudent(student);
		
		if(result == 1) {
			String view = "WEB-INF/view/success.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String view = "WEB-INF/view/fail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
