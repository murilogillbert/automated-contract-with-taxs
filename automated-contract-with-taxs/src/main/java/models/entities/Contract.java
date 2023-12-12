package models.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private int number;
	private LocalDateTime date;
	private Double price;
	private List <Installment> listInstallment = new ArrayList<>();;
	
	
	public Contract(int number, LocalDateTime date, Double price) {
		this.number = number;
		this.date = date;
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void addInstallment(Installment inst) {
		listInstallment.add(inst);
	}
	
	public List <Installment> getInstallment() {
		return listInstallment;
	}
	
	
	
}
