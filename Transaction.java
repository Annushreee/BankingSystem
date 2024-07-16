package src.banking;
import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private double postBalance;
    private Date date;

    public Transaction(String type, double amount, double postBalance) {
        this.type = type;
        this.amount = amount;
        this.postBalance = postBalance;
        this.date = new Date();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getPostBalance() {
        return postBalance;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", postBalance=" + postBalance +
                ", date=" + date +
                '}';
    }
}

