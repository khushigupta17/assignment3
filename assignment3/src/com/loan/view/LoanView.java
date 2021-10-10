package com.loan.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import com.loan.model.LoanModel;
import com.loan.service.LoanService;

public class LoanView {
	private final LoanService loanService = new LoanService();
	public LoanView() throws IOException {
//		insertLoanData();
//		updateLoanData();
		calculateEmi();
	}
	private void calculateEmi() throws FileNotFoundException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Loan Id: ");
			int productId = sc.nextInt();
			loanService.calculateEmi(productId);

		}
	}
	private void updateLoanData() throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Loan Id: ");
			int productId = sc.nextInt();
			loanService.insertLoanData(productId);

		}
	}
	private void insertLoanData() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Loan Id: ");
			int productId = sc.nextInt();
			System.out.println("Enter Loan Name: ");
			String productName = sc.nextLine();
			System.out.println("Enter Principle Amount: ");
			double principleAmount = sc.nextDouble();
			System.out.println("Enter Tenure: ");
			int tenure=sc.nextInt();
			System.out.println("Enter Rate of Interest: ");
			float rateOfInterest=sc.nextFloat();
			LoanModel loanModel = new LoanModel(productId, productName, principleAmount, tenure, rateOfInterest);
			LoanModel result=loanService.insertLoanData(loanModel);
			if(result!=null)
				System.out.println("Inserted successfully.");
			else
				System.out.println("Not inserted.");
		}
	}
}
