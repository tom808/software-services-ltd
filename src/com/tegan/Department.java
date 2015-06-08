package com.tegan;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tom on 04/06/15.
 */
public class Department {

    private ArrayList<Employee> employees_list;
    private String deptName;

    public Department(String deptName, ArrayList<Employee> employees_list) {

        this.deptName = deptName;
        this.employees_list =  employees_list;

    }

    public Department(String deptName, Employee employee) {

        this.deptName = deptName;
        this.employees_list.add(employee);

    }

    public Department(String deptName) {

        this.employees_list = new ArrayList<Employee>();
        this.deptName = deptName;

    }

    public String toString() {

        Collections.sort(this.employees_list);
        String dept_string = deptName + " " + System.lineSeparator();

        for (Employee emp : this.employees_list) dept_string += emp.toString();

        return dept_string + System.lineSeparator();
    }

    public void addEmployee(Employee employee) {

        employees_list.add(employee);
        Collections.sort(employees_list);

    }

    public Employee getEmployee(int empID) {

        for (Employee emp : employees_list) {

            if (emp.empID == empID) {
                return emp;
            }
        }

        return null;

    }

    public ArrayList<Employee> getEmployeesList() {
        Collections.sort(this.employees_list);
        return this.employees_list;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
