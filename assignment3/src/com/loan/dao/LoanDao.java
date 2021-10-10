package com.loan.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

import com.loan.model.LoanModel;

public class LoanDao {
	private final String fileName = "loandata.csv";
	private File file;
	{
		file = new File(fileName);
	}

	public LoanModel insertLoanData(LoanModel loanModel) {
		if (file.exists()) {
			int flag = 0;
			try (FileReader fileReader = new FileReader(file); Scanner sc = new Scanner(fileReader)) {
				String loan = "";
				try {
					while ((loan = sc.nextLine()) != null) {
						String loanRecord[] = loan.split(",");
						int loanId = Integer.parseInt(loanRecord[0]);
						if (loanModel.getProductId() == loanId)
							flag = 1;
					}
				} catch (Exception e) {
					if (flag == 0) {
						try (FileWriter filewiter = new FileWriter(file, true)) {
							filewiter.write(loanModel.getProductId() + "," + loanModel.getProductName() + ","
									+ loanModel.getPrincipalAmount() + "," + loanModel.getRateOfInterest() + ","
									+ loanModel.getTenure() + "\n");
							return loanModel;
						} catch (Exception ee) {
							ee.printStackTrace();
						}
					} else {
						System.out.println("Id already exists.");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (FileWriter filewiter = new FileWriter(file)) {
				filewiter.write(loanModel.getProductId() + "," + loanModel.getProductName() + ","
						+ loanModel.getPrincipalAmount() + "," + loanModel.getRateOfInterest() + ","
						+ loanModel.getTenure() + "\n");
				return loanModel;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public void updateLoanData(int productId) throws IOException {
		Scanner in = new Scanner(System.in);
		int flag = 0;
		System.out.println("What do you want to update? \nTenure\nRate Of Interest\nAmount");
		String choice = "";
		double amount;
		float rateOfInterest;
		int tenure;
		String fileData = "";
		choice = in.next();
		if (choice.equalsIgnoreCase("tenure")) {
			System.out.println("Enter tenure");
			tenure = in.nextInt();
			try (FileReader fileReader = new FileReader(file); Scanner sc = new Scanner(fileReader)) {
				String loan = "";
				while ((loan = sc.nextLine()) != null) {
					String loanRecord[] = loan.split(",");
					int loanId = Integer.parseInt(loanRecord[0]);
					if (loanId == productId) {
						fileData = fileData + loanRecord[0] + "," + loanRecord[1] + "," + loanRecord[2] + ","
								+ loanRecord[3] + "," + tenure + "\n";
						flag = 1;
					} else {
						fileData = fileData + loan + "\n";
					}
				}
			} catch (Exception e) {
				if (flag == 1) {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(fileData);
					bw.close();
					System.out.println("Done");
				} else {
					System.out.println("Id does not exist.");
				}
			}
		} else if (choice.equalsIgnoreCase("Rate of Interest")) {
			System.out.println("Enter rate of interest");
			rateOfInterest = in.nextFloat();
			try (FileReader fileReader = new FileReader(file); Scanner sc = new Scanner(fileReader)) {
				String loan = "";
				while ((loan = sc.nextLine()) != null) {
					String loanRecord[] = loan.split(",");
					int loanId = Integer.parseInt(loanRecord[0]);
					if (loanId == productId) {
						fileData = fileData + loanRecord[0] + "," + loanRecord[1] + "," + loanRecord[2] + ","
								+ rateOfInterest + "," + loanRecord[4] + "\n";
						flag = 1;
					} else {
						fileData = fileData + loan + "\n";
					}
				}
			} catch (Exception e) {
				if (flag == 1) {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(fileData);
					bw.close();
					System.out.println("Done");
				} else {
					System.out.println("Id does not exist.");
				}
			}
		} else if (choice.equalsIgnoreCase("amount")) {
			System.out.println("Enter amount");
			in.nextLine();
			amount = in.nextDouble();
			try (FileReader fileReader = new FileReader(file); Scanner sc = new Scanner(fileReader)) {
				String loan = "";
				while ((loan = sc.nextLine()) != null) {
					String loanRecord[] = loan.split(",");
					int loanId = Integer.parseInt(loanRecord[0]);
					if (loanId == productId) {
						fileData = fileData + loanRecord[0] + "," + loanRecord[1] + "," + amount + "," + loanRecord[3]
								+ "," + loanRecord[4] + "\n";
						flag = 1;
					} else {
						fileData = fileData + loan + "\n";
					}
				}
			} catch (Exception e) {
				if (flag == 1) {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(fileData);
					bw.close();
					System.out.println("Done");
				} else {
					System.out.println("Id does not exist.");
				}
			}
		} else
			System.out.println("Invalid option.");
	}

	public void calculateEmi(int productId) throws FileNotFoundException {
		int flag = 0;
		int tenure = 0;
		double amount = 0.0;
		float rateOfInterest=0;
		try (FileReader fileReader = new FileReader(file); 
		Scanner sc = new Scanner(fileReader)) {
			String loan = "";
			while ((loan = sc.nextLine()) != null) {
				String loanRecord[] = loan.split(",");
				int loanId = Integer.parseInt(loanRecord[0]);
				if (productId == loanId) {
					rateOfInterest = Float.parseFloat(loanRecord[4]);
					amount = Double.parseDouble(loanRecord[2]);
					tenure = Integer.parseInt(loanRecord[3]);
					flag = 1;
				}
			}
			
		} catch (Exception e) {
			if (flag == 1) {
				double emi = ((amount * rateOfInterest * ((1 + rateOfInterest) * tenure)));
				emi = emi / (((1 + rateOfInterest) * tenure) - 1);
				System.out.println("Emi is: " + emi);
			} else {
				System.out.println("Id does not exist.");
			}
		}
	}

}
