package com.loan.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.loan.dao.LoanDao;
import com.loan.model.LoanModel;

public class LoanService {
	private final LoanDao loanDao = new LoanDao();
	public LoanModel insertLoanData(LoanModel loanModel) {
		LoanModel loanModelDao=loanDao.insertLoanData(loanModel);
		return loanModelDao;
	}
	public void insertLoanData(int productId) throws IOException {
		loanDao.updateLoanData(productId);
		
	}
	public void calculateEmi(int productId) throws FileNotFoundException {
		loanDao.calculateEmi(productId);
		
	}

}
