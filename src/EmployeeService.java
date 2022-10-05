package com.example.homeworkstreams;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String fullName, int depId, int salary);
    Employee removeEmployee (String fullName);
    Employee findEmployee (String fullName);
    Employee getMaxSalaryEmployee(int depId);
    Employee getMinSalaryEmployee(int depId);
    List<Employee> printEmployeesByDepartments();

    List<Employee> printEmployeesForDepartment(int depId);

    List<Employee> printEmployees();

}