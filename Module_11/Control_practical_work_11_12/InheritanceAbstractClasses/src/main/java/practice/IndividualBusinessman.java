package practice;

public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut - amountToPut * getCommission(amountToPut));
    }

    private double getCommission(double amountToPut) {
        return amountToPut < 1000 ? 0.01 : 0.005;
    }
}
