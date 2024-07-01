package com.fdmgroup.streamsExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Runner {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount(12345678, 987654, "Mr J Smith", "savings", 1.1, 25362.91);
        BankAccount account2 = new BankAccount(87654321, 234567, "Ms J Jones", "current/checking", 0.2, 550);
        BankAccount account3 = new BankAccount(74639572, 946284, "Dr T Williams", "savings", 1.1, 4763.32);
        BankAccount account4 = new BankAccount(94715453, 987654, "Ms S Taylor", "savings", 1.1, 10598.01);
        BankAccount account5 = new BankAccount(16254385, 234567, "Mr P Brown", "current/checking", 0.2, -195.74);
        BankAccount account6 = new BankAccount(38776543, 946284, "Ms F Davies", "current/checking", 0.2, -503.47);
        BankAccount account7 = new BankAccount(87609802, 987654, "Mr B Wilson", "savings", 1.1, 2.5);
        BankAccount account8 = new BankAccount(56483769, 234567, "Dr E Evans", "current/checking", 0.2, -947.72);
        Logger myLogger = LogManager.getLogger(Runner.class);
        List<BankAccount> accounts = new ArrayList<>(Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
        
        long count = accounts.stream().filter(account -> account.getAccountType().equals("current/checking")).count();
        System.out.println("The number of current/checking accounts in the ArrayList: " + count);
        
        long numOfOverDrawnAccs = accounts.stream().filter(account -> account.getBalance() < 0).count();
        System.out.println("The number of accounts which are overdrawn: " + numOfOverDrawnAccs);
        
        OptionalDouble highestAccountBalance = accounts.stream().mapToDouble(account -> account.getBalance()).max();
        if (highestAccountBalance.isPresent()) {
        	System.out.println("Highest account balance: " + highestAccountBalance.getAsDouble());
        } else {
        	System.out.println("There is no highest balance");
        }
        OptionalDouble averageAccountBalance = accounts.stream().mapToDouble(account -> account.getBalance()).average();
        if (averageAccountBalance.isPresent()) {
        	System.out.println("Average account balance: " + averageAccountBalance.getAsDouble());
        } else {
        	System.out.println("There is no average balance");
        }
        double sumofAllOverdraftedBalances = accounts.stream().filter(account -> account.getBalance() < 0).mapToDouble(account -> account.getBalance()).sum();
        System.out.println("Sum of all overdrafts: " + sumofAllOverdraftedBalances);
        
        double totalAmountOfInterest = accounts.stream().filter(account -> account.getBalance() > 0).mapToDouble(account -> account.getBalance() * account.getInterestRate()).sum() / 100; 
        System.out.println("Total amount of interest due: " + totalAmountOfInterest);
        
        System.out.println("---------------------");
        
        ArrayList<String> namesOfOverdrawnAccounts = (ArrayList<String>) accounts.stream().filter(account -> account.getBalance() < 0).map(account -> account.getAccountHolder()).collect(Collectors.toList());
        System.out.println("Names of overdraw accounts: " + namesOfOverdrawnAccounts);
        
        accounts.stream().filter(account -> account.getAccountType().equals("savings")).forEach(account -> account.setInterestRate(1.3));
        ArrayList<BankAccount> savingsAccounts = (ArrayList<BankAccount>) accounts.stream().filter(account -> account.getAccountType().equals("savings")).collect(Collectors.toList());
        System.out.println("Savings Accounts: " + savingsAccounts);
        
        accounts.stream().filter(account -> account.getBankCode() == 234567).forEach(account -> account.setBankCode(123456));
        System.out.println(accounts);
        
        ArrayList<BankAccount> newBankCode = (ArrayList<BankAccount>) accounts.stream().filter(account -> account.getBankCode() == 987654).collect(Collectors.toList());
        System.out.println("Accounts with bank code 987654: " + newBankCode);
        
        ArrayList<BankAccount> drInNameAccounts = (ArrayList<BankAccount>) accounts.stream().filter(account -> account.getAccountHolder().substring(0, 2).equals("Dr")).collect(Collectors.toList());
        System.out.println("Accounts with 'Dr' titles: " + drInNameAccounts);
        
        
        BankAccount bAWithHighestBalance = accounts.stream().reduce(account1, (a, b) -> a.getBalance() > b.getBalance() ? a : b);
        System.out.println("Bank account with highest balance: " + bAWithHighestBalance);
        BankAccount bAWithLowestBalanceWithBankCode987654 = accounts.stream().filter(account -> account.getBankCode() == 987654).reduce(account1, (a, b) -> a.getBalance() < b.getBalance() ? a : b);
        System.out.println("Bank account with lowest balance that has bank code 987654: " + bAWithLowestBalanceWithBankCode987654);
       // myLogger.info("TESTING!!!");
        

        
        

        
        
	}

}
