package com.bridgelabz;

public class EmployeePayrollData {

    // Variables
    int id;
    String name;
    double salary;

    /*
     * Create a parameterized constructor name as EmployeePayrollData
     */
    public EmployeePayrollData(int id, String name, double salary) {
        /*
         * The "this" keyword is used to refer to the current object.
         */
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /*
     * Overriding the toString() method
     * Return employee id ,salary and name.
     */
    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
