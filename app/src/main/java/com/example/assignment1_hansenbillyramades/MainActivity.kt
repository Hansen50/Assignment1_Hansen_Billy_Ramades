package com.example.assignment1_hansenbillyramades

fun main() {

    val financeManager = FinanceManager
    val incomeExpensesActivity = IncomeExpensesActivity(financeManager)
    val checkBalanceActivity = CheckBalanceActivity(financeManager)
    val transactionHistoryActivity = TransactionHistoryActivity(financeManager)
    val financialAnalysisActivity = FinancialAnalysisActivity(financeManager)

    // menggunakan while looping yang dapat membuat pengulangan ketika pilih menu sampai kita memilih untuk break
    while (true) {
        println("\nWelcome to the Personal Finance Manager Application!!!")
        println("\nMain Menu")
        println("1. Income")
        println("2. Expenses")
        println("3. Balance")
        println("4. Transactions History")
        println("5. Financial Summary")
        println("6. Exit")
        println("Choose Menu: ")

        val menu = readlnOrNull()?.trim()?.toIntOrNull()
        when (menu) {
            1 -> incomeExpensesActivity.menuInputIncome()
            2 -> incomeExpensesActivity.menuInputExpenses()
            3 -> checkBalanceActivity.showBalance()
            4 -> transactionHistoryActivity.showTransactionHistory()
            5 -> financialAnalysisActivity.showFinancialAnalysis()
            6 -> {
                println("Thanks for using our application, have a good day!")
                break
            }

            else -> println("No Menu Option. Please try again.")
        }
    }
}
