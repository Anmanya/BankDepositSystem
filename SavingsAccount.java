public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance * 0.8) {
            System.out.println("Withdrawal exceeds 80% of balance! Limited access.");
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}
