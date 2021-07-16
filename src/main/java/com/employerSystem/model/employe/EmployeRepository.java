package com.employerSystem.model.employe;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
	@Query("SELECT s FROM Employe s WHERE s.email = ?1")
	Optional<Employe> findEmployeByEmail(String email);
	
	@Query("SELECT s FROM Employe s WHERE s.id = ?1")
	Optional<Employe> findEmployeById(Long id);
}
