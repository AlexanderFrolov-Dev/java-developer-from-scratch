package practice;

import java.time.LocalDate;
import java.time.Period;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }

    @Override
    public void take(double amountToTake) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(lastIncome, currentDate);
        if (period.getMonths() >= 1 || period.getYears() >= 1) {
            super.take(amountToTake);
        }
    }
}
