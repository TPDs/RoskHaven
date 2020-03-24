package com.company;

import java.util.ArrayList;

public class Worksheet implements ClassesToStoreInFiles {
    //ID is composed of the year followed by the month. So January of 2019 will be "Y2019M1".
    String workSheetID;
    ArrayList<WorkDay> workDays;
    ArrayList<Employee> completeListOfEmployees;
    ArrayList<DailyManager> completeListOfDailyManagers;

    //Worksheets are a monthly schedule, that stores what employees will be scheduled to work at certain hours.

    //This creates a new worksheet.
    public Worksheet(int yearOfWorkSheet, int monthOfWorksheet){
        makeListOfDaysInMonth(monthOfWorksheet, yearOfWorkSheet);
        completeListOfEmployees = InitiateArray.getInstance().employeeList;
        completeListOfDailyManagers = InitiateArray.getInstance().dailyManagerList;

        //Remember to check if a worksheet within the month already exists and deny the user to create a new if that's the case.
        workSheetID = calcID(yearOfWorkSheet, monthOfWorksheet);
    }




    public String calcID(int year, int month){
        return "Y" + year + "M" + month;
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
    public void addDailyManagerToSchedule(String DMid, int dayOfMonth){
        for(int i=0; i<completeListOfDailyManagers.size(); i++){
            if(completeListOfDailyManagers.get(i).getId().equals(DMid)){
                //Days are one-off (the 1st in each month will be in the 0th position).
                workDays.get(dayOfMonth-1).setDailyManagerScheduled(completeListOfDailyManagers.get(i));
            }
        }
    }






    //Adds employee to a whole day of work. A work day is made of the hours from 7:00-17:00, which each gets an index in the arraylist (0 being 7:00-8:00, 1 is 8:00-9:00 and so on).
    public void addWorkerToSchedule(String empID, int dayOfMonth){
        for(int i=0; i<completeListOfEmployees.size(); i++){
            if(completeListOfEmployees.get(i).getId().equals(empID)){
                for(int j=0; j<10; j++){
                    workDays.get(dayOfMonth-1).getWorkHours().get(j).getEmployeeAtWork().add(completeListOfEmployees.get(i));
                }
                break;
            }
        }
    }

    //Adds an employee to a specific hour - the int given should be the start of the hour and the following 60 minutes.
    public void addWorkerToSchedule(String empID, int dayOfMonth, int hour){
        for(int i=0; i<completeListOfEmployees.size(); i++){
            if(completeListOfEmployees.get(i).getId().equals(empID)){
                workDays.get(dayOfMonth).getWorkHours().get(hour-7).getEmployeeAtWork().add(completeListOfEmployees.get(i));
            }
        }
    }

    //Adds employee to a range of hours in a specific workday.
    public void addWorkerToSchedule(String empID, int dayOfMonth, int startHour, int endHour){
        for(int i=0; i<completeListOfEmployees.size(); i++){
            if(completeListOfEmployees.get(i).getId().equals(empID)){
                for(int j=startHour; j<endHour; j++){
                    workDays.get(dayOfMonth).getWorkHours().get(j-7).getEmployeeAtWork().add(completeListOfEmployees.get(i));
                }
            }
        }
    }






    //Maybe just do it as a toString-override?
    public void viewWorksheet(){

    }




    public void clearWorksheet(){

    }





    @Override
    public void writeToFile() {

    }
}