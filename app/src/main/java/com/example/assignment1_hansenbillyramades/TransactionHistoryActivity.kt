package com.example.assignment1_hansenbillyramades

class TransactionHistoryActivity(private val financeManager: FinanceManager) {

    fun showTransactionHistory() {
        println("Transaction History")
        val history = financeManager.getTransactionHistory()
        val incomeTransactions = history.filter { it.type == TransactionType.INCOME }
        val expenseTransactions = history.filter { it.type == TransactionType.EXPENSE }
        if (history.isEmpty()) {
            println("No transactions recorded")
        }
            if (incomeTransactions.isNotEmpty()) {
                println("Income Transactions:")
                for (transaction in incomeTransactions) {
                    println("${transaction.type} ${transaction.amount}")
                }
            } else {
                println("No Transactions Income")
            }

        println("=====================")

        if (expenseTransactions.isNotEmpty()) {
            println("Expense Transactions:")
            for (transaction in expenseTransactions) {
                println("${transaction.type} ${transaction.amount}")
            }
        } else {
            println("No Transactions Expense")
        }
        }
    }
