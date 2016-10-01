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

//doRegister������ url����
@WebServlet("/doRegister")

public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//registerForm.jsp���� request ��ü�� ������ �� getParameter�޼ҵ带 ���� �ҷ�����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		// Perform business logic. Return a bean as result.
		
		//CustomerServiceŬ������ ��ü�� ����� CustomerServiceŬ������ static���� �ޱ�.
		CustomerService service = (CustomerService) CustomerService.getInstance();
		//���� ������ ȸ���� ������ CustomerŬ������ ��ü�� �����ϱ�
		Customer customer = new Customer(id, password, name, gender, email); 
		//���� ������ customer�� service��ü�� �����ϱ�
		service.addCustomer(customer);

		String page;

		//������ ����
		page = "/view/registerSuccess.jsp";
		request.setAttribute("customer", customer);

		//������ page�� �̵�
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
