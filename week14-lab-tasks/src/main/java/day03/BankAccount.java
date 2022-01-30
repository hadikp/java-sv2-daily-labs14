package day03;

public class BankAccount {

    private String accountNumber;
    private String nameOfOwner;
    private int balance;

    public BankAccount(String accountNumber, String nameOfOwner, int balance) {
        this.accountNumber = accountNumber;
        this.nameOfOwner = nameOfOwner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return accountNumber + ": " + nameOfOwner + ": " + balance;
    }
}
