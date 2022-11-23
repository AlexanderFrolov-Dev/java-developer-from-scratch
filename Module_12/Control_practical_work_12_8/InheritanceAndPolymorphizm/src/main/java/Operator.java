public class Operator implements Employee {
    public static final int SALARY = 30_000;
    Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return SALARY;
    }
}
