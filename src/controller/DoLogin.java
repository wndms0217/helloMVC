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
//doLogin page url����
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
		//loginForm ���������� ����� �� post���·� ��������.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//Perform business logic. Return a bean as result.
		
		//CustomerServiceŬ������ ��ü�� �ϳ� ����� CustomerService�� static��ü�� �ޱ�.
		CustomerService service = (CustomerService) CustomerService.getInstance();
		//login�޼ҵ忡�� ���̵�� �н����尡 ��ġ�ϴ� Customer��ü�� ����. ��ġ�ϴ� Customer��ü�� �������� ���� ��� null�� ����
		Customer customer = service.login(id,password); 
		
		String page;
		
		//�α��� ���� ���ο� ���� ������ ����
		if(customer == null){
			page = "/view/loginFail.jsp";
			request.setAttribute("id", id);
		}
		else{
			page = "/view/loginSuccess.jsp";
			request.setAttribute("customer", customer);
		}
		//������ page�� �̵�
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}

}
