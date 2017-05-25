package com.capg.investmentservices.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.capg.investmentservices.dao.InvestmentDAO;
import com.capg.investmentservices.dao.TransactionDao;
import com.capg.investmentservices.model.Investment;
import com.capg.investmentservices.model.Transaction;
import com.capg.investmentservices.service.InvestmentService;
/***
 * Investment service implementation for investment DB
 * @author sujillel
 *
 */
@Service
public class InvestmentServiceImpl implements InvestmentService {
	
	static Logger logger = Logger.getLogger(InvestmentServiceImpl.class);
	
	@Autowired
	private InvestmentDAO investmentDAO;

	@Autowired
	private TransactionDao transactionDao;

	@Value("${max.recent.transactions}")
	private Integer maxRecentTransactions;
	
	public List<Investment> getAllInvestment(Integer customerId) {
		if(customerId == null) {
			logger.warn("Invalid customerId for finding investment list By CustomerId : "+customerId);
			return null;
		}
		logger.info("finding By Customer Id");
		return investmentDAO.findByCustomerId(customerId);
	}

	public Investment getInvestmentDetails(Long investmentId) {
		if(investmentId == null) {
			logger.warn("Invalid investmentId for finding investment list By CustomerId : "+investmentId);
			return null;
		}
		logger.info("finding By Investment Id");
		return investmentDAO.findByInvestmentId(investmentId);
	}

	@Override
	public List<Transaction> getRecentTransactions(Integer accountNum) {
		List<Transaction> txList =null;
		try {
			//startDt = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			//Date endDt =new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			Date startDt = new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
			Date endDt =new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-31");
			txList = transactionDao.getTransactions(accountNum, startDt, endDt);
			
			
			// Get max 10 recent transactions
			if(txList!= null && txList.size()>maxRecentTransactions){
				txList = txList.subList(0, maxRecentTransactions-1);
			}
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		logger.info("Getting Recent Transactions");
		return txList;
	}
}