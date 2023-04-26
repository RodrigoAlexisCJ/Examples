package com.rod.transactionserviceexample.dto;

import com.rod.transactionserviceexample.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class FlightBookingAcknowledgement {

	private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
    
}
