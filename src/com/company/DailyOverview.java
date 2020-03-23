package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DailyOverview implements ClassesToStoreInFiles{
    private ArrayList<Child> childrenInGartenToday;
    private ArrayList<Employee> employeesInGartenToday;
    private DailyManager dailyManagerInGartenToday;
    private DailyManager dailyManagerCheckOut;
    private ArrayList<Employee> employeeCheckOut;
    private ArrayList<Child> childCheckOut;


    //Initially there is no children in garten, they will all be checked in when they arrive
    //and checked out when they leave.

    //The specific employees and daily manager at work today will be determined by the worksheet,
    //and directly imported from there, i. e. no input needed when instantiating this object.

    public DailyOverview(){
        childrenInGartenToday = new ArrayList<Child>();
        employeesInGartenToday = importEmployeesFromWorksheet();
        dailyManagerInGartenToday = importDailyManagerFromWorksheet();

    }

    //
    //
    //THESE TWO WILL NEED TO BE FINISHED AT A LATER POINT, WHERE WORKSHEET IS DONE.
    //
    //

    public ArrayList<Employee> importEmployeesFromWorksheet(){
        return new ArrayList<Employee>();
    }

    public DailyManager importDailyManagerFromWorksheet(){
        return new DailyManager("a","b","c");
    }


    public void childCheckIn(Child child){
        childrenInGartenToday.add(child);
    }

    public void childCheckOut(Child child){
        for(int i=0; i<childrenInGartenToday.size(); i++){
            if(childrenInGartenToday.get(i).getCPR().equals(child.getCPR())){
                childrenInGartenToday.remove(i);
                break;
            }
        }
    }

    public void employeeCheckIn(Employee employee){
        employeesInGartenToday.add(employee);
    }

    public void employeeCheckOut(Employee employee){
        for(int i=0; i<employeesInGartenToday.size(); i++){
            if(employeesInGartenToday.get(i).getId().equals(employee.getId())){
                employeesInGartenToday.remove(i);
                break;
            }
        }
    }

    public void dailyManagerCheckIn(DailyManager dm){
        dailyManagerInGartenToday = dm;
    }

    public void dailyManagerCheckOut(){ dailyManagerInGartenToday = null;
    }

    public String showDailyOverview(){
        return "";
    }

    // Her er 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ind.
    // der skal laves en metode der regner ud hvor mange timer de forskellige employee har været på arbejde
    // samt tilføjer denne tids information i en anden fil

    private void childCheckInToDailyOverviewFile(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter childInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile");
        for(int i=0;i<childrenInGartenToday.size();i++){
            if(childrenInGartenToday.get(i).getCPR()==CPR){
                String childCheckInToFile =  childrenInGartenToday.get(i).getCPR() + " " + tempDateTime.getHour()+":"+tempDateTime.getMinute() + "\n";
                childInGartenTodayfw.write(childCheckInToFile);
                childInGartenTodayfw.close();
            }
        }
    }

    private void EmployeesCheckInToDailyoverviewFile(String ID) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter employeeInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile");
        for(int i=0;i<employeesInGartenToday.size();i++){
            if(employeesInGartenToday.get(i).getId()==ID){
                String employeeWriteToCheckInFile = employeesInGartenToday.get(i).getId() + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute()+"\n";
                employeeInGartenTodayfw.write(employeeWriteToCheckInFile);
                employeeInGartenTodayfw.close();
            }
        }
    }

    //tilføjer daily manager til dailyoverviewFile
    private void DailyManagerCheckInToDailyOverviewFile() throws IOException {
        FileWriter dailyManagerInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile");
        LocalDateTime tempDateTime = LocalDateTime.now();
        String dailyManagerCheckInToFile = dailyManagerInGartenToday.getId()+" "+ tempDateTime.getHour()+":"+tempDateTime.getMinute() + "\n";
        dailyManagerInGartenTodayfw.write(dailyManagerCheckInToFile);
        dailyManagerInGartenTodayfw.close();
    }

    // Her skal laves 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ud.
    // der skal laves en metode der regner ud hvor mange timer de forskellige employee har været på arbejde
    // samt tilføjer denne tids information i denne fil også

    private void childCheckOutOfDailyOverview(String CPR){
    }

    private void EmployeesCheckOutOfDailyoverview(String ID){
    }

    private void DailyManagerCheckOutOfDailyOverview(){

    }

    @Override
    public void writeToFile() {
    }

    // metoden skal kunne bruges på childingartenToday til at fjerne fra listen ved checkout
    public void removeFromFile(){
    }

    @Override
    public String toString() {
        return "DailyOverview{" +
                "Children still in kindergarten: " + childrenInGartenToday + "\n\n" +
                "Employees still on work: " + employeesInGartenToday + "\n\n" +
                "Daily Manager still: " + dailyManagerInGartenToday +
                '}';
    }
}

