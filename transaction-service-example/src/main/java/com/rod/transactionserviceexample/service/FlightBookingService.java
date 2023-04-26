package com.rod.transactionserviceexample.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rod.transactionserviceexample.dto.FlightBookingAcknowledgement;
import com.rod.transactionserviceexample.dto.FlightBookingRequest;
import com.rod.transactionserviceexample.entity.PassengerInfo;
import com.rod.transactionserviceexample.entity.PaymentInfo;
import com.rod.transactionserviceexample.repository.PassengerInfoRepository;
import com.rod.transactionserviceexample.repository.PaymentInfoRepository;
import com.rod.transactionserviceexample.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository; 
	@Autowired
	private PaymentInfoRepository paymentInfoRepository; 
	
	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
		
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		
		return FlightBookingAcknowledgement.build("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}
	
}
