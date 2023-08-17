package com.oneHealth.DoctorFees.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oneHealth.DoctorFees.entity.DoctorFees;
import com.oneHealth.DoctorFees.exception.DatabaseException;
import com.oneHealth.DoctorFees.exception.FeesNotFoundException;
import com.oneHealth.DoctorFees.service.DoctorFeesService;

/**
 * Controller class for handling Doctor Fees related HTTP requests.
 * 
 * This class defines methods for saving, retrieving, updating, and deleting doctor fees.
 * It uses a service class, DoctorFeesService, to perform the actual business logic.
 * The controller maps HTTP endpoints to these methods, allowing clients to interact with the application.
 * Additionally, the class includes logging statements to log important events for monitoring and debugging.
 * 
 * Note: Make sure to import the required entities, exceptions, and services from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1.0
 */
//@CrossOrigin("*")
@RestController
@RequestMapping("/api/doctors/doctorfees")
public class DoctorFeesController {

    private final Logger logger = LoggerFactory.getLogger(DoctorFeesController.class);

    @Autowired
    private DoctorFeesService service;

    /**
     * Handles HTTP POST request to save the doctor's fees information into the database.
     *
     * @param fees The DoctorFees object containing the doctor's fees details.
     * @return A ResponseEntity with the response message and HTTP status code.
     * @throws DatabaseException If there is an issue while interacting with the database.
     */
  
    @PostMapping("/saveFees")
    public ResponseEntity<String> saveDoctorFees(@RequestBody List<DoctorFees> fees) throws DatabaseException {
        service.saveDoctorFees(fees);
        logger.info("In Controller - Doctor Fees Saved Successfully : " + fees);
        return new ResponseEntity<>("Doctor Fees Saved Successfully", HttpStatus.CREATED);
    }


    /**
     * Handles HTTP GET request to retrieve the doctor's fees information by doctorId from the database.
     *
     * @param doctorId The ID of the doctor for whom fees information is to be retrieved.
     * @return A ResponseEntity with the DoctorFees object and HTTP status code.
     * @throws FeesNotFoundException If the doctor's fees information is not found in the database.
     */
    @GetMapping("/getDoctorFeesById/{doctorId}")
    public ResponseEntity<DoctorFees> getDoctorFees(@PathVariable(value = "doctorId") Long doctorId) throws FeesNotFoundException {
        DoctorFees obj = service.getFeesByID(doctorId);
        logger.info("In Controller - Doctor Fees Retrieved: " + obj);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Handles HTTP GET request to retrieve the list of all doctors' fees from the database.
     *
     * @return A ResponseEntity with the list of DoctorFees objects and HTTP status code.
     * @throws DatabaseException If there is an issue while interacting with the database.
     */
    @GetMapping("/getAllDoctorFees")
    public ResponseEntity<List<DoctorFees>> getAllDoctorFees() throws DatabaseException {
        List<DoctorFees> doctorFeesList = service.getAllDoctorsFees();
        logger.info("In Controller - All Doctor Fees Retrieved: " + doctorFeesList);
        return new ResponseEntity<>(doctorFeesList, HttpStatus.OK);
    }

    /**
     * Handles HTTP PUT request to update the doctor's fees information by doctorId in the database.
     *
     * @param doctorID     The ID of the doctor whose fees information needs to be updated.
     * @param doctorFees   The DoctorFees object containing the updated doctor's fees details.
     * @return A ResponseEntity with the response message and HTTP status code.
     * @throws FeesNotFoundException If the doctor's fees information is not found in the database.
     */
    @PutMapping("/updateDoctorFeesById/{doctorID}")
    public ResponseEntity<String> updateDoctorFees(@PathVariable(value = "doctorID") long doctorID, @RequestBody DoctorFees doctorFees) throws FeesNotFoundException {
        service.updateFeesByID(doctorID, doctorFees);
        logger.info("In Controller - Doctor Fees Updated Successfully: " + doctorFees);
        return new ResponseEntity<>("Doctor Fees updated Successfully", HttpStatus.CREATED);
    }

    /**
     * Handles HTTP DELETE request to delete the doctor's fees information by doctorId from the database.
     *
     * @param doctorID The ID of the doctor whose fees information needs to be deleted.
     * @return A ResponseEntity with the response message and HTTP status code.
     * @throws FeesNotFoundException If the doctor's fees information is not found in the database.
     */
    @DeleteMapping("/deleteDoctorFeesById/{doctorID}")
    public ResponseEntity<String> deleteFeesByID(@PathVariable(value = "doctorID") long doctorID) throws FeesNotFoundException {
        service.deleteFeesByID(doctorID);
        logger.info("In Controller - Doctor Fees Deleted Successfully with ID: " + doctorID);
        return new ResponseEntity<>("Doctor Fees deleted Successfully", HttpStatus.OK);
    }
    
    @GetMapping("/findDoctorById/{doctorId}")
    public ResponseEntity<List<DoctorFees>> getFindByDoctorId(@PathVariable(value="doctorId") long doctorId) throws FeesNotFoundException{
		
    	List<DoctorFees>obj = service.findByDoctorId(doctorId);
		 return ResponseEntity.ok().body(obj);
    	
    }
}
