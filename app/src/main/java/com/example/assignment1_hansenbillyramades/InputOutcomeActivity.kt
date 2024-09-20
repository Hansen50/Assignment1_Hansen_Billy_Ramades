package com.example.assignment1_hansenbillyramades

class IncomeExpensesActivity(private val financeManager: FinanceManager) {

    private var validInput = false
    fun menuInputIncome() {
        println("Input Income")

        // ini adalah method untuk inputan serta validasi pemasukan
        validInput = false
        while (!validInput) {
            println("Input your Income: ")
            val income = readlnOrNull()?.trim()?.toIntOrNull()
            if (income == null) {
                println("Invalid income number. Please input a valid number!")
            } else {
                validInput = true
                financeManager.addIncome(income)
                println("The income is $income")
            }
        }

        println("Income have been recorded")
        return
    }

    fun menuInputExpenses() {
        println("Input Expense")
        // ini adalah method untuk inputan serta validasi pengeluaran
        validInput = false
        while (!validInput) {
            print("Enter your expenses: ")
            val expenses = readlnOrNull()?.trim()?.toIntOrNull()
            if (expenses == null) {
                println("Invalid expenses number. Please input a valid number!")
            } else {
                validInput = true
                financeManager.addExpense(expenses)
                println("The expense is $expenses")
            }
        }

        println("Expenses have been recorded")
        return
    }
}