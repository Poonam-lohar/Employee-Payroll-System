package com.bridgelabz;

import org.testng.annotations.Test;

import java.util.Arrays;

import static com.bridgelabz.EmployeePayrollService.IOService.FILE_IO;
//import static com.bridgelabz.EmployeePayrollService.IoService.FILE_IO;

public class EmployeePayrollServiceTest {

    private int countEntries;

    @Test
    public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries(EmployeePayrollData employeePayrollList) {
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
                new EmployeePayrollData(2, "Bill Gates", 200000.0),
                new EmployeePayrollData(3, "Mark Zuckerberg", 300000.0)
        };

        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(employeePayrollList));
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
    }
}

