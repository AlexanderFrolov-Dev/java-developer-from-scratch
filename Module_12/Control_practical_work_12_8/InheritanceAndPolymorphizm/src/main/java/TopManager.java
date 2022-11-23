public class TopManager implements Employee {
    public static final int SALARY = 50_000;
    public static final double BONUS = 1.5;
    public static final int MIN_INCOME_OF_COMPANY_FOR_AWARD = 10_000_000;
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return company.getIncome() > MIN_INCOME_OF_COMPANY_FOR_AWARD ? (int) (SALARY * BONUS) : SALARY;
    }
}
