package practice;

public class LegalPerson extends Client {
    public static final double WITHDRAWAL_FEE = 0.01;

    @Override
    public void take(double amountToTake) {
        if (amountToTake + amountToTake * WITHDRAWAL_FEE <= amount) {
            super.take(amountToTake + amountToTake * WITHDRAWAL_FEE);
        }
    }
}
