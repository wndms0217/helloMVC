package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 어노테이션으로 자동으로 getter,setter,constructor 생성해주는 lombok연동
@Getter
@Setter
@AllArgsConstructor

//Customer클래스 생성
public class Customer {

	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;

}
