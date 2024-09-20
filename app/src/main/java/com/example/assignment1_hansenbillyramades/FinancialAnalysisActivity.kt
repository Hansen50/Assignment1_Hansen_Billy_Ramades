package com.example.assignment1_hansenbillyramades

class FinancialAnalysisActivity(private val financeManager: FinanceManager) {
    fun showFinancialAnalysis() {
        val totalIncome = financeManager.getTotalIncome()
        val totalExpense = financeManager.getTotalExpenses()
        val balance = financeManager.getBalance()

        println("Financial Analysis")
        println("---- Total Income: $totalIncome -----")
        println("---- Total Expenses: $totalExpense ----")
        println("---- Balance: $balance ----")
    }
}
