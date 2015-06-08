package com.tegan;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tom on 07/06/15.
 */
public class Organisation {

    ArrayList<Department> departmentList;
    String orgName;

    static int employeeCount;

    public Organisation(String orgName) {

        this.orgName = orgName;

    }

    public Department getDepartment(int deptNo) {
        return departmentList.get(deptNo);
    }

    public void addDept(Department dept) {

        if (departmentList == null) {
            this.departmentList = new ArrayList<Department>();
        }

        departmentList.add(dept);

    }

    public Employee getEmployee(int empId) {

        for (Employee emp: getAllEmployees()) {

            if (emp.getEmpID() == empId) return emp;

        }

        return null;
    }

    public ArrayList<Employee> getAllEmployees() {

        ArrayList<Employee> allEmployees = new ArrayList<Employee>();

        for (Department dept : this.departmentList) {
            allEmployees.addAll(dept.getEmployeesList());
        }

        Collections.sort(allEmployees);
        return allEmployees;
    }

    public String toString(){

        String org_string = orgName + System.lineSeparator();

        for (Department dept : departmentList) org_string += dept.toString();

        return org_string;
    }
}
