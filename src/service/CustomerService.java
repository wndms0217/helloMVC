package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	// doLogin, doRegister ��ο��� ���� ���� �ؾ��� -> singleton
	// DB��Ȱ
	// Map<key, value>
	private Map<String, Customer> customers;

	// �̱���
	private static final CustomerService instance = new CustomerService();

	// �����ڸ� private���� ���� ��ü�� �ܺο��� �������� ���ϵ���
	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	// getInstance() �޼ҵ带 static���� �����Ͽ� �ܺο��� ��ü�� ���ٰ���
	public static CustomerService getInstance() {
		return instance;
	}
	
	// customers��� HashMap�� (key, value)������ ����
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer); 
	}

	// Customer bean ��ü return
	public Customer login(String id, String password) {

		//Customer Ŭ������ ��ü login_customer����
		//����� customers �� id�� loginForm.jsp���� �Է��� id�� ���� Customer ��ü �ޱ�. 
		Customer login_customer = customers.get(id.toLowerCase());
		//���� ���� id�� Customer�� ������ ���
		if (login_customer != null) {
			//�� customer�� �н������ loginForm.jsp���� �Է��� �н����尡 ��ġ�ϴ��� Ȯ��
			if (password.equals(login_customer.getPassword())) {
				//��ġ�Ѵٸ� �� Customer ��ü�� ����
				return (login_customer);
			}
			//�н����尡 ��ġ���� ���� ��� ��� null�� ����.
			else
				return null;
		}
		//���� ���� id�� Customer�� �������� ���� ��� null�� ����
		else
			return null;
	}

}
