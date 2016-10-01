package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	// doLogin, doRegister 모두에서 접근 가능 해야함 -> singleton
	// DB역활
	// Map<key, value>
	private Map<String, Customer> customers;

	// 싱글톤
	private static final CustomerService instance = new CustomerService();

	// 생성자를 private으로 만들어서 객체를 외부에서 생성하지 못하도록
	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	// getInstance() 메소드를 static으로 선언하여 외부에서 객체에 접근가능
	public static CustomerService getInstance() {
		return instance;
	}
	
	// customers라는 HashMap에 (key, value)형으로 저장
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer); 
	}

	// Customer bean 객체 return
	public Customer login(String id, String password) {

		//Customer 클래스의 객체 login_customer생성
		//저장된 customers 중 id가 loginForm.jsp에서 입력한 id와 같은 Customer 객체 받기. 
		Customer login_customer = customers.get(id.toLowerCase());
		//만약 같은 id의 Customer가 존재할 경우
		if (login_customer != null) {
			//그 customer의 패스워드와 loginForm.jsp에서 입력한 패스워드가 일치하는지 확인
			if (password.equals(login_customer.getPassword())) {
				//일치한다면 그 Customer 객체를 리턴
				return (login_customer);
			}
			//패스워드가 일치하지 않을 경우 경우 null값 리턴.
			else
				return null;
		}
		//만약 같은 id의 Customer가 존재하지 않을 경우 null값 리턴
		else
			return null;
	}

}
