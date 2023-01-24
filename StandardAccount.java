public class StandardAccount implements IAccount{
    // State:
    int accountNumber;
    double creditLimit;
    double balance;

    // Constructor
    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit < 0 ? creditLimit : 0; // ternary operator
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double currentAmount = this.balance - this.creditLimit;
        if (amount > currentAmount) {
            amount = currentAmount;
        }
        this.balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber()
    {
        return this.accountNumber;
    }
}


