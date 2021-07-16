package com.employerSystem.model.employe;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/employe")
public class EmployeController {
	
	private final EmployeService employeService;
	
	@Autowired
	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	@GetMapping
	public List<Employe> getEmploye(){
		return employeService.getEmploye();
	}
	
	@PostMapping
	public void registerNewEmploye(@RequestBody Employe employe) {
		employeService.addNewEmploye(employe);
	}
	
	@DeleteMapping(path = "delet/{employeId}")
	public void deletEmploye(@PathVariable("employeId") Long employeId) {
		employeService.deletEmploye(employeId);
	}
	
	@PutMapping(path = "update/{employeId}")
	public void updateEmploye(
			@PathVariable("employeId") Long employeId,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) Integer salary
			) {
		employeService.updeteEmploye(employeId, firstName, lastName, email, salary);
	}
	
	@GetMapping(path = "{employeId}")
	public Optional<Employe> getEmployeById(@PathVariable("employeId") Long employeId){
		return employeService.getEmployeById(employeId);
		
	}
}













