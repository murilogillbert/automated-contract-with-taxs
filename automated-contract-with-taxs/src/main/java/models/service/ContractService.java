package models.service;

import java.time.LocalDateTime;
import java.util.List;

import models.entities.Contract;
import models.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService){
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		List <Installment> listInstallment = contract.getInstallment();
		for(Installment inst : listInstallment) {
			
			Double interest = onlinePaymentService.interest(contract.getPrice(), months);
			Double paymentFee = onlinePaymentService.paymentFee(interest);
			
			LocalDateTime modifiedMonth = increaseDate(contract,months);
			
			inst.setAmount(paymentFee);
			inst.setDueDate(modifiedMonth);
			
			System.out.println(modifiedMonth+": "+paymentFee);
			
		}
	}
	
	public LocalDateTime increaseDate(Contract contract, int months) {
		LocalDateTime date = contract.getDate();
		date.plusMonths(months);
		return date; 
	}
}
