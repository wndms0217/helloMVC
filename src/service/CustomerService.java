package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	// doLogin, doRegister 모두에서 접근 해야
	// DB역활
	// Map<key, value>
	private Map<String, Customer> customers;

	// 싱글톤
	private static final CustomerService instance = new CustomerService();

	public CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	public static CustomerService getInstance() {
		return instance;
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer); // HashMap에 (key, value)값
	}

	// Customer bean 객체 return
	public Customer login(String id, String password) {
			Customer cus = customers.get(id.toLowerCase());
			if (cus != null){
				if (password.equals(cus.getPassword())) {
					return (cus);
				} else
					return null;
			}
			else return null;
		}

	

}
