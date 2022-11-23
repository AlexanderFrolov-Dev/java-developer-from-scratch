import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        // Простое лямбда-выражение.
        staff.sort((o1, o2) -> {
            if ((int) o1.getSalary() == o2.getSalary()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Integer.compare(o1.getSalary(), o2.getSalary());
            }
        });
        // Тот же результат, но с использованием ссылки на метод
        staff.sort(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName));
    }
}