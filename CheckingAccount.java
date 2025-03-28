public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountHolder, double initialBalance, double overdraftLimit) {
        super(accountHolder, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            totalExpenses += amount;
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public String getAccountType() {
        return "Checking Account";
    }
}
