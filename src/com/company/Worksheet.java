package com.company;

import java.util.ArrayList;

public class Worksheet implements ClassesToStoreInFiles {
    ArrayList<WorkDay> workDays;
    ArrayList<Employee> completeListOfEmployees;
    ArrayList<DailyManager> completeListOfDailyManagers;

    //Worksheets are a monthly schedule, that stores what employees will be scheduled to work at certain hours.

    //This creates a new worksheet.
    public Worksheet(InitiateArray ia){
        workDays = new ArrayList<WorkDay>();
        completeListOfEmployees = ia.employeeList;
        completeListOfDailyManagers = ia.dailyManagerList;
    }


    @Override
    public void writeToFile() {

    }
}
/*
* Timesheet:Arraylist<Arraylist<ArrayList<Employee>>> */



//ViewWorksheet()