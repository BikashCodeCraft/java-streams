package com.bikash.question4;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class RunTransaction {

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(2, BigDecimal.valueOf(10000),"Deposit"),
                new Transaction(5, BigDecimal.valueOf(5000),"Withdrawal"),
                new Transaction(1, BigDecimal.valueOf(9000),"Deposit"),
                new Transaction(3, BigDecimal.valueOf(1000),"Withdrawal"),
                new Transaction(6, BigDecimal.valueOf(6000),"Deposit"),
                new Transaction(4, BigDecimal.valueOf(5000),"Deposit"),
                new Transaction(7, BigDecimal.valueOf(2000),"Withdrawal")
        );

        calculateTotalBalance(List.of());
        calculateTotalBalance(transactions);

    }

//    Use “Stream.reduce()” to calculate the total balance, assuming that deposits increase the balance and withdrawals decrease it.
    public static void calculateTotalBalance(List<Transaction> transactions){
        BigDecimal totalBalance = transactions.stream()
                .map(transaction -> transaction.getType().equalsIgnoreCase("deposit") ? transaction.getAmount() : transaction.getAmount().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Default to ZERO if the list is empty
        System.out.println("Total Balance : "+totalBalance);
        //Also, calculate the total number of transactions (size of the list).
        System.out.println("Total number of Transaction done : "+ transactions.size()); // Zero if transaction list is empty
    }
}
