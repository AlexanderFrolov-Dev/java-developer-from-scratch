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

//        Company company = new Company();
//        Manager manager1 = new Manager(company);
//        Manager manager2 = new Manager(company);
//        Manager manager3 = new Manager(company);
//        Manager manager4 = new Manager(company);
//        Manager manager5 = new Manager(company);
//        Manager manager6 = new Manager(company);
//        Manager manager7 = new Manager(company);
//
//        company.hire(new Operator(company));
//        company.hire(manager1);
//        company.hire(manager2);
//        company.hire(new Operator(company));
//        company.hire(manager3);
//        company.hire(manager4);
//
//        System.out.println(company.getEmployeeList().size());
//        System.out.println(company.getIncome());
//        System.out.println("manager1: " + manager1.getSales());
//        System.out.println(manager1.getMonthSalary());
//        System.out.println("manager2: " + manager2.getSales());
//        System.out.println(manager2.getMonthSalary());
//        System.out.println("manager3: " + manager3.getSales());
//        System.out.println(manager3.getMonthSalary());
//        System.out.println("manager4: " + manager4.getSales());
//        System.out.println(manager4.getMonthSalary());
//        System.out.println("manager5: " + manager5.getSales());
//        System.out.println(manager5.getMonthSalary());
//        System.out.println("manager6: " + manager6.getSales());
//        System.out.println(manager6.getMonthSalary());
//        System.out.println("manager7: " + manager7.getSales());
//        System.out.println(manager7.getMonthSalary());


//        int count115_000 = 0;
//        int count140_000 = 0;
//
//        for (int i = 0; i < 1_000_000; i++) {
//            int currentNumber = manager.getSales();
////            System.out.println(currentNumber);
//            if (currentNumber == 114_000) {
//                count115_000++;
//            }
//            if (currentNumber == 140_000) {
//                count140_000++;
//            }
//        }
//
//        System.out.println(count115_000);
//        System.out.println(count140_000);
    }
}
