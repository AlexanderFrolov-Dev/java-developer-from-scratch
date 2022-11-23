public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(company));
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager(company));
        }

        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager(company));
        }

        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println();

        for (Employee employee : company.getLowerSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }

        for (int i = 0; i < company.getEmployeeList().size() / 2; i++) {
            company.fire(company.getEmployeeList().get(i));
        }

        System.out.println("============================================================");

        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println();

        for (Employee employee : company.getLowerSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }
    }
}
