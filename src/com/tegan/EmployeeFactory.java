package com.tegan;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by tom on 08/06/15.
 */
public class EmployeeFactory {

    public static Employee getEmployee(String type, String first_name, String last_name, double salary) {

        if (type.equals("Dev")) {

            Random rn = new Random();

            List<String> skills =  new LinkedList<String>();
            skills.add("C#");
            skills.add("Java");
            skills.add("JavaScript");

            return new Developer(first_name,last_name,salary,skills.get(rn.nextInt(3)));
        }
        else if (type.equals("HR")) {

            return new HRStaff(first_name, last_name, salary);

        }

        return null;


    }

}
