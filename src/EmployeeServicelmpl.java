package com.example.homeworkstreams;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    private final String ERR_EMPLOYEE_NOT_FOUND = "Сотрудник не найден";

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public Employee addEmployee(String fullName, int depId, int salary) {
        Employee employee = new Employee(fullName, depId, salary);
        if (employees.contains(employee)) {
            String ERR_EMPLOYEE_ALREADY_ADDED = "Сотрудник уже имеется в листе";
            throw new RuntimeException(ERR_EMPLOYEE_ALREADY_ADDED);
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fullName) {
        Employee employee = findEmployee(fullName);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String fullName) {
        final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFullName().equals(fullName))
                .findAny();
        return employee.orElseThrow(() -> new RuntimeException(ERR_EMPLOYEE_NOT_FOUND));
    }

    @Override
    public Employee getMaxSalaryEmployee(int depId) {
        return employees.stream()
                .filter(e -> e.getDepId() == depId)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException(ERR_EMPLOYEE_NOT_FOUND));
    }

    @Override
    public Employee getMinSalaryEmployee(int depId) {
        return employees.stream()
                .filter(e -> e.getDepId() == depId)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException(ERR_EMPLOYEE_NOT_FOUND));
    }
    @Override
    public List<Employee> printEmployeesByDepartments() {
        return Collections.unmodifiableList(employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getDepId()))
                .collect(Collectors.toList()));
    }
    @Override
    public List<Employee> printEmployeesForDepartment(int depId) {
        return employees.stream()
                .filter(e -> e.getDepId() == depId)
                .collect(Collectors.toList());
    }
    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }
    List <Employee> employeeList=new ArrayList<>(List.of(new Employee("Литвин Алексей Сергеевич",1,65300),
            new Employee("Жуков Андрей Витальевич", 1,67500),
            new Employee("Фанина Елена Потаповна",1,66750),
            new Employee("Зорина Римма Васильевна",2,75200),
            new Employee("Юрьевна Елизавета Родионовна",3,76450),
            new Employee("Гарин Елизар Сократович",3,78200),
            new Employee("Балтабева Яна Анатольевна",4, 86380),
            new Employee("Арсеньев Вадим Агапович",4, 88600),
            new Employee("Рудаков Антон Владимирович", 5,95800)));

}