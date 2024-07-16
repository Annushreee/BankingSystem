package src.banking;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankingSystem {
    private Map<String, User> users;
    private Map<String, Account> accounts;

    public BankingSystem() {
        this.users = new HashMap<>();
        this.accounts = new HashMap<>();
    }

    public User createUser(String name, String email, String phoneNumber, String address) {
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, name, email, phoneNumber, address);
        users.put(userId, user);
        return user;
    }

    public Account createAccount(User user) {
        String accountId = UUID.randomUUID().toString();
        Account account = new Account(accountId, user);
        accounts.put(accountId, account);
        return account;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();

        // Create a user and an account
        User user1 = system.createUser("John Doe", "john.doe@example.com", "123-456-7890", "123 Main St");
        Account account1 = system.createAccount(user1);

        // Deposit and withdraw funds
        account1.deposit(500);
        account1.withdraw(100);

        // Create another user and account
        User user2 = system.createUser("Jane Smith", "jane.smith@example.com", "098-765-4321", "456 Elm St");
        Account account2 = system.createAccount(user2);

        // Transfer funds between accounts
        account1.transfer(account2, 200);

        // View transaction history
        System.out.println("Transaction history for account 1:");
        for (Transaction transaction : account1.getTransactionHistory()) {
            System.out.println(transaction);
        }

        System.out.println("Transaction history for account 2:");
        for (Transaction transaction : account2.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}
