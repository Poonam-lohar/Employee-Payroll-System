package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.bridgelabz.EmployeePayrollFileIOService.PAYROLL_FILE_NAME;

public class EmployeePayrollService {
    //create an enum
    public enum IOService {
        CONSOLE_IO, FILE_IO
    }

    ;

    private List<EmployeePayrollData> employeePayrollList;//declare variable

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {//Parameterized constructor
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        //create Arraylist which is of employee payroll data type
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        //create object of employee payroll service class using new keyword
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);//constructor
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);//calling read method using obj reference
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);//calling write method using obj reference
    }

    // Create the Read Employee Payroll Data Method
    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));//add data into employeePayrollList
    }

    //Write employee payroll data method with parameter
    public void writeEmployeePayrollData(IOService writeTo) {
        if (writeTo.equals(IOService.CONSOLE_IO))
            System.out.println("\nWriting Employee Payroll Data to Console\n" + employeePayrollList);//print employeePayrollList
        else if (writeTo.equals(IOService.FILE_IO)) {
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public void printData(IOService employeePayrollList) {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}