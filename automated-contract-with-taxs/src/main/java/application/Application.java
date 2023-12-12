package application;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.entities.Contract;
import models.service.ContractService;
import models.service.PaypalService;

public class Application {

	public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Digite o número do contrato: ");
        int numberContract = scan.nextInt();

        // Consume the newline character left in the buffer
        scan.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDateTime initialDate = LocalDateTime.parse(scan.nextLine(), dtf);

        System.out.print("Digite o valor do contrato: ");
        Double contractPrice = scan.nextDouble();

        System.out.print("Digite o número de parcelas: ");
        int installments = scan.nextInt();

        Contract contract = new Contract(numberContract, initialDate, contractPrice);

        System.out.println("PARCELAS");

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installments);
        scan.close();

    }
}
