package com.oneHealth.DoctorFees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.DoctorFees.entity.DoctorFees;

/**
 * The DoctorFeesRepository interface extends JpaRepository to provide the necessary
 * methods for performing CRUD (Create, Read, Update, Delete) operations on the
 * BankDetails entity. It automatically generates the implementation for the
 * repository, allowing interactions with the database and the BankDetails table.
 * @author Madhavi
 * @version 3.9.10
 */
public interface DoctorFeesRepository extends JpaRepository<DoctorFees, Long> {
	
	List<DoctorFees> findByDoctorId(Long doctorId);
	
}
