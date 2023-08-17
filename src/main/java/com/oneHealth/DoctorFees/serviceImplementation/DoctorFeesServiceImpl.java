package com.oneHealth.DoctorFees.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneHealth.DoctorFees.entity.DoctorFees;
import com.oneHealth.DoctorFees.exception.DatabaseException;
import com.oneHealth.DoctorFees.exception.FeesNotFoundException;
import com.oneHealth.DoctorFees.repository.DoctorFeesRepository;
import com.oneHealth.DoctorFees.service.DoctorFeesService;

/**
 * The DoctorFeesServiceImpl class is responsible for implementing the business logic
 * for managing bank details of doctors. It interacts with the DoctorFeesRepository to perform CRUD operations.
 * 
 * Note: Make sure to import the required entities, exceptions, and repositories from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1.0
 */
@Service
public class DoctorFeesServiceImpl implements DoctorFeesService {

    private final Logger logger = LoggerFactory.getLogger(DoctorFeesServiceImpl.class);

    // Autowire DoctorFeesRepository to perform CRUD operations on the DoctorFees entity
    @Autowired
    private DoctorFeesRepository doctorFeesRepository;
    

    
    // Method to save a DoctorFees object in the database and handle DatabaseException if any occurs
    @Override
    public List<DoctorFees> saveDoctorFees(List<DoctorFees> doctorFees) throws DatabaseException {
        List<DoctorFees> savedFees = doctorFeesRepository.saveAll(doctorFees);
        logger.info("In Service - Doctor Fees Saved Successfully: " + savedFees);
        return savedFees;
    }

    
    
    // Method to retrieve DoctorFees by its ID and handle FeesNotFoundException if the fees for the given doctorId are not found
    @Override
    public DoctorFees getFeesByID(long doctorId) throws FeesNotFoundException {
        DoctorFees fees = doctorFeesRepository.findById(doctorId)
                .orElseThrow(() -> new FeesNotFoundException("No Fees Found with This ID " + doctorId));
        logger.info("In Service - Doctor Fees Retrieved: " + fees);
        return fees;
    }

    
    
    // Method to retrieve a list of all DoctorFees objects from the database and handle DatabaseException if any occurs
    @Override
    public List<DoctorFees> getAllDoctorsFees() throws DatabaseException {
        List<DoctorFees> feesList = doctorFeesRepository.findAll();
        logger.info("In Service - All Doctor Fees Retrieved: " + feesList);
        return feesList;
    }
    
    

    // Method to update DoctorFees by its ID and handle FeesNotFoundException if the fees for the given doctorId are not found
    @Override
    public DoctorFees updateFeesByID(long doctorId, DoctorFees updatedFees) throws FeesNotFoundException {
        DoctorFees doctorFees = doctorFeesRepository.findById(doctorId)
                .orElseThrow(() -> new FeesNotFoundException("No Doctor Fees found with this ID: " + doctorId));
        doctorFees.setFees(updatedFees.getFees());

        DoctorFees updatedFeesResult = doctorFeesRepository.save(doctorFees);
        logger.info("In Service - Doctor Fees Updated Successfully: " + updatedFeesResult);
        return updatedFeesResult;
    }
    
    

    // Method to delete DoctorFees by its ID and handle FeesNotFoundException if the fees for the given doctorId are not found
    @Override
    public DoctorFees deleteFeesByID(long doctorId) throws FeesNotFoundException {
        DoctorFees doctorFees = doctorFeesRepository.findById(doctorId)
                .orElseThrow(() -> new FeesNotFoundException("No Doctor Fees found with this ID: " + doctorId));

        doctorFeesRepository.delete(doctorFees);
        logger.info("In Service - Doctor Fees Deleted Successfully with ID: " + doctorId);
        return doctorFees;
    }



	@Override
	public List<DoctorFees> findByDoctorId(long doctorId) throws FeesNotFoundException {
		
		return doctorFeesRepository.findByDoctorId(doctorId);
	}

}
