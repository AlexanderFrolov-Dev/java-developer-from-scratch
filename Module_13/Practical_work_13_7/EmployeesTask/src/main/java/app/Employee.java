package app;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private String name;
    private Integer salary;
    private LocalDate workStart;

    public Employee(String name, Integer salary, LocalDate workStart) {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getWorkStart() {
        return workStart;
    }

    public void setWorkStart(LocalDate workStart) {
        this.workStart = workStart;
    }

    public String toString() {
        return name + " - " + salary + " - " + workStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(workStart, employee.workStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, workStart);
    }

}
