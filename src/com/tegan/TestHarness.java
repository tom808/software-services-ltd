package com.tegan;

import java.util.Scanner;

/**
 * Created by tom on 07/06/15.
 */
public class TestHarness {

    Organisation organisation;
    Scanner sc;

    public TestHarness(Organisation organisation) {

        this.organisation = organisation;
        sc = new Scanner(System.in);


    }

    private void employeeSalaryAdjust() {

        int choice;
        double newSal = 0.0;
        int percentage = 0;
        Employee employee;

        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        }
        else {
            System.out.println("Invalid employee id");
            return;
        }

        employee = organisation.getEmployee(choice);

            if (employee != null) {

                System.out.println("Selected Employee:");
                System.out.println(employee.toString() + System.lineSeparator());

                System.out.println("Increase salary by:");
                System.out.println("1: Amount");
                System.out.println("2: Percentage");

                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                } else {
                    sc.next();
                }

                if (choice == 1) {

                    System.out.println("Enter amount to add to salary");
                    if (sc.hasNextDouble()) {

                        newSal = sc.nextDouble();
                        employee.setSalary((double) Math.round(employee.getSalary() + newSal));
                        System.out.println("Operation Complete!");
                        employee.toString();

                    } else {
                        sc.next();
                    }


                }
                else if (choice == 2){

                    System.out.println("Enter percentage to increase salary");

                    if (sc.hasNextInt()) {
                        percentage = sc.nextInt();

                        double sal = (double)Math.round(employee.getSalary() + ((employee.getSalary()/100) * percentage));
                        employee.setSalary(sal);

                        System.out.println("Operation Complete!");
                        employee.toString();

                    } else {
                        sc.next();
                    }


                } else {

                    System.out.println("Option not recognised");

                }
            } else {

                System.out.println("Employee ID not recognised");

            }

    }

    private void employeeManagerChange() {

        int choice;
        Employee employee;
        Employee manager;

        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        }
        else {
            System.out.println("Invalid employee id");
            return;
        }

        employee = organisation.getEmployee(choice);

        System.out.println("Selected Employee:");
        System.out.println(employee.toString() + System.lineSeparator());
        System.out.println("Select manager");

        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        }
        else {
            System.out.println("Invalid employee id");
            return;
        }

         manager = organisation.getEmployee(choice);

        if (manager instanceof Manager) {
            employee.setManager((Manager)manager);
        } else {
            System.out.println("Person is not a manger!");
        }

    }


    public void go() {

        int choice = 0;

        do  {

                System.out.println("Please select option");
                System.out.println("1: List all employees by department");
                System.out.println("2: List all employees");
                System.out.println("3: Increase employee salary");
                System.out.println("4: Amend employee manager");
                System.out.println("5: Exit");

                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                }
                else {
                    sc.next();
                }
                switch (choice) {

                    case 1:
                        System.out.println(organisation.toString());
                        break;
                    case 2:
                        System.out.println(organisation.getAllEmployees());
                        break;
                    case 3:
                        System.out.println("Enter employee id to amend salary");
                        employeeSalaryAdjust();
                        break;
                    case 4:
                        System.out.println("Enter employee id to amend salary");
                        employeeManagerChange();
                    case 5:
                        System.out.println("Bye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice, please choose again");

                }

        } while (choice != 5);
    }
}
