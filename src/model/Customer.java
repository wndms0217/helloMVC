package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// ������̼����� �ڵ����� getter,setter,constructor �������ִ� lombok����
@Getter
@Setter
@AllArgsConstructor

//CustomerŬ���� ����
public class Customer {

	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;

}
