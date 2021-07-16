package com.employerSystem.model.employe;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeService {

	private final EmployeRepository employeRepository;
	
	@Autowired
	public EmployeService(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}
	
	public  List<Employe> getEmploye(){
		return employeRepository.findAll();
	}

	public void addNewEmploye(Employe employe) {
		Optional<Employe> employeOptional = employeRepository.findEmployeByEmail(employe.getEmail());
		
		if(employeOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		employeRepository.save(employe);
		
	}

	public void deletEmploye(Long employeId) {
		boolean exists = employeRepository.existsById(employeId);
		if(!exists) {
			throw new IllegalStateException("student with id " + employeId + " does not exists");
		}
		employeRepository.deleteById(employeId);
	}


	@Transactional
	public void updeteEmploye(Long employeId, String firstName, String lastName, String email, Integer salary) {
		
		Employe employe = employeRepository.findById(employeId).orElseThrow(() -> 
			new IllegalStateException("Employee with id " + employeId + " does not exist")
				);
		
		// Update first name
		if(firstName != null && firstName.length() > 0 && !Objects.equals(employe.getFirstName(), firstName)) {
			employe.setFirstName(firstName);
		}
		
		// Update last name
		if(lastName != null && lastName.length() > 0 && !Objects.equals(employe.getLastName(), lastName)) {
			employe.setLastName(lastName);
		}
		
		// Update email
		if(email != null && email.length() > 0 && !Objects.equals(employe.getEmail(), email)) {
			
			// Text if this email is exists
			Optional<Employe> employeOptional = employeRepository.findEmployeByEmail(email);
			if(employeOptional.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			employe.setEmail(email);
		}
		
		// Update salary
		if(salary != null && salary > 0 && !Objects.equals(employe.getSalary(), salary)) {
			employe.setSalary(salary);
		}
	}

	public Optional<Employe> getEmployeById(Long employeId) {
		// Test if this Employee with this id is fond 
		Optional<Employe> employeOptional = employeRepository.findEmployeById(employeId);
		if(employeOptional.isEmpty()) {
			throw new IllegalStateException("Employee with id " + employeId + " does not exists");
		}
		
		return employeRepository.findById(employeId);
	}
}













