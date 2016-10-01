package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home") //url 맵핑
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//index.jsp에서 저장한 action값 받기. (login 또는 register)
		String action = request.getParameter("action");
		
		String page = null;
		
		//사용자가 선택한 옵션에 따라 페이지 지정
		if(action.equals("login"))
			page="/view/loginForm.jsp";
		else if(action.equals("register"))
			page="/view/registerForm.jsp";
		else
			page="/view/error.jsp";
		
		//지정된 페이지로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
	}

}
