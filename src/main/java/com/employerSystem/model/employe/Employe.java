package com.employerSystem.model.employe;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Employe {
	
	@Id
	@SequenceGenerator(
			name = "employe_sequence",
			sequenceName = "employe_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "employe_sequence"
			)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dob;
	private Integer salary;
	@Transient
	private Integer age;
	
	
	
	public Employe() {}


	public Employe(Long id, String firstName, String lastName, String email, LocalDate dob, Integer salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.salary = salary;
	}


	public Employe(String firstName, String lastName, String email, LocalDate dob, Integer salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.salary = salary;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", age=" + age + "]";
	}
	
	
	
	
	
	
}
