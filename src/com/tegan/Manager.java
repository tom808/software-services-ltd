package com.tegan;

/**
 * Created by tom on 05/06/15.
 */
public class Manager extends Employee {

    public Manager(String first_name, String last_name) {
    super(first_name, last_name);
  }

    public int compareTo(Employee emp) {
      return super.compareTo(emp);
    }

    public Manager(String first_name, String last_name, double salary) {

        super(first_name, last_name, salary);

    }

    public String toString() {
        return empID + " " + first_name + " " + last_name + " " + salary + " " + "**Manager**" + System.lineSeparator();
    }
}
