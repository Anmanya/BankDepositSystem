import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountSelectionGUI {
    private JFrame frame;
    private JTextField nameField;
    private JPasswordField passwordField;

    public AccountSelectionGUI() {
        frame = new JFrame("Login - Select Account Type");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Username:");
        nameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCredentials();
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel()); // Empty space
        frame.add(loginButton);

        frame.setVisible(true);
    }

    private void checkCredentials() {
        String username = nameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("genius") && password.equals("1234")) {
            frame.dispose(); // Close login window
            openAccountSelection();
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect Username or Password!");
        }
    }

    private void openAccountSelection() {
        JFrame accountFrame = new JFrame("Select Account Type");
        accountFrame.setSize(400, 200);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountFrame.setLayout(new GridLayout(3, 1));

        JButton savingsButton = new JButton("Savings Account");
        JButton checkingButton = new JButton("Checking Account");

        savingsButton.addActionListener(e -> openBankGUI("Savings"));
        checkingButton.addActionListener(e -> openBankGUI("Checking"));

        accountFrame.add(new JLabel("Select Account Type:", SwingConstants.CENTER));
        accountFrame.add(savingsButton);
        accountFrame.add(checkingButton);

        accountFrame.setVisible(true);
    }

    private void openBankGUI(String accountType) {
        BankAccount account;
        if (accountType.equals("Savings")) {
            account = new SavingsAccount("genius", 1000, 2.5);
        } else {
            account = new CheckingAccount("genius", 1000, 500);
        }

        new BankAppGUI(account);
    }

}
