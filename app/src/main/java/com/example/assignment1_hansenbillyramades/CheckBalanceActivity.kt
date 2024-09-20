package com.example.assignment1_hansenbillyramades

// Data class Transaction yang bberfungsi menyimpan tipe transaksi dan jumlah tranksasi (data collection management)
// di dalam kelas ini ada objek tipe dan jumlah yng akan di simpan
data class Transaction(
    val type: TransactionType,
    val amount: Int,
)


// enum class untuk class konstant tipe transaksi yang berisi tipe income dan expenses dan mendefinisikan tipe transaksi
enum class TransactionType {
    INCOME,
    EXPENSE
}

class FinanceManager {


    // properti di sini menggunakan private var (enkapsulasi) karena untuk menjaga konsistensi data nya,
    // dengan ini kita memastikan bahwa variabel income dan expense hanya dapat di ubah sesuai metode yang telh di tentukan
    private val transactions = mutableListOf<Transaction>()
    private var income: Int = 0
    private var expenses: Int = 0

    fun addIncome(amount: Int) {
        income += amount
        transactions.add(Transaction(TransactionType.INCOME, amount))
    }

    // ada objek transaction add untuk menyimpan data di data class
    fun addExpense(amount: Int) {
        expenses += amount
        transactions.add(Transaction(TransactionType.EXPENSE, amount))
    }

    fun getBalance(): Int = income - expenses

    fun getTotalIncome(): Int = transactions
        .filter { it.type == TransactionType.INCOME }
        .sumOf { it.amount }

    fun getTotalExpenses(): Int = transactions
        .filter { it.type == TransactionType.EXPENSE }
        .sumOf { it.amount }

    fun getTransactionHistory(): List<Transaction> = transactions
}

// class ini memiliki properti private value untuk memamggil class finanace manager yang berisikan func akan kita gunakan
class CheckBalanceActivity(private val financeManager: FinanceManager) {
    fun showBalance() {
        println("Your Balance is ${financeManager.getBalance()}")
    }
}
