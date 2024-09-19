package com.example.assignment1_hansenbillyramades

class IncomeExpensesActivity(val financeManager: FinanceManager) {
    var validInput = false
    fun menuIncomeExpenses() {
        while (true) {
            println("Income & Expenses")

            // Input and validate income
            while (!validInput) {
                println("Input your Income: ")
                val income = readlnOrNull()?.toDoubleOrNull()
                if (income == null) {
                    println("Invalid income number. Please input a valid number!")
                } else {
                    validInput = true
                    financeManager.addIncome(income)
                    println("The income is $income")
                    continue
                }
            }

            // Input and validate expenses
            validInput = false
            while (!validInput) {
                print("Enter your expenses: ")
                val expenses = readlnOrNull()?.toDoubleOrNull()
                if (expenses == null) {
                    println("Invalid expenses number. Please input a valid number!")
                } else {
                    validInput = true
                    financeManager.addExpense(expenses)
                    println("The expense is $expenses")
                }
            }

            println("Income and expenses have been recorded")
            return
        }
    }
}
