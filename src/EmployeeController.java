package com.example.homeworkstreams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController ( EmployeeService  employeeService ) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Object addEmployee(
            @RequestParam(value = "fullName") String fullName,
            @RequestParam(value = "depId") int depId,
            @RequestParam(value = "salary") int salary) {
        Employee employee = null;
        try {
            employee = employeeService.addEmployee(fullName, depId, salary);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/remove")
    public Object removeEmployee(
            @RequestParam(value = "fullName") String fullName) {
        Employee employee = null;
        try {
            employee = employeeService.removeEmployee(fullName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/find")
    public Object findEmployee(
            @RequestParam(value = "fullName") String fullName) {
        Employee employee = null;
        try {
            employee = employeeService.findEmployee(fullName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/departament/max-salary")
    public Object getMaxSalaryEmployee(
            @RequestParam(value = "departamentId") int depId) {
        Employee employee = null;
        try {
            employee = employeeService.getMaxSalaryEmployee(depId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/departament/min-salary")
    public Object getMinSalaryEmployee(
            @RequestParam(value = "departamentId") int depId) {
        Employee employee = null;
        try {
            employee = employeeService.getMinSalaryEmployee(depId);

        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
    @GetMapping(path = "/departament/all-dep")
    public Object printEmployeesForDepartment(
            @RequestParam(value = "departamentId") int depId) {
        List<Employee> employees = null;
        try {
            employees = employeeService.printEmployeesForDepartment(depId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/departament/all")
    public Object printEmployeesByDepartments() {
        List<Employee> employees = null;
        try {
            employees = employeeService.printEmployeesByDepartments();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/print")
    public Object printEmployees() {
        List<Employee> employees = null;
        try {
            employees = employeeService.printEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }
}