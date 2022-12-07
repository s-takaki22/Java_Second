package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;
import dto.Teacher;

/**
 * Servlet implementation class RegisterStudentServlet
 */
@WebServlet("/RegisterTeacherServlet")
public class RegisterTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterTeacherServlet() {
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
		String ageTemp = request.getParameter("age");
		
		// 適宜、値の変換
		int age = Integer.parseInt(ageTemp);
		
		// 入力された情報を元にインスタンスを生成
		Teacher teacher = new Teacher(name, age);
		
		// SQL実行
		int result = TeacherDAO.registerTeacher(teacher);

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
