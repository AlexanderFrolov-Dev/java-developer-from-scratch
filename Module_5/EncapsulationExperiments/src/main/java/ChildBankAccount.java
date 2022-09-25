public class ChildBankAccount {
    private  double balance = 0;
    private  double maxBalance;

    public ChildBankAccount(double maxBalance) {
        this.maxBalance = maxBalance;
    }

    public boolean depositMoney(double value) {
        if (value >= 0 && balance + value <= maxBalance) {
            balance += value;
            return true;
        } else {
            return false;
        }
    }

    public boolean debitMoney(double value) {
        if (value >= 0 && balance - value >= 0) {
            balance -= value;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}
