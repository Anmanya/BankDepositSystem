public class BankAccount {
    protected String accountHolder;
    protected double balance;
    protected double totalIncome;
    protected double totalExpenses;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.totalIncome = 0;
        this.totalExpenses = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            totalIncome += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            totalExpenses += amount;
        }
    }

    public double getNetIncome() {
        return totalIncome - totalExpenses;
    }

    public double getSpendingRate() {
        if (totalIncome == 0) return 0;
        return (totalExpenses / totalIncome) * 100;
    }

    public double getBalance() {
        return balance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public String getAccountType() {
        return "Standard Account";
    }
}
