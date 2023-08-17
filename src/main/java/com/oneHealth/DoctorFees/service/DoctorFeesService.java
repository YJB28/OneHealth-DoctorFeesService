package com.oneHealth.DoctorFees.service;

import java.util.List;

import com.oneHealth.DoctorFees.entity.DoctorFees;
import com.oneHealth.DoctorFees.exception.DatabaseException;
import com.oneHealth.DoctorFees.exception.FeesNotFoundException;


/**
 * The DoctorFeesService interface defines the contract for performing operations related
 * to BankDetails. It declares methods for saving, retrieving, updating, and deleting bank details.
 * @author Madhavi
 * @version 3.9.10
 */
public interface DoctorFeesService {

	// Method to save a DoctorFees object in the database and handle DatabaseException if any occurs
	List<DoctorFees> saveDoctorFees(List<DoctorFees> fees) throws DatabaseException;

	// Method to retrieve DoctorFees by its ID and handle FeesNotFoundException if the fees for the given doctorId are not found
	DoctorFees getFeesByID(long doctorId) throws FeesNotFoundException;

	// Method to retrieve a list of all DoctorFees objects from the database and handle DatabaseException if any occurs
	List<DoctorFees> getAllDoctorsFees() throws DatabaseException;

	// Method to update DoctorFees by its ID and handle FeesNotFoundException if the fees for the given doctorId are not found
    DoctorFees updateFeesByID(long doctorId, DoctorFees updatedFees) throws FeesNotFoundException;

    // Method to delete DoctorFees by its ID and handle FeesNotFoundException if the fees for the given doctorId are not found
    DoctorFees deleteFeesByID(long doctorId) throws FeesNotFoundException;
    
    List<DoctorFees> findByDoctorId(long doctorId) throws FeesNotFoundException;
}
