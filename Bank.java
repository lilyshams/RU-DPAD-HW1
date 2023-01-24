import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    List<IAccount> accounts;
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetAccountNumber() == accountNumber) {
                if (this.accounts.get(i).GetCurrentBalance() < 0) {
                    System.out.println("Account is not closed due to debt");
                } else {
                    this.accounts.remove(i);
                }
                return;
            }
        }
    }

    public List<IAccount> GetAllAccounts() {
        return this.accounts;
    }

    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetCurrentBalance() < 0) {
                accountsInDebt.add(this.accounts.get(i));
            }
        }
        return accountsInDebt;
    }

    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(this.accounts.get(i));
            }
        }
        return accountsWithBalance;
    }
}
