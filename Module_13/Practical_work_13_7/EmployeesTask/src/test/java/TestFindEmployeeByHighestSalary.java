import app.Employee;
import app.EmployeeUtils;
import app.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Поиск сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году ")
class TestFindEmployeeByHighestSalary {

    @Test
    @DisplayName("Входные данные - staff.txt - 2017")
    void getEmployee() {
        List<Employee> staff = EmployeeUtils.loadStaffFromFile("data/staff.txt");
        LocalDate date = LocalDate.of(2017, Month.JANUARY, 31);
        Employee expectedEmployee = new Employee("Дмитрий Кочергин", 140000, date);
        Employee actualEmployee = Main.findEmployeeWithHighestSalary(staff, 2017);
        assertEquals(expectedEmployee, actualEmployee);
    }

}
