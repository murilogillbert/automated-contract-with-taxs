package models.entities;

import java.time.LocalDateTime;

public class Installment {

	private Double amount;
	private LocalDateTime dueDate;
	
	Installment(LocalDateTime dueDate,Double amount){
		this.amount = amount;
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
}
