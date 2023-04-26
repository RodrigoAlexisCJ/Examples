package com.rod.transactionserviceexample.dto;

import com.rod.transactionserviceexample.entity.PassengerInfo;
import com.rod.transactionserviceexample.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
	
	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;

}
