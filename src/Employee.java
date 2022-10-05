package com.example.homeworkstreams;

import java.util.Objects;

public class Employee {
    private  String fullName;
    private int depId;
    private  int salary;

    public Employee(String fullName,int depId,int salary){
        this.fullName=fullName;
        this.depId=depId;
        this.salary=salary;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepId() {
        return depId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString () {
        return "Ф.И.О. "+fullName+", отдел - "+depId+", зарплата - "+salary;
    }
}