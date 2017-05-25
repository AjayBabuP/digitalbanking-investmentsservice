package com.capg.investmentservices.service;

import java.util.List;

import com.capg.investmentservices.model.Investment;
import com.capg.investmentservices.model.Transaction;

public interface InvestmentService {
	List<Investment> getAllInvestment(Integer customerId);
	Investment getInvestmentDetails(Long investmentId);
	List<Transaction> getRecentTransactions(Integer investmentId);
}
