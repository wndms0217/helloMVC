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

//doRegister페이지 url맵핑
@WebServlet("/doRegister")

public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//registerForm.jsp에서 request 객체에 저장한 값 getParameter메소드를 통해 불러오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		// Perform business logic. Return a bean as result.
		
		//CustomerService클래스의 객체를 만들어 CustomerService클래스의 static변수 받기.
		CustomerService service = (CustomerService) CustomerService.getInstance();
		//새로 가입한 회원의 정보로 Customer클래스의 객체를 생성하기
		Customer customer = new Customer(id, password, name, gender, email); 
		//새로 생성한 customer를 service객체에 저장하기
		service.addCustomer(customer);

		String page;

		//페이지 지정
		page = "/view/registerSuccess.jsp";
		request.setAttribute("customer", customer);

		//지정한 page로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
