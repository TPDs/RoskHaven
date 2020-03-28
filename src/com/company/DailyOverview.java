package com.company;

import java.io.*;
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

    public void childCheckIn(String CPR) throws IOException {

        boolean flag = false;

        for(int h=0;h<childrenInGartenNow.size();h++){
            if(childrenInGartenNow.get(h).getChild().getCPR().equals(CPR)){
                flag = true;
                break;
            }
        }
        ArrayList<Child> childrenInGarten = Kindergarten.getInstance().getChildrenInGarten();
        if(!flag){
            for(int i=0; i<childrenInGarten.size();i++){
                if (childrenInGarten.get(i).getCPR().equals(CPR)){
                    ChildCheckInOut ccio = new ChildCheckInOut(childrenInGarten.get(i));
                    childrenInGartenNow.add(ccio);
                    childCheckInToDailyOverviewFile(CPR);
                }
            }
        }
    }

    public void childCheckOut(String CPR) throws IOException {
        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){
                childCheckOutOfDailyOverview(CPR);
                childrenInGartenNow.remove(i);
                break;
            }
        }
    }


    // disse 4 metoder til check in og ud skal ændres så de tager imod cpr ved check in og ud
    public void employeeCheckIn(Employee employee){
        UserCheckInOut ucio = new UserCheckInOut(employee);
        ucio.setCheckInTimeToNow();
        employeesInGartenNow.add(ucio);

    }

    public void employeeCheckOut(Employee employee){
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getCPR().equals(employee.getCPR())){
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
        return "" + childrenInGartenNow;
    }









    //
    //
    //All of the methods below this point handles files and file storaging of changes.
    //
    //


    // Her er 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ind.
    // tilføjer tids information på check in og check ud

    private void childCheckInToDailyOverviewFile(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter childInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile",true);

        for(int i = 0; i< childrenInGartenNow.size(); i++){

            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){
                String childCheckInToFile =  childrenInGartenNow.get(i).getChild().getCPR() + " " + tempDateTime.getHour()+":"+tempDateTime.getMinute() + "\n";
                childInGartenTodayfw.write(childCheckInToFile);
                childInGartenTodayfw.close();
            }
        }
    }

    private void EmployeesCheckInToDailyoverviewFile(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter employeeInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile",true);
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getCPR().equals(CPR)){
                String employeeWriteToCheckInFile = employeesInGartenNow.get(i).getUser().getCPR() + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute()+"\n";
                employeeInGartenTodayfw.write(employeeWriteToCheckInFile);
                employeeInGartenTodayfw.close();
            }
        }
    }


    //tilføjer daily manager til dailyoverviewFile
    private void DailyManagerCheckInToDailyOverviewFile(String CPR) throws IOException {
        FileWriter dailyManagerInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile",true);
        LocalDateTime tempDateTime = LocalDateTime.now();
        for(int i=0;i<Kindergarten.getInstance().getDailyManagersInGarten().size();i++){
            if(Kindergarten.getInstance().getDailyManagersInGarten().get(i).getCPR().equals(CPR)){
                String dailyManagerCheckInToFile = dailyManagerInGartenNow.getUser().getCPR()+" "+ tempDateTime.getHour()+":"+tempDateTime.getMinute() + "\n";
                dailyManagerInGartenTodayfw.write(dailyManagerCheckInToFile);
                dailyManagerInGartenTodayfw.close();
            }
        }
    }

    // Her skal laves 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ud.

    // der skal laves metoder der fjerner den valgte persons information/checkin info i dailyOverviewFile når de
    // checker ud, så listen ikke bliver initialiseret ved fejlopstart igen på den liste over folk der er checket ind

    //der skal også tilføjes en dato på de forskellige "checkout" filskrivninger når folk bliver checket ud og tilføjet
    //til filendailyOverviewCheckOutFile så vi kan holde styr på hvilke dato dataen er fra.

    private void childCheckOutOfDailyOverview(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter childOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile", true);
        Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));

        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){
                String TheRightString="";

                while(sc.hasNextLine()){
                    String theStringINeed=sc.nextLine();
                    if(theStringINeed.contains(childrenInGartenNow.get(i).getChild().getCPR())){
                       TheRightString = theStringINeed;
                    }
                }
                String childCheckOutToFile = TheRightString + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute()+"\n";
                childOutOfGartenTodayfw.write(childCheckOutToFile);
                childOutOfGartenTodayfw.close();
                removeFromDailyOverviewFile(CPR);

            }
        }
    }

    private void EmployeesCheckOutOfDailyoverview(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter employeeOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile",true);
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getCPR().equals(CPR)){

                Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));

                String theStringINeed="";
                while (sc.hasNextLine())
                {
                    if(sc.next().equals(CPR)){
                        theStringINeed=sc.next();
                    }
                }

                String employeeCheckOutToFile = employeesInGartenNow.get(i).getUser().getCPR() + " " + theStringINeed + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute();
                employeeOutOfGartenTodayfw.write(employeeCheckOutToFile);
                employeeOutOfGartenTodayfw.close();
                removeFromDailyOverviewFile(CPR);

            }
        }
    }

    private void DailyManagerCheckOutOfDailyOverview(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter dailyManagerOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile",true );
        Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));

        String theStringINeed="";
        while (sc.hasNextLine())
        {
            if(sc.next().equals(CPR)){
                theStringINeed=sc.next();
            }
        }

        String dailyManagerCheckOutToFile = dailyManagerInGartenNow.getUser().getCPR() + " " + theStringINeed + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute();
        dailyManagerOutOfGartenTodayfw.write(dailyManagerCheckOutToFile);
        dailyManagerOutOfGartenTodayfw.close();

    }


    private void removeUserFromDailyOverviewFile(String ID){

    }


    private void removeFromDailyOverviewFile(String CPR)throws IOException {
        Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));
        String LineChecker = "";
        while (sc.hasNextLine()) {

            LineChecker = sc.nextLine();

            if (LineChecker.contains(CPR)) {

            } else {
                // denne else opretter en temp fil med alle informationerene der skal forblive og overskriver den nuværende DailyOverviewFile
                FileWriter tempdailyOverviewfw = new FileWriter("src/resourser/TempDailyOverviewFile", true);
                String tempStringToFile = LineChecker + "\n";
                tempdailyOverviewfw.write(tempStringToFile);
                tempdailyOverviewfw.close();
            }
        }
        // dailyoverwievFilen bliver slettet ved af lave et Write med en tom string til filen uden append.
        PrintWriter writer = new PrintWriter("src/resourser/DailyOverviewFile");
        writer.print("");
        writer.close();

        // her overskrives så dailyOverviewFile med TempDailyOverviewFile "som er den ændrede information"
        Scanner overridesc = new Scanner(new File("src/resourser/TempDailyOverviewFile"));
        String overrideText = "";
        while(overridesc.hasNextLine()){
            overrideText=overridesc.nextLine();
            FileWriter tempfw = new FileWriter("src/resourser/DailyOverviewFile",true);
            String tempString = overrideText + "\n";
            tempfw.write(tempString);
            tempfw.close();

            // her slettes indholdet af tempDailyOverviewFile med et tomt string Write så den er parat til næste opgave
            PrintWriter writer2 = new PrintWriter("src/resourser/TempDailyOverviewFile");
            writer2.print("");
            writer2.close();

        }
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

