package com.fdmgroup.lambdaExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Runner {

	public static void main(String[] args) {
		 List<BankAccount> accounts = new ArrayList<>();
		Logger logger = LogManager.getLogger(Runner.class);
		 BankAccount account1 = new BankAccount(12345678, 987654, "Mr J Smith", "savings", 1.1, 25362.91);
	        BankAccount account2 = new BankAccount(87654321, 234567, "Ms J Jones", "current/checking", 0.2, 550);
	        BankAccount account3 = new BankAccount(74639572, 946284, "Dr T Williams", "savings", 1.1, 4763.32);
	        BankAccount account4 = new BankAccount(94715453, 987654, "Ms S Taylor", "savings", 1.1, 10598.01);
	        BankAccount account5 = new BankAccount(16254385, 234567, "Mr P Brown", "current/checking", 0.2, -195.74);
	        BankAccount account6 = new BankAccount(38776543, 946284, "Ms F Davies", "current/checking", 0.2, -503.47);
	        BankAccount account7 = new BankAccount(87609802, 987654, "Mr B Wilson", "savings", 1.1, 2.5);
	        BankAccount account8 = new BankAccount(56483769, 234567, "Dr E Evans", "current/checking", 0.2, -947.72);



	
		Function<BankAccount, String> customerFullName = person -> person.getAccountHolder() + ": " + person.getBalance();
		logger.info(customerFullName.apply(account3));
		logger.info(customerFullName.apply(account4));
		//problem 2
		Function<BankAccount, Double> amountOfInterestDue = account -> account.getBalance() * account.getInterestRate() / 100;
		logger.info(amountOfInterestDue.apply(account2));
		
		//problem 3
		Function<BankAccount, Double> amountOfInterestDueIncludingOverDrawn = account -> (account.getBalance() > 0) ?  account.getBalance() * account.getInterestRate() / 100 : 0.0;
		logger.info(amountOfInterestDueIncludingOverDrawn.apply(account2));
		
		//problem 4
		Predicate<BankAccount> isCurrentAccount = account -> account.getAccountType().equals("current/checking");
		logger.info(isCurrentAccount.test(account1));
		logger.info(isCurrentAccount.test(account6));
		
		//problem 5
		Predicate<BankAccount> isOverDrawn = account -> account.getBalance() < 0;
		logger.info(isOverDrawn.test(account5));
		logger.info(isOverDrawn.test(account7));
		
		//problem 6
		BinaryOperator<BankAccount> returnsBankAccountWithHighestBalance = (acc1, acc2) -> (acc1.getBalance() > acc2.getBalance())  ? acc1 : acc2;
		logger.info(returnsBankAccountWithHighestBalance.apply(account3, account4));
		
		//problem 7
		Consumer<BankAccount> deduct10DollarFee = account -> account.setBalance(account.getBalance() - 10.0);
		
		deduct10DollarFee.accept(account2);
		deduct10DollarFee.accept(account6);
		logger.info(account2.getBalance());
		logger.info(account6.getBalance());
		
		//problem 8
		BiConsumer<BankAccount, Integer>  deductIntergerFromAccountBalance = (account, deduction) -> account.setBalance(account.getBalance() - deduction);
		deductIntergerFromAccountBalance.accept(account1, 100);
		deductIntergerFromAccountBalance.accept(account5, 50);
		
		logger.info(account1.getBalance());
		logger.info(account5.getBalance());
		// 1.3 Writing Lambdas for List Methods
		
		//Problem 1
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		accounts.add(account5);
		accounts.add(account6);
		accounts.add(account7);
		accounts.add(account8);
		
		//Problem 2
		accounts.forEach(account -> System.out.println(account.getAccountNumber() + " : " + account.getAccountHolder() + " : " + account.getAccountType() + " : " + account.getBalance()));
		
		//problem 3
		accounts.forEach(account -> account.setBalance(account.getBalance() - 10));
		accounts.forEach(account -> System.out.println(account.getAccountNumber() + " : " + account.getAccountHolder() + " : " + account.getAccountType() + " : " + account.getBalance()));

		//problem 4
		accounts.removeIf(account -> account.getBalance() < 0);
		accounts.forEach(account -> System.out.println(account.getAccountNumber() + " : " + account.getAccountHolder() + " : " + account.getAccountType() + " : " + account.getBalance()));

		//problem 5
		accounts.removeIf(account -> account.getAccountType().equals("savings"));
		
		// 1.4 writing lambdas for Comparators
		System.out.println("------1.4 Writing lambdas for Comparators-----------");
		accounts.removeAll(accounts);
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		accounts.add(account5);
		accounts.add(account6);
		accounts.add(account7);
		accounts.add(account8);
		
		
		//problem 1
		Collections.sort(accounts, (acc1, acc2) -> Double.compare(acc1.getBalance(), acc2.getBalance()));
		accounts.forEach(account -> logger.info(account.getAccountNumber() + " : " + account.getAccountHolder() + " : " + account.getAccountType() + " : " + account.getBalance()));
		
		//problem 2
		Collections.sort(accounts, (acc1, acc2) -> acc1.getAccountType().compareTo(acc2.getAccountType()));
		accounts.forEach(account -> logger.info(account.getAccountNumber() + " : " + account.getAccountHolder() + " : " + account.getAccountType() + " : " + account.getBalance()));

		//problem 3
		Collections.sort(accounts, (acc1, acc2) -> Integer.compare(acc1.getAccountNumber(), acc2.getAccountNumber()));
		accounts.forEach(account -> logger.info(account.getAccountNumber() + " : " + account.getAccountHolder() + " : " + account.getAccountType() + " : " + account.getBalance()));

		
		//problem 4
		Collections.sort(accounts, (acc1, acc2) -> {
			int result = acc1.getAccountType().compareTo(acc2.getAccountType());
			if (result == 0) {
				return Double.compare(acc1.getBalance(), acc2.getBalance());
			}
			return result;
		});
		accounts.forEach(account -> logger.info(account.getAccountNumber() + " : " + account.getAccountHolder() + " : " + account.getAccountType() + " : " + account.getBalance()));
		
		logger.info("----1.5 writing lambdas for Map.merg()-----");
		
		//problem 1
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		//problem 2
		for (BankAccount acc : accounts) {
			hm.merge(acc.getBankCode(), 1, (old, newer) -> old + newer);
		}
		
		hm.forEach((k, v) -> logger.info(k + " :  " + v));
		
		//problem 3
		Map<Integer, Double> sumOfAccsPerBankCode = new HashMap<>();
		
		//problem 4
		for (BankAccount acc : accounts) {
			sumOfAccsPerBankCode.merge(acc.getBankCode(), acc.getBalance(), (old, newer) -> old + newer);
		}
		sumOfAccsPerBankCode.forEach((k, v) -> logger.info("Bank code: " + k + ", balance: " + v));
		
		
		

		
		

	}

}
