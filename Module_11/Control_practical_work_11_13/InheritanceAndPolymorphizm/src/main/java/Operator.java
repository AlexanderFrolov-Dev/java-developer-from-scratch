public class Operator implements Employee{
    public static final int SALARY = 30_000;

    @Override
    public int getMonthSalary() {
        return SALARY;
    }
}
