package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Worksheet implements ClassesToStoreInFiles {
    //ID is composed of the year followed by the month. So January of 2019 will be "Y2019M1".
    String workSheetID;
    private int year;
    private int month;
    private ArrayList<WorkDay> workDays;
    private ArrayList<Employee> completeListOfEmployees;
    private ArrayList<DailyManager> completeListOfDailyManagers;

    //Worksheets are a monthly schedule, that stores what employees will be scheduled to work at certain hours.

    //This creates a new worksheet.
    public Worksheet(int yearOfWorkSheet, int monthOfWorksheet){
        //Remember to check if a worksheet within the month already exists and deny the user to create a new if that's the case.
        this.year = yearOfWorkSheet;
        this.month = monthOfWorksheet;
        workSheetID = calcID(yearOfWorkSheet, monthOfWorksheet);
        makeListOfDaysInMonth(monthOfWorksheet, yearOfWorkSheet);
        writeToFile();
        completeListOfEmployees = Kindergarten.getInstance().getEmployeesInGarten();
        completeListOfDailyManagers = Kindergarten.getInstance().getDailyManagersInGarten();
    }

    //This constructor is to be used when reading from files.
    public Worksheet(int year, int month, String workSheetID){
        this.year = year;
        this.month = month;
        this.workSheetID = workSheetID;
        makeListOfDaysInMonth(month, year);
        completeListOfEmployees = Kindergarten.getInstance().getEmployeesInGarten();
        completeListOfDailyManagers = Kindergarten.getInstance().getDailyManagersInGarten();
    }

    public String getWorkSheetID() {
        return workSheetID;
    }

    public ArrayList<WorkDay> getWorkDays() {
        return workDays;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String calcID(int year, int month){
        return "Y" + year + "M" + month;
    }




    public void makeListOfDaysInMonth(int monthOfChoice, int yearOfChoice){
        workDays = new ArrayList<WorkDay>();
        if(monthOfChoice == 1 || monthOfChoice == 3 || monthOfChoice == 5 || monthOfChoice == 7 || monthOfChoice == 8 || monthOfChoice == 10 || monthOfChoice == 12){
            for(int i=0; i<31; i++){
                WorkDay workday = new WorkDay(workSheetID, i+1);
                workDays.add(workday);
            }
        } else if(monthOfChoice == 2 && yearOfChoice%4 != 0){
            for(int i=0; i<28; i++){
                WorkDay workday = new WorkDay(workSheetID, i+1);
                workDays.add(workday);
            }
        } else if (monthOfChoice == 2){
            for(int i=0; i<29; i++){
                WorkDay workday = new WorkDay(workSheetID, i+1);
                workDays.add(workday);
            }
        } else {
            for(int i=0; i<30; i++){
                WorkDay workday = new WorkDay(workSheetID, i+1);
                workDays.add(workday);
            }
        }
    }




    //Assign the dailymanager to a specific day (they will be in charge of the whole day). Each day will be a day in the month (1 => 1st of x)
    public void addDailyManagerToSchedule(String DMid, int dayOfMonth){
        for(int i=0; i<completeListOfDailyManagers.size(); i++){
            if(completeListOfDailyManagers.get(i).getCPR().equals(DMid)){
                //Days are one-off (the 1st in each month will be in the 0th position).
                workDays.get(dayOfMonth-1).getDailyOverview().setDailyManagerScheduled(completeListOfDailyManagers.get(i));
                workSheetUpdate();
                break;
            }
        }
    }

    public void addDailyManagerFromFile(String DMid, int dayOfMonth){
        for(int i=0; i<completeListOfDailyManagers.size(); i++){
            if(completeListOfDailyManagers.get(i).getCPR().equals(DMid)){
                //Days are one-off (the 1st in each month will be in the 0th position).
                workDays.get(dayOfMonth-1).getDailyOverview().setDailyManagerScheduled(completeListOfDailyManagers.get(i));
                break;
            }
        }
    }





    //Adds employee to a whole day of work. A work day is made of the hours from 7:00-17:00, which each gets an index in the arraylist (0 being 7:00-8:00, 1 is 8:00-9:00 and so on).
    public void addWorkerToSchedule(String empID, int dayOfMonth){
        for(int i=0; i<completeListOfEmployees.size(); i++){
            if(completeListOfEmployees.get(i).getCPR().equals(empID)){
                for(int j=0; j<10; j++){
                    workDays.get(dayOfMonth-1).getWorkHours().get(j).getEmployeeAtWork().add(completeListOfEmployees.get(i));
                }
                workDays.get(dayOfMonth-1).getDailyOverview().getEmployeesScheduled().add(completeListOfEmployees.get(i));
                break;
            }
        }
        workSheetUpdate();
    }
    //Adds an employee to a specific hour - the int given should be the start of the hour and the following 60 minutes.
    public void addWorkerToSchedule(String empID, int dayOfMonth, int hour){
        for(int i=0; i<completeListOfEmployees.size(); i++){
            if(completeListOfEmployees.get(i).getCPR().equals(empID)){
                workDays.get(dayOfMonth-1).getWorkHours().get(hour-7).getEmployeeAtWork().add(completeListOfEmployees.get(i));
                workDays.get(dayOfMonth-1).getDailyOverview().getEmployeesScheduled().add(completeListOfEmployees.get(i));
                break;
            }
        }
        workSheetUpdate();
    }

    //Adds employee to a range of hours in a specific workday.
    public void addWorkerToSchedule(String empID, int dayOfMonth, int startHour, int endHour){
        for(int i=0; i<completeListOfEmployees.size(); i++){
            if(completeListOfEmployees.get(i).getCPR().equals(empID)){
                for(int j=startHour; j<endHour; j++){
                    workDays.get(dayOfMonth-1).getWorkHours().get(j-7).getEmployeeAtWork().add(completeListOfEmployees.get(i));
                }
                workDays.get(dayOfMonth-1).getDailyOverview().getEmployeesScheduled().add(completeListOfEmployees.get(i));
                break;
            }
        }
        workSheetUpdate();
    }

    public void addWorkerFromFile(String empID, int dayOfMonth, int hour){
        for(int i=0; i<completeListOfEmployees.size(); i++){
            if(completeListOfEmployees.get(i).getCPR().equals(empID)){
                workDays.get(dayOfMonth-1).getWorkHours().get(hour-7).getEmployeeAtWork().add(completeListOfEmployees.get(i));
                workDays.get(dayOfMonth-1).getDailyOverview().getEmployeesScheduled().add(completeListOfEmployees.get(i));
                break;
            }
        }
    }




    //Beauty is when the ugliest methods do the most trivial job.
    public ArrayList<String> empsAtWorkOnDay(int dayOfMonth) {
        ArrayList<String> empCPRList = new ArrayList<String>();

        ArrayList<WorkHour> wh = workDays.get(dayOfMonth - 1).getWorkHours();

        for (int i = 0; i < wh.size(); i++) {
            for (int j = 0; j < wh.get(i).getEmployeeAtWork().size(); j++) {
                if (empCPRList.size() == 0) {
                    empCPRList.add(wh.get(i).getEmployeeAtWork().get(j).getCPR());
                } else {
                    int listSize = empCPRList.size();
                    boolean flag = false;
                    for (int h = 0; h < listSize; h++) {
                        if (empCPRList.get(h).equals(wh.get(i).getEmployeeAtWork().get(j).getCPR())) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        empCPRList.add(wh.get(i).getEmployeeAtWork().get(j).getCPR());
                    }
                }
            }
        }
        return empCPRList;
    }

    public String workScheduleOfDay(int dayOfMonth){
        String workSchedule = "";
        WorkDay workDayOfChoice = getWorkDays().get(dayOfMonth-1);
        for(int i=0; i < workDayOfChoice.getWorkHours().size(); i++){
            workSchedule += "" + (i+7) + "-" + (i+8) + ": ";
            for(int j=0; j<workDayOfChoice.getWorkHours().get(i).getEmployeeAtWork().size(); j++){
                workSchedule += workDayOfChoice.getWorkHours().get(i).getEmployeeAtWork().get(j).getCPR() + ", ";
            }
            workSchedule += "\n";
        }
        return workSchedule;
    }


    public void removeEmpFromDay(String CPR, int dayOfMonth){
        WorkDay workDayOfChoice = getWorkDays().get(dayOfMonth-1);
    }




    //Maybe just do it as a toString-override?
    public void viewWorksheet(){

    }




    public void clearWorksheet(){

    }


    @Override
    public void writeToFile() {
        try {
            FileWriter initWriteToWorksheet = new FileWriter("src/resourser/WorkSheetFile", true);
            String days = workSheetID + "\n";
            for(int i=0; i<workDays.size(); i++){
                if(workDays.get(i).getDailyOverview().getDailyManagerScheduled() == null){
                    days += "\n" + workDays.get(i).getDailyOverview().getDailyOverViewID() + "BREAK" + workDays.get(i).getDailyOverview().getDailyManagerScheduled() + "BREAK" + "\n";
                } else {
                    days += "\n" + workDays.get(i).getDailyOverview().getDailyOverViewID() + "BREAK" + workDays.get(i).getDailyOverview().getDailyManagerScheduled().getCPR() + "BREAK" + "\n";
                }
                for(int j=0; j<workDays.get(i).getWorkHours().size(); j++){
                    days += "" + (j+7) + "[";
                    for(int h=0; h<workDays.get(i).getWorkHours().get(j).getEmployeeAtWork().size(); h++){
                        days += workDays.get(i).getWorkHours().get(j).getEmployeeAtWork().get(h).getCPR() + ",";
                    }
                    days += "]\n";
                }
            }
            days += "ENDOFWORKSHEET\n";
            initWriteToWorksheet.write(days);
            initWriteToWorksheet.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void workSheetUpdate(){
        //Nevermind all the testing and tempfile-fun. The solution is quite simply to remake all the files.

        try {
            PrintWriter pw = new PrintWriter("src/resourser/WorkSheetFile");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Worksheet> worksheetlist = Kindergarten.getInstance().getWorksheetList();
        for(int i=0; i<worksheetlist.size(); i++){
            worksheetlist.get(i).writeToFile();
        }





        //Calls upon the worksheetID of this object to ensure that changes are only made to this exact part of the file.
        //subsequently the whole file is printed to a tempfile with the changes and finally printed onto the existing file.
        //try {
            //Scanner sc = new Scanner(new File("src/resourser/WorkSheetFile"));
            //FileWriter tempWriter = new FileWriter("src/resourser/tempFile", true);



            /*
            while(sc.hasNextLine()){
                String checkLine = sc.nextLine();
                if(!checkLine.equals(workSheetID)){
                    FileWriter tempWriter2 = new FileWriter("src/resourser/tempFile", true);
                    tempWriter2.write(checkLine + "\n");
                    tempWriter2.close();
                } else {
                    System.out.println("ID WAS CORRECT");
                    while(!sc.nextLine().contains("ENDOFWORKSHEET")){
                        System.out.println("SKIP");
                    }
                }
            }
            tempWriter.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter tempWriter2 = new FileWriter("src/resourser/tempFile", true);
            String days = workSheetID + "\n";
            for(int i=0; i<workDays.size(); i++){
                if(workDays.get(i).getDailyOverview().getDailyManagerScheduled() == null){
                    days += "\n" + workDays.get(i).getDailyOverview().getDailyOverViewID() + "BREAK" + workDays.get(i).getDailyOverview().getDailyManagerScheduled() + "\n";
                } else {
                    days += "\n" + workDays.get(i).getDailyOverview().getDailyOverViewID() + "BREAK" + workDays.get(i).getDailyOverview().getDailyManagerScheduled().getCPR() + "\n";
                }
                for(int j=0; j<workDays.get(i).getWorkHours().size(); j++){
                    days += "" + (j+7) + "[";
                    for(int h=0; h<workDays.get(i).getWorkHours().get(j).getEmployeeAtWork().size(); h++){
                        days += workDays.get(i).getWorkHours().get(j).getEmployeeAtWork().get(h) + ",";
                    }
                    days += "]\n";
                }
            }
            days += "ENDOFWORKSHEET\n";
            System.out.println(days);
            tempWriter2.write(days);
            tempWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*try {
            Scanner scs = new Scanner(new File("src/resourser/WorkSheetFile"));
            FileWriter tempWriter = new FileWriter("src/resourser/tempFile", true);
            while(scs.hasNextLine()){
                String lineCheck = scs.nextLine();
                System.out.println(lineCheck);
                if(lineCheck.equals(workSheetID)){
                    String days = workSheetID + "\n";
                    for(int i=0; i<workDays.size(); i++){
                        if(workDays.get(i).getDailyOverview().getDailyManagerScheduled() == null){
                            days += "\n" + workDays.get(i).getDailyOverview().getDailyOverViewID() + "BREAK" + workDays.get(i).getDailyOverview().getDailyManagerScheduled() + "\n";
                        } else {
                            days += "\n" + workDays.get(i).getDailyOverview().getDailyOverViewID() + "BREAK" + workDays.get(i).getDailyOverview().getDailyManagerScheduled().getCPR() + "\n";
                        }
                        for(int j=0; j<workDays.get(i).getWorkHours().size(); j++){
                            days += "" + (j+7) + "[";
                            for(int h=0; h<workDays.get(i).getWorkHours().get(j).getEmployeeAtWork().size(); h++){
                                days += workDays.get(i).getWorkHours().get(j).getEmployeeAtWork().get(h) + ",";
                            }
                            days += "]\n";
                        }
                    }
                    days += "ENDOFWORKSHEET\n";
                    tempWriter.write(days);
                    tempWriter.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        //Everything from tempfile is transferred to the original file.
/*
        try{
            PrintWriter pw = new PrintWriter("src/resourser/WorkSheetFile");
            pw.write("");
            pw.close();

            FileWriter fromTempToFileWriter = new FileWriter("src/resourser/WorkSheetFile");
            Scanner sc = new Scanner(new File("src/resourser/tempFile"));

            while(sc.hasNextLine()){
                fromTempToFileWriter.write(sc.nextLine() + "\n");
            }
            fromTempToFileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            PrintWriter emptyTemp = new PrintWriter("src/resourser/tempFile");
            emptyTemp.print("");
            emptyTemp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}