package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
//doLogin page url맵핑
@WebServlet("/doLogin")

public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//loginForm 페이지에서 저장된 값 post형태로 가져오기.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//Perform business logic. Return a bean as result.
		
		//CustomerService클래스의 객체를 하나 만들어 CustomerService의 static객체를 받기.
		CustomerService service = (CustomerService) CustomerService.getInstance();
		//login메소드에서 아이디와 패스워드가 일치하는 Customer객체를 리턴. 일치하는 Customer객체가 존재하지 않을 경우 null값 리턴
		Customer customer = service.login(id,password); 
		
		String page;
		
		//로그인 성공 여부에 따라 페이지 지정
		if(customer == null){
			page = "/view/loginFail.jsp";
			request.setAttribute("id", id);
		}
		else{
			page = "/view/loginSuccess.jsp";
			request.setAttribute("customer", customer);
		}
		//지정된 page로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}

}
