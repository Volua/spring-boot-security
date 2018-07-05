package ua.springweb.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import ua.springweb.security.entity.enumeration.Role;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	private String email;
	private String password;
	
	public UserEntity(UserEntity entity) {
		this.fullName = entity.getFullName();
		this.age = entity.getAge();
		this.password = entity.getPassword();
		this.role = entity.getRole();
	}

	@Column(name = "full_name")
	private String fullName;

	private int age;

	@Enumerated(EnumType.ORDINAL)
	private Role role;

	public UserEntity() {
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
