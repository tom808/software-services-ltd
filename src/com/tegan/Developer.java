package com.tegan;

/**
 * Created by tom on 05/06/15.
 */
public class Developer extends Employee {

    protected String main_skill;

    public Developer(String first_name, String last_name, Double salary) {

        super(first_name, last_name);
        this.salary = salary;

    }

    public Developer(String first_name, String last_name, double salary, String main_skill) {
        super(first_name, last_name, salary);
        this.main_skill = main_skill;
    }

    public String getMain_skill() {
        return main_skill;
    }

    public String toString() {

        return super.empID + " " + super.first_name + " " + super.last_name + " " + super.salary + " "
               + "(skill: " + this.main_skill + ")"+ System.lineSeparator();

    }

    public void setMain_skill(String main_skill) {

        this.main_skill = main_skill;

  }
}
