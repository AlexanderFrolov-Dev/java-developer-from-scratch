import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private final List<Employee> employeeList = new ArrayList<>();
    private final SalaryComparator salaryComparator = new SalaryComparator();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        employeeList.addAll(employees);
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
    }

    public int getIncome() {
        int income = 0;  // Без этой строки income увеличивается неконтролируемо при каждом вызове метода.
        for (Employee employee : employeeList) {
            if (employee.getClass().equals(Manager.class)) {
                income += ((Manager) employee).getSales();
            }
        }
        return income;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> topSalaryStaffList = new ArrayList<>();
        employeeList.sort(salaryComparator);
        if (isValidCountEmployees(count)) {
            for (int i = 0; i < count; i++) {
                topSalaryStaffList.add(employeeList.get(i));
            }
        }
        return topSalaryStaffList;
    }

    public ArrayList<Employee> getLowerSalaryStaff(int count) {
        ArrayList<Employee> lowerSalaryStaffList = new ArrayList<>();
        employeeList.sort(salaryComparator);
        Collections.reverse(employeeList);
        if (isValidCountEmployees(count)) {
            for (int i = 0; i < count; i++) {
                lowerSalaryStaffList.add(employeeList.get(i));
            }
        }
        return lowerSalaryStaffList;
    }

    private boolean isValidCountEmployees(int count) {
        return count > 0 && count <= employeeList.size();
    }
}
