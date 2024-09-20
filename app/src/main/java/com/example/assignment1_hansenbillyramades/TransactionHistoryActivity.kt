package com.example.assignment1_hansenbillyramades

class TransactionHistoryActivity(private val financeManager: FinanceManager) {

    fun showTransactionHistory() {
        println("Transaction History")
        val history = financeManager.getTransactionHistory()
        if (history.isEmpty()) {
            println("No transactions recorded")
        } else {
            for (transaction in history) {
                println("========||======")
                println("${transaction.type} ${transaction.amount}")
            }
        }
    }
}
