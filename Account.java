package src.banking;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private User user;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountId, User user) {
        this.accountId = accountId;
        this.user = user;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount, balance));
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount, balance));
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount.");
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (toAccount != null && amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactions.add(new Transaction("Transfer to " + toAccount.getAccountId(), amount, balance));
            toAccount.addTransaction(new Transaction("Transfer from " + this.accountId, amount, toAccount.getBalance()));
            System.out.println("Transferred: " + amount + " to " + toAccount.getAccountId());
        } else {
            System.out.println("Invalid transfer amount or account.");
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

}
