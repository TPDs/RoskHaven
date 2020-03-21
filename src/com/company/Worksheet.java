package com.company;

import java.util.ArrayList;

public class Worksheet implements ClassesToStoreInFiles {
    String workSheetID;
    ArrayList<WorkDay> workDays;
    ArrayList<Employee> completeListOfEmployees;
    ArrayList<DailyManager> completeListOfDailyManagers;

    //Worksheets are a monthly schedule, that stores what employees will be scheduled to work at certain hours.

    //This creates a new worksheet.
    public Worksheet(InitiateArray ia, int yearOfWorkSheet, int monthOfWorksheet){
        makeListOfDaysInMonth(monthOfWorksheet, yearOfWorkSheet);
        completeListOfEmployees = ia.employeeList;
        completeListOfDailyManagers = ia.dailyManagerList;
    }




    public void makeListOfDaysInMonth(int monthOfChoice, int yearOfChoice){
        workDays = new ArrayList<WorkDay>();
        if(monthOfChoice == 1 || monthOfChoice == 3 || monthOfChoice == 5 || monthOfChoice == 7 || monthOfChoice == 8 || monthOfChoice == 10 || monthOfChoice == 12){
            for(int i=0; i<31; i++){
                WorkDay workday = new WorkDay();
                workDays.add(workday);
            }
        } else if(monthOfChoice == 2 && yearOfChoice%4 != 0){
            for(int i=0; i<28; i++){
                WorkDay workday = new WorkDay();
                workDays.add(workday);
            }
        } else if (monthOfChoice == 2){
            for(int i=0; i<29; i++){
                WorkDay workday = new WorkDay();
                workDays.add(workday);
            }
        } else {
            for(int i=0; i<30; i++){
                WorkDay workday = new WorkDay();
                workDays.add(workday);
            }
        }
    }






    //Assign the dailymanager to a specific day (they will be in charge of the whole day). Each day will be a day in the month (1 => 1st of x)
    public void addDailyManagerToSchedule(DailyManager dailyManager, int dayOfMonth){

    }






    //Adds employee to a whole day of work.
    public void addWorkerToSchedule(Employee employee, int dayOfMonth){

    }

    //Adds an employee to a specific hour - the int given should be the start of the hour and the following 60 minutes.
    public void addWorkerToSchedule(Employee employee, int dayOfMonth, int hour){

    }

    //Adds employee to a range of hours in a specific workday.
    public void addWorkerToSchedule(Employee employee, int dayOfMonth, int startHour, int endHour){

    }






    //Maybe just do it as a toString-override?
    public void viewWorksheet(){

    }





    @Override
    public void writeToFile() {

    }
}