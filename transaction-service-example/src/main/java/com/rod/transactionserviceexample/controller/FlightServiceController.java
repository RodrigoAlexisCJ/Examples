package com.rod.transactionserviceexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rod.transactionserviceexample.dto.FlightBookingAcknowledgement;
import com.rod.transactionserviceexample.dto.FlightBookingRequest;
import com.rod.transactionserviceexample.service.FlightBookingService;

@RestController
@EnableTransactionManagement
public class FlightServiceController {

	@Autowired
	private FlightBookingService service;


	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}
	
}
