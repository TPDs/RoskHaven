package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WorkHour {
    private ArrayList<Employee> employeeAtWork;
    int hour;

    public WorkHour(int hour){
        //Initially the arraylist is empty, but they will be added manually over time.
        employeeAtWork = new ArrayList<Employee>();
        this.hour = hour;
    }

    public ArrayList<Employee> getEmployeeAtWork() {
        return employeeAtWork;
    }

}
