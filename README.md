## Authors

- [Hansen Billy R](https://github.com/Hansen50)


# Finance Manager - Phincon Academy Assignment 1

Sebuah aplikasi yang mengelola pengeluaran dan pemasukan uang

## Features

- Input pengeluaran dan pemasukan
- Cek saldo
- Histori transaksi (pengeluaran dan pemasukan)
- Analisis total pengeluaran dan pemasukan

## Class Finance Manager (berisikan fun/method)

```bash
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

```

Class Finance Manager adalah sebuah kelas yang memiliki lebih dari satu method/func untuk mengelola segala aktivitas pada aplikasi

## Cara menggunakan 

*Pilh Menu:*
```bash
  package com.example.assignment1_hansenbillyramades

fun main() {

    val financeManager = FinanceManager()
    val incomeExpensesActivity = IncomeExpensesActivity(financeManager)
    val checkBalanceActivity = CheckBalanceActivity(financeManager)
    val transactionHistoryActivity = TransactionHistoryActivity(financeManager)
    val financialAnalysisActivity = FinancialAnalysisActivity(financeManager)

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

```

![Screenshot 2024-09-18 173504](https://github.com/user-attachments/assets/b47cff95-61b4-48e1-b97d-449ff2108391)

Pada fun main() adaalh sebuah fungsi utama untuk mejalankan program yang menggunakan while untuk loopingan ketika pilih menu.
Menggunakan val menu untuk membuat inputan dan bertipe int untuk memasukan menu yang akan di pilih.
When untuk ketika klik salah satu angka menu maka kita akan di navigasi ke menu berikut sesuai dengan pilihan.
Apabila yang di pilih tidak ada pada menu maka akan menampilkan pesan.
Break untuk memberhentikan suatu aktivitas.


*Cara input pemasukan dan pengeluaran:*

```bash
  1. Pilih menu angka 1 yaitu input Income & expense
  2. Input pemasukan dan pengeluaran dengan angka bertipe double, 
  (jika yang di input tidak sesuai maka akan mengeluarkan validasi)
  3. Jika inputan yang di isi sesuai maka akan mengeluarkan pesan data sudah di simpan
```

![Screenshot 2024-09-20 103233](https://github.com/user-attachments/assets/c82540b8-54f8-41e6-a276-b997d53166c6)

```bash
package com.example.assignment1_hansenbillyramades

class IncomeExpensesActivity(private val financeManager: FinanceManager) {

    private var validInput = false
    fun menuIncomeExpenses() {
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
```

Class IncomeExpenseActivity yang memiliki properti extend ke class FinanceManager karena 
ketika menginput pemasukan dan pengeluaran maka jumlah yang di input akan di simpan ke data collection
data class pada Transaction, fungsi tersebut di ambil pada Class Finanace Manager yaitu:

- AddIncome dan transaction.add untuk menambhkan data ke data class
- AddExpense dan transaction.add untuk menambhkan data ke data class

Di sini ada Variable private untuk validasi input berberntuk boolean untuk mengecek jika yang di input tidak sesuai.
Menggunakan while (mempunyai operator ! karena membalikan tipe boolean ) dan condition if dan else, apabila yang di input tidak sesuai maka akan keluar validasi untuk menginput ulang, 
jika yang di input benar maka validInput berubah menjadi True kemudian jumlah setiap tipe transaksi akan di simpan ke data class.

Enum class di sini juga sangat berperan penting karena untuk mendefinisikan tipe transaksi yaitu Income dan Expense


*Cara cek saldo:*

```bash
  1. Pilih menu angka 2 yaitu check balance
  2. Setelah itu akan menampilkan saldo yang telah di kalkulasi menggunakan function income - expenses
  3. Kembali ke menu awal
```

![Screenshot 2024-09-18 220140](https://github.com/user-attachments/assets/d36ffd02-71ee-4d45-8573-67ccce8b5222)


```bash
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

class CheckBalanceActivity(val financeManager: FinanceManager) {
    fun showBalance() {
        println("Your Balance is ${financeManager.getBalance()}")
    }
}
```
Class CheckBalanceActivity memiliki properti nilai private financeManager untuk memanggil kelas Finance Manager,
kemudian memiliki method/fun showBalance untuk mengprint hasil saldo dari method kalkulasi income - expense pada kelas 
Finance Manager.
Private digunakan untuk menjaga konsistensi data. 

*Cara cek riwayat transaksi:*

```bash
  1. Pilih menu angka 3 yaitu Transaction History
  2. Setelah itu akan menampilkan list transaksi yang di ambil dari data class Transaction yang berisikan tipe transaksi dan jumlah yang telah di input
  3. Kembali ke menu awal
```
![Screenshot 2024-09-18 220250](https://github.com/user-attachments/assets/91d26be1-800c-4010-9263-3d1552f9dc56)

```bash
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

package com.example.assignment1_hansenbillyramades

class TransactionHistoryActivity (val financeManager: FinanceManager) {

    fun showTransactionHistory() {
        println("Transaction History")
        val history = financeManager.getTransactionHistory()
        if (history.isEmpty()) {
            println("No transactions recorded")
        } else {
            for (transaction in history) {
                println("${transaction.type} ${transaction.amount}")
            }
        }
    }
}
```

Dalam class TransactionHistoryActivity memiliki properti untuk memanggil class Finance Manager. 
Kemudian pada kelas ini memiliki condition logic dan nilai histoy yang merefrensikan Class Finance Manager untuk memanggil method getHistoryTransaction.
Jika history nya kosong belum ada inputan maka akan keluar pesan, Apabila tidak kosong maka akan history akan mengambil data class transaction dan menampilkan nya sesuai dengan tipe transaksi serta jumlah sesuai tipe transkasi.

Enum class di sini juga sangat berperan penting karena untuk mendefinisikan tipe transaksi yaitu Income dan Expense

*Cara cek analisis Keuangan:*

```bash
  1. Pilih menu angka 4 yaitu Financial Summary
  2. Akan menampilkan total income dan expense yang telah di keluarkan serta saldo akhir 
     (Di sini menggunakan enum class Transaction Type yang berisikan INCOME & EXPENSE untuk memfilter ketika transaksi nya bertipe income maka jumlah income pada data transaksi akan di jjumlah )
```
![Screenshot 2024-09-18 220428](https://github.com/user-attachments/assets/d20bf561-3492-49e9-801c-218a7bca7266)

```bash
 package com.example.assignment1_hansenbillyramades

class FinancialAnalysisActivity(private val financeManager: FinanceManager) {
    fun showFinancialAnalysis() {
        val totalIncome = financeManager.getTotalIncome()
        val totalExpense = financeManager.getTotalExpenses()
        val balance = financeManager.getBalance()

        println("Financial Analysis")
        println("Total Income: $totalIncome")
        println("Total Expenses: $totalExpense")
        println("Balance: $balance")
    }
}
```
Contoh method yang di akses 
```bash
    fun getBalance(): Double = income - expenses

    fun getTotalIncome(): Double = transactions
        .filter { it.type == TransactionType.INCOME }
        .sumOf { it.amount }

    fun getTotalExpenses(): Double = transactions
        .filter { it.type == TransactionType.EXPENSE }
        .sumOf { it.amount }
 ```

Dalam FinancialAnalysisActivity memiliki properti financeManager untuk mengakses method pada class Finance Manager,
Pada kelas ini ada 3 nilai yaitu totalIncome, Total Expenses dan balance.

- fun getBalance untuk mengembalikan saldo akhir.
- fun getTotalIncome akan mengembalikan tipe data double kemudian mengakses data class transaction untuk melakukan filter apabila tipe nya pada enum class TransactionType bertipe Income maka TotalIncome akan mentotalkan jumlah tipe tersebut sesuai dengan tipe yang filter
- fun getTotalExpenses sama seperti penjelasan pada getTotalIncome


