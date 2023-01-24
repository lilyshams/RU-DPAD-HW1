public class BasicAccount implements IAccount {
    int accountNumber;
    double withdrawLimit;
    double balance;

    // constructor
    public BasicAccount(int accountNumber, double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.withdrawLimit = withdrawLimit;
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (amount > this.withdrawLimit) {
            amount = this.withdrawLimit;
        }
        if (amount > this.balance) {
            amount = this.balance;
        }
        this.balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }
}
