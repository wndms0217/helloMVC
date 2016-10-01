package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	// doLogin, doRegister ��ο��� ���� �ؾ�
	// DB��Ȱ
	// Map<key, value>
	private Map<String, Customer> customers;

	// �̱���
	private static final CustomerService instance = new CustomerService();

	public CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	public static CustomerService getInstance() {
		return instance;
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer); // HashMap�� (key, value)��
	}

	// Customer bean ��ü return
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
