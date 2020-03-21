package com.company;

import java.util.ArrayList;

public class WorkHour {
    private ArrayList<Employee> employeeAtWork;

    public WorkHour(){
        //Initially the arraylist is empty, but they will be added manually over time.
        employeeAtWork = new ArrayList<Employee>();
    }
}
