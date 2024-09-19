//package com.example.assignment1_hansenbillyramades
//
//object FinanceManager {
//    private val transactions = mutableListOf<Transactions>()
//
//    fun setIncome(amount: Double) {
//        transactions.add(Transactions("Income", amount))
//        println("Your Income: $amount")
//    }
//
//    fun setExpenses(amount: Double) {
//        transactions.add(Transactions("Expenses", amount))
//        println("Your Expenses: $amount")
//    }
//
//    fun getTotalIncome(): Double {
//        var totalIncome = 0.0
//        // Menggunakan 'forEach' untuk iterasi dan menghitung total income
//        transactions.forEach { transaction ->
//            if (transaction.type == "Income") {
//                totalIncome += transaction.amount
//            }
//        }
//        return totalIncome
//    }
//
//    fun getTotalExpenses(): Double {
//        var totalExpenses = 0.0
//        // Menggunakan 'forEach' untuk iterasi dan menghitung total expenses
//        transactions.forEach { transaction ->
//            if (transaction.type == "Expenses") {
//                totalExpenses += transaction.amount
//            }
//        }
//        return totalExpenses
//    }
//
//    fun getHistoryTransactions(): List<Transactions> {
//        return transactions
//    }
//}
//
//data class Transactions(
//    val type: String,
//    val amount: Double
//)
