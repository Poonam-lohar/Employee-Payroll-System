package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {

    public static String PAYROLL_FILE_NAME = ("C:\\Users\\Suraj\\IdeaProjects\\add\\Practice\\src\\EmployeePayrollService\\src\\main\\java\\com\\bridgelabz\\payroll-file.text");

    public void writeData(List<EmployeePayrollData> employeeList) {

        StringBuffer empBuffer = new StringBuffer();
        employeeList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });

        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
