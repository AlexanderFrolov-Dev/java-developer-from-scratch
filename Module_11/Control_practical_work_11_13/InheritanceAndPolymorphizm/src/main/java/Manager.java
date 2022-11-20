public class Manager implements Employee {
    public static final int SALARY = 30_000;
    public static final double BONUS = 0.05;
    public static final int MIN_SALES_SIZE = 115_000;
    public static final int MAX_SALES_SIZE = 140_000;
    private Company company;
    private final int sales = (int) (Math.random() * ((MAX_SALES_SIZE - MIN_SALES_SIZE) + 1) + MIN_SALES_SIZE);

    public Manager(Company company) {
        this.company = company;
    }

    public int getSales() {
        return sales;
    }

    //    public int getSalesSize() {
//        return(int) (Math.random() * ((MAX_SALES_SIZE - MIN_SALES_SIZE) + 1) + MIN_SALES_SIZE);
//    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return (int) (getSales() * BONUS + SALARY);
    }
}
