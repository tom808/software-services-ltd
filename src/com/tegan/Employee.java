package com.tegan;

/**
 * Created by tom on 04/06/15.
 */
public class Employee implements Comparable<Employee> {

    protected int empID;
    protected String first_name;
    protected String last_name;
    protected double salary;
    protected Manager manager;

    public Employee(String first_name, String last_name){


        this.first_name = first_name;
        this.last_name = last_name;
        this.empID = Organisation.employeeCount;
        Organisation.employeeCount ++;

    }

    public Employee(String first_name, String last_name, double salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.empID = Organisation.employeeCount;
        Organisation.employeeCount ++;
    }

    public void increaseSalary(double amount) {

        this.salary += amount;

    }

    public void increaseSalaryPercent(int percentage) {

        this.salary *= 1 + (percentage/100);

    }

    public String toString() {

        return empID + " " + first_name + " " + last_name + " " + salary + System.lineSeparator();

    }

    public int compareTo(Employee emp) {

        return this.last_name.compareTo(emp.last_name);

    }

    public void setManager(Manager manager) {

        this.manager = manager;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

}
