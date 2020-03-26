package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class DailyOverview implements ClassesToStoreInFiles{
    private ArrayList<ChildCheckInOut> childrenInGartenNow;
    private ArrayList<ChildCheckInOut> childCheckedOut;

    //User in the sense of this program is the different employees of the kindergarten, including DailyManager and Boss.
    private ArrayList<Employee> employeesScheduled;
    private ArrayList<UserCheckInOut> employeesInGartenNow;
    private ArrayList<UserCheckInOut> employeeCheckedOut;

    private DailyManager dailyManagerScheduled;
    private UserCheckInOut dailyManagerInGartenNow;
    private UserCheckInOut dailyManagerCheckedOut;

    //Initially there is no children in garten, they will all be checked in when they arrive
    //and checked out when they leave.

    //The specific employees and daily manager at work today will be determined by the worksheet,
    //and directly imported from there, i. e. no input needed when instantiating this object.

    public DailyOverview(ArrayList<Employee> employeesScheduled, DailyManager dailyManagerScheduled){
        childrenInGartenNow = new ArrayList<ChildCheckInOut>();

        this.employeesScheduled = employeesScheduled;
        employeesInGartenNow = new ArrayList<UserCheckInOut>();

        this.dailyManagerScheduled = dailyManagerScheduled;
        //dailyManagerInGartenNow = new UserCheckInOut(null);
    }

    //
    //
    //THESE TWO WILL NEED TO BE FINISHED AT A LATER POINT, WHERE WORKSHEET IS DONE.
    //
    //

    public void childCheckIn(Child child){
        ChildCheckInOut ccio = new ChildCheckInOut(child);
        childrenInGartenNow.add(ccio);
    }

    public void childCheckOut(Child child){
        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(child.getCPR())){
                childrenInGartenNow.remove(i);
                break;
            }
        }
    }

    public void employeeCheckIn(Employee employee){
        UserCheckInOut ucio = new UserCheckInOut(employee);
        ucio.setCheckInTimeToNow();
        employeesInGartenNow.add(ucio);
    }

    public void employeeCheckOut(Employee employee){
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getId().equals(employee.getId())){
                employeesInGartenNow.get(i).setCheckOutTimeToNow();
                employeesInGartenNow.get(i).calcTotalTimeCheckedIn();
                employeeCheckedOut.add(employeesInGartenNow.get(i));
                employeesInGartenNow.remove(i);
                break;
            }
        }
    }

    public void dailyManagerCheckIn(DailyManager dm){
        UserCheckInOut ucio = new UserCheckInOut(dm);
        ucio.setCheckInTimeToNow();
        dailyManagerInGartenNow = ucio;
    }

    public void dailyManagerCheckOut(){
        dailyManagerInGartenNow.setCheckOutTimeToNow();
        dailyManagerInGartenNow.calcTotalTimeCheckedIn();
        dailyManagerCheckedOut = dailyManagerInGartenNow;
        dailyManagerInGartenNow = null;
    }





    //Gui-cal magic. If necessary override toString.
    public String showDailyOverview(){
        return "";
    }









    //
    //
    //All of the methods below this point handles files and file storaging of changes.
    //
    //


    // Her er 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ind.
    // der skal laves en metode der regner ud hvor mange timer de forskellige employee har været på arbejde
    // samt tilføjer denne tids information i en anden fil

    private void childCheckInToDailyOverviewFile(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter childInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile");
        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){
                String childCheckInToFile =  childrenInGartenNow.get(i).getChild().getCPR() + " " + tempDateTime.getHour()+":"+tempDateTime.getMinute() + "\n";
                childInGartenTodayfw.write(childCheckInToFile);
                childInGartenTodayfw.close();
            }
        }
    }

    private void EmployeesCheckInToDailyoverviewFile(String ID) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter employeeInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile");
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getId().equals(ID)){
                String employeeWriteToCheckInFile = employeesInGartenNow.get(i).getUser().getId() + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute()+"\n";
                employeeInGartenTodayfw.write(employeeWriteToCheckInFile);
                employeeInGartenTodayfw.close();
            }
        }
    }

    //tilføjer daily manager til dailyoverviewFile
    private void DailyManagerCheckInToDailyOverviewFile() throws IOException {
        FileWriter dailyManagerInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile");
        LocalDateTime tempDateTime = LocalDateTime.now();
        String dailyManagerCheckInToFile = dailyManagerInGartenNow.getUser().getId()+" "+ tempDateTime.getHour()+":"+tempDateTime.getMinute() + "\n";
        dailyManagerInGartenTodayfw.write(dailyManagerCheckInToFile);
        dailyManagerInGartenTodayfw.close();
    }

    // Her skal laves 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ud.
    // der skal laves en metode der regner ud hvor mange timer de forskellige employee har været på arbejde
    // samt tilføjer denne tids information i denne fil også

    private void childCheckOutOfDailyOverview(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter childOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile");
        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){

                Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));

                String theStringINeed="";
                while (sc.hasNextLine())
                {
                    if(sc.next().equals(CPR)){
                         theStringINeed=sc.next();
                    }
                }

                String childCheckOutToFile = childrenInGartenNow.get(i).getChild().getCPR() + " " + theStringINeed + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute();
                childOutOfGartenTodayfw.write(childCheckOutToFile);
                childOutOfGartenTodayfw.close();

            }
        }
    }

    private void EmployeesCheckOutOfDailyoverview(String ID) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter employeeOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile");
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getId().equals(ID)){

                Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));

                String theStringINeed="";
                while (sc.hasNextLine())
                {
                    if(sc.next().equals(ID)){
                        theStringINeed=sc.next();
                    }
                }

                String employeeCheckOutToFile = employeesInGartenNow.get(i).getUser().getId() + " " + theStringINeed + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute();
                employeeOutOfGartenTodayfw.write(employeeCheckOutToFile);
                employeeOutOfGartenTodayfw.close();

            }
        }
    }

    private void DailyManagerCheckOutOfDailyOverview(String ID) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter dailyManagerOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile");
        Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));

        String theStringINeed="";
        while (sc.hasNextLine())
        {
            if(sc.next().equals(ID)){
                theStringINeed=sc.next();
            }
        }

        String dailyManagerCheckOutToFile = dailyManagerInGartenNow.getUser().getId() + " " + theStringINeed + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute();
        dailyManagerOutOfGartenTodayfw.write(dailyManagerCheckOutToFile);
        dailyManagerOutOfGartenTodayfw.close();

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
                "Children still in kindergarten: " + childrenInGartenNow + "\n\n" +
                "Employees still on work: " + employeesInGartenNow + "\n\n" +
                "Daily Manager still: " + dailyManagerInGartenNow +
                '}';
    }
}

