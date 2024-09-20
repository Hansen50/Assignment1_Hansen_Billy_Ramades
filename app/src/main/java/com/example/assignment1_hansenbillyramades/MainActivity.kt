package com.example.assignment1_hansenbillyramades

fun main() {

    val financeManager = FinanceManager()
    val incomeExpensesActivity = IncomeExpensesActivity(financeManager)
    val checkBalanceActivity = CheckBalanceActivity(financeManager)
    val transactionHistoryActivity = TransactionHistoryActivity(financeManager)
    val financialAnalysisActivity = FinancialAnalysisActivity(financeManager)

    // menggunakan while looping yang dapat membuat pengulangan ketika pilih menu sampai kita memilih untuk break
    while (true) {
        println("\nWelcome to the Personal Finance Manager Application!!!")
        println("\nMain Menu")
        println("1. Income & Expenses")
        println("2. Balance")
        println("3. Transactions History")
        println("4. Financial Summary")
        println("5. Exit")
        println("Choose Menu: ")

        val menu = readlnOrNull()?.toIntOrNull()
        when (menu) {
            1 -> incomeExpensesActivity.menuIncomeExpenses()
            2 -> checkBalanceActivity.showBalance()
            3 -> transactionHistoryActivity.showTransactionHistory()
            4 -> financialAnalysisActivity.showFinancialAnalysis()
            5 -> {
                println("Thanks for using our application, have a good day!")
                break
            }
            else -> println("No Menu Option. Please try again.")
        }
    }
}
