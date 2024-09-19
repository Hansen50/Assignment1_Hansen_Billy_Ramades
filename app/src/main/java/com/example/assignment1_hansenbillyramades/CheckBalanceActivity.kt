package com.example.assignment1_hansenbillyramades

// Data class for transactions
data class Transaction(
    val type: TransactionType,
    val amount: Double,
)

enum class TransactionType {
    INCOME,
    EXPENSE
}

class FinanceManager {

    private val transactions = mutableListOf<Transaction>()
    // default saldo dari awal
    private var income: Double = 0.0
    private var expenses: Double = 0.0

    fun addIncome(amount: Double) {
        income += amount
        transactions.add(Transaction(TransactionType.INCOME, amount))
    }

    fun addExpense(amount: Double) {
        expenses += amount
        transactions.add(Transaction(TransactionType.EXPENSE, amount))
    }

    fun getBalance(): Double = income - expenses

    fun getTotalIncome(): Double = transactions
        .filter { it.type == TransactionType.INCOME }
        .sumOf { it.amount }

    fun getTotalExpenses(): Double = transactions
        .filter { it.type == TransactionType.EXPENSE }
        .sumOf { it.amount }

    fun getTransactionHistory(): List<Transaction> = transactions.toList()
}

class CheckBalanceActivity(private val financeManager: FinanceManager) {
    fun showBalance() {
        println("Your Balance is ${financeManager.getBalance()}")
    }
}
