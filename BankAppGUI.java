import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAppGUI {
    private BankAccount account;
    private JFrame frame;
    private JTextField amountField;
    private JLabel balanceLabel, incomeLabel, expenseLabel, netIncomeLabel, spendingRateLabel, accountTypeLabel;

    public BankAppGUI(BankAccount account) {
        this.account = account;

        frame = new JFrame("Bank System - " + account.getAccountType());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 2));

        balanceLabel = new JLabel("Balance: $" + account.getBalance());
        incomeLabel = new JLabel("Total Income: $" + account.getTotalIncome());
        expenseLabel = new JLabel("Total Expenses: $" + account.getTotalExpenses());
        netIncomeLabel = new JLabel("Net Income: $" + account.getNetIncome());
        spendingRateLabel = new JLabel("Spending Rate: " + account.getSpendingRate() + "%");
        accountTypeLabel = new JLabel("Account Type: " + account.getAccountType());

        amountField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                updateLabels();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                updateLabels();
            }
        });

        frame.add(new JLabel("Amount:"));
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(balanceLabel);
        frame.add(incomeLabel);
        frame.add(expenseLabel);
        frame.add(netIncomeLabel);
        frame.add(spendingRateLabel);
        frame.add(accountTypeLabel);

        frame.setVisible(true);
    }

    private void updateLabels() {
        balanceLabel.setText("Balance: $" + account.getBalance());
        incomeLabel.setText("Total Income: $" + account.getTotalIncome());
        expenseLabel.setText("Total Expenses: $" + account.getTotalExpenses());
        netIncomeLabel.setText("Net Income: $" + account.getNetIncome());
        spendingRateLabel.setText("Spending Rate: " + account.getSpendingRate() + "%");
        accountTypeLabel.setText("Account Type: " + account.getAccountType());
    }
}
