package practice;

public class CardAccount extends BankAccount {
    public static final double RECESSUS_FEODO = 0.01;

    @Override
    public void take(double amountToTake) {
        if (amountToTake <= getAmount() + getAmount() * RECESSUS_FEODO) {
            super.take(amountToTake + amountToTake * RECESSUS_FEODO);
        }
    }
}
