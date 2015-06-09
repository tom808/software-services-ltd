package com.tegan;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import com.oracle.tools.packager.IOUtils;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import sun.nio.ch.IOUtil;

public class Main {

    public static void main(String[] args) {

        Organisation organisation = new Organisation("Software Services Ltd.");
        organisation.addDept(new Department("Human Resources", populateDepartment("HR", "MOCK_DATA.json")));
        organisation.addDept(new Department("Software Development", populateDepartment("Dev", "MOCK_DATA2.json")));

        Manager man1 = new Manager("Bob", "Harris", 100000.00);
        Manager man2 = new Manager("Leon", "Hughes", 100000.00);

        organisation.getDepartment(0).addEmployee(man1);
        organisation.getDepartment(1).addEmployee(man2);

        for (Employee emp : organisation.getDepartment(0).getEmployeesList()) {
            emp.setManager(man1);
        }

        for (Employee emp : organisation.getDepartment(1).getEmployeesList()) {
            emp.setManager(man2);
        }

        TestHarness test =  new TestHarness(organisation);
        test.go();
    }

    public static ArrayList<Employee> populateDepartment(String empType, String fileName){

        ArrayList<Employee> empList = new ArrayList<Employee>();

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                Main.class.getClassLoader().getResourceAsStream(fileName))
            );

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONArray jsonArray = (JSONArray)new JSONParser().parse(stringBuilder.toString());

            for (int i = 0; i < jsonArray.size(); i++) {

                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                empList.add(EmployeeFactory.getEmployee(
                    empType,
                    (String) jsonObject.get("first_name"),
                    (String) jsonObject.get("last_name"),
                    Double.parseDouble((String) jsonObject.get("salary"))
                ));
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Mock file " + fileName + " not found . . . ooops!");

        }

        return empList;

    }

}
