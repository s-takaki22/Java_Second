package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.SampleConfirm;

/**
 * Servlet implementation class SampleRegisterServlet
 */
@WebServlet("/SampleRegisterServlet")
public class SampleRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションスコープのインスタンスを取得
		HttpSession session = request.getSession();

		// セッションから確認済みの登録情報を取得
		SampleConfirm form = (SampleConfirm)session.getAttribute("input_data");
		
		// DB登録処理(省略)
		// XXXDAO.registerXXX(form);
		
		// 登録処理が完了したので、不要なセッションのデータを削除する
		session.removeAttribute("input_data");
		
		String view = "WEB-INF/view/success.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
