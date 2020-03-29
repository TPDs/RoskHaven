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
        childCheckedOut = new ArrayList<ChildCheckInOut>();

        this.employeesScheduled = employeesScheduled;
        employeesInGartenNow = new ArrayList<UserCheckInOut>();
        employeeCheckedOut = new ArrayList<UserCheckInOut>();

        this.dailyManagerScheduled = dailyManagerScheduled;
        //dailyManagerInGartenNow = new UserCheckInOut(null);
    }

    //
    //
    //THESE TWO WILL NEED TO BE FINISHED AT A LATER POINT, WHERE WORKSHEET IS DONE.
    //
    //


    //Check in using current time
    public void childCheckIn(String CPR) throws IOException {

        boolean flag = false;

        //Checks whether the child is already checked in.
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
                    childCheckInToDailyOverviewFile(ccio);
                }
            }
        }
    }


    //Check in using custom time.
    public void childCheckIn(String CPR, int hours, int minutes) throws IOException {
        boolean flag = false;

        //Checks whether the child is already checked in.
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
                    ccio.setCustomCheckInTime(hours, minutes);
                    childrenInGartenNow.add(ccio);
                    childCheckInToDailyOverviewFile(ccio);
                }
            }
        }
    }


    //Checks out with current time.
    public void childCheckOut(String CPR) throws IOException {
        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){
                childrenInGartenNow.get(i).setCheckOutTimeToNow();
                childCheckedOut.add(childrenInGartenNow.get(i));
                childCheckOutOfDailyOverview(childrenInGartenNow.get(i));
                childrenInGartenNow.remove(i);
                break;
            }
        }
    }

    //Checks out with custom time.
    public void childCheckOut(String CPR, int hours, int minutes) throws IOException {
        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){
                childrenInGartenNow.get(i).setCustomCheckOutTime(hours, minutes);
                childCheckedOut.add(childrenInGartenNow.get(i));
                childCheckOutOfDailyOverview(childrenInGartenNow.get(i));
                childrenInGartenNow.remove(i);
                break;
            }
        }
    }


    //Checks in with current time.
    public void employeeCheckIn(String CPR) throws IOException {
        boolean flag = false;

        //Checks whether the employee is already checked in.
        for(int h=0; h<employeesInGartenNow.size(); h++){
            if(employeesInGartenNow.get(h).getUser().getCPR().equals(CPR)){
                flag=true;
                break;
            }
        }
        ArrayList<Employee> empInGarten = Kindergarten.getInstance().getEmployeesInGarten();
        if(!flag){

            for(int i=0; i<empInGarten.size(); i++){
                if(empInGarten.get(i).getCPR().equals(CPR)){
                    UserCheckInOut ucio = new UserCheckInOut(empInGarten.get(i));
                    employeesInGartenNow.add(ucio);
                    employeesCheckInToDailyoverviewFile(ucio);
                    break;
                }
            }
        }
    }

    //Checks in with custom time.
    public void employeeCheckIn(String CPR, int hours, int minutes) throws IOException {
        boolean flag = false;

        //Checks whether the employee is already checked in.
        for(int h=0; h<employeesInGartenNow.size(); h++){
            if(employeesInGartenNow.get(h).getUser().getCPR().equals(CPR)){
                flag=true;
                break;
            }
        }

        ArrayList<Employee> empInGarten = Kindergarten.getInstance().getEmployeesInGarten();
        if(!flag){
            for(int i=0; i<empInGarten.size(); i++){
                if(empInGarten.get(i).getCPR().equals(CPR)){
                    UserCheckInOut ucio = new UserCheckInOut(empInGarten.get(i));
                    ucio.setCustomCheckInTime(hours, minutes);
                    employeesInGartenNow.add(ucio);
                    employeesCheckInToDailyoverviewFile(ucio);
                    break;
                }
            }
        }
    }


    //Checks out with current time
    public void employeeCheckOut(String CPR){
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getCPR().equals(CPR)){
                employeesInGartenNow.get(i).setCheckOutTimeToNow();
                employeesInGartenNow.get(i).calcTotalTimeCheckedIn();
                employeeCheckedOut.add(employeesInGartenNow.get(i));

                employeesCheckOutOfDailyoverview(employeesInGartenNow.get(i));
                employeesInGartenNow.remove(i);
                break;
            }
        }
    }


    //Checks out with custom time.
    public void employeeCheckOut(String CPR, int hours, int minutes){
        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getCPR().equals(CPR)){
                employeesInGartenNow.get(i).setCustomCheckOutTime(hours, minutes);
                employeesInGartenNow.get(i).calcTotalTimeCheckedIn();
                employeeCheckedOut.add(employeesInGartenNow.get(i));
                employeesCheckOutOfDailyoverview(employeesInGartenNow.get(i));
                employeesInGartenNow.remove(i);
                break;
            }
        }
    }


    //Check in with current time.
    public void dailyManagerCheckIn(String CPR) throws IOException {
        ArrayList<DailyManager> dmList = Kindergarten.getInstance().getDailyManagersInGarten();

        for(int i=0; i<dmList.size(); i++){
            if(dmList.get(i).getCPR().equals(CPR)){
                UserCheckInOut ucio = new UserCheckInOut(dmList.get(i));
                dailyManagerInGartenNow = ucio;
                dailyManagerCheckInToDailyOverviewFile(ucio);
            }
        }
    }

    //check in with custom time
    public void dailyManagerCheckIn(String CPR, int hours, int minutes) throws IOException {
        ArrayList<DailyManager> dmList = Kindergarten.getInstance().getDailyManagersInGarten();

        for(int i=0; i<dmList.size(); i++){
            if(dmList.get(i).getCPR().equals(CPR)){
                UserCheckInOut ucio = new UserCheckInOut(dmList.get(i));
                ucio.setCustomCheckInTime(hours, minutes);
                dailyManagerInGartenNow = ucio;
                dailyManagerCheckInToDailyOverviewFile(ucio);
            }
        }
    }


    //Checks out with current time.
    public void dailyManagerCheckOut(String CPR){
        dailyManagerInGartenNow.setCheckOutTimeToNow();
        dailyManagerInGartenNow.calcTotalTimeCheckedIn();
        dailyManagerCheckedOut = dailyManagerInGartenNow;
        dailyManagerCheckOutOfDailyOverview(dailyManagerInGartenNow);
        dailyManagerInGartenNow = null;
    }

    //Checks out with custom time
    public void dailyManagerCheckOut(int hours, int minutes){
        dailyManagerInGartenNow.setCustomCheckOutTime(hours, minutes);
        dailyManagerInGartenNow.calcTotalTimeCheckedIn();
        dailyManagerCheckedOut = dailyManagerInGartenNow;
        dailyManagerCheckOutOfDailyOverview(dailyManagerInGartenNow);
        dailyManagerInGartenNow = null;
    }


    //
    //
    //All of the methods below this point handles files and file storaging of changes.
    //
    //


    // Her er 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ind.
    // tilføjer tids information på check in og check ud

    private void childCheckInToDailyOverviewFile(ChildCheckInOut ccio) throws IOException {
        FileWriter childInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile", true);
        String childCheckInToFile = ccio.getChild().getCPR() + "BREAK" + ccio.getCheckInTime() + "\n";
        childInGartenTodayfw.write(childCheckInToFile);
        childInGartenTodayfw.close();
    }


    private void employeesCheckInToDailyoverviewFile(UserCheckInOut ucio) throws IOException {
        FileWriter employeeInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile",true);
                String employeeWriteToCheckInFile = ucio.getUser().getCPR() + "BREAK" + ucio.getCheckInTime() +"\n";
                employeeInGartenTodayfw.write(employeeWriteToCheckInFile);
                employeeInGartenTodayfw.close();
    }


    //tilføjer daily manager til dailyoverviewFile
    private void dailyManagerCheckInToDailyOverviewFile(UserCheckInOut ucio) throws IOException {
        FileWriter dailyManagerInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile",true);
                String dailyManagerCheckInToFile = ucio.getUser().getCPR() +"BREAK"+ ucio.getCheckInTime() + "\n";
                dailyManagerInGartenTodayfw.write(dailyManagerCheckInToFile);
                dailyManagerInGartenTodayfw.close();
    }


    // Her skal laves 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ud.

    // der skal laves metoder der fjerner den valgte persons information/checkin info i dailyOverviewFile når de
    // checker ud, så listen ikke bliver initialiseret ved fejlopstart igen på den liste over folk der er checket ind

    //der skal også tilføjes en dato på de forskellige "checkout" filskrivninger når folk bliver checket ud og tilføjet
    //til filendailyOverviewCheckOutFile så vi kan holde styr på hvilke dato dataen er fra.

    private void childCheckOutOfDailyOverview(ChildCheckInOut ccio) throws IOException {
        FileWriter childOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile", true);
        Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile")).useDelimiter("\\s*BREAK\\s*");

        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(ccio.getChild().getCPR())){
                String TheRightString="";

                while(sc.hasNextLine()){
                    String theStringINeed=sc.nextLine();
                    if(theStringINeed.contains(childrenInGartenNow.get(i).getChild().getCPR())){
                       TheRightString = theStringINeed;
                    }
                }
                String childCheckOutToFile = TheRightString + "BREAK" + ccio.getCheckOutTime() +"\n";
                childOutOfGartenTodayfw.write(childCheckOutToFile);
                childOutOfGartenTodayfw.close();
                removeFromDailyOverviewFile(ccio.getChild().getCPR());

            }
        }
    }

    private void employeesCheckOutOfDailyoverview(UserCheckInOut ucio){

        Scanner sc = null;

        try {
            sc = new Scanner(new File("src/resourser/DailyOverviewFile")).useDelimiter("\\s*BREAK\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i< employeesInGartenNow.size(); i++){
            if(employeesInGartenNow.get(i).getUser().getCPR().equals(ucio.getUser().getCPR())){
                String TheRightString="";


                while (sc.hasNextLine()) {
                    String theStringINeed=sc.nextLine();
                    if(theStringINeed.contains(ucio.getUser().getCPR())){
                        TheRightString = theStringINeed;
                    }
                }

                FileWriter employeeOutOfGartenTodayfw = null;
                try {
                    employeeOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile",true);
                    String employeeCheckOutToFile = "" + TheRightString + "BREAK" + ucio.getCheckOutTime() +"\n";
                    employeeOutOfGartenTodayfw.write(employeeCheckOutToFile);
                    employeeOutOfGartenTodayfw.close();
                    removeFromDailyOverviewFile(ucio.getUser().getCPR());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    private void dailyManagerCheckOutOfDailyOverview(UserCheckInOut ucio){
        LocalDateTime tempDateTime = LocalDateTime.now();

        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/resourser/DailyOverviewFile")).useDelimiter("\\s*BREAK\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String TheRightString="";

        while (sc.hasNextLine()){
        String theStringINeed=sc.nextLine();

            if(theStringINeed.contains(ucio.getUser().getCPR())){
                TheRightString=theStringINeed;
            }
        }

        FileWriter dailyManagerOutOfGartenTodayfw = null;
        try {
            dailyManagerOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile",true );
            String dailyManagerCheckOutToFile = TheRightString + "BREAK" + ucio.getCheckOutTime() +"\n";
            dailyManagerOutOfGartenTodayfw.write(dailyManagerCheckOutToFile);
            dailyManagerOutOfGartenTodayfw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void removeFromDailyOverviewFile(String CPR) {

        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/resourser/DailyOverviewFile")).useDelimiter("\\s*BREAK\\s*");
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
        String LineChecker = "";
        while (sc.hasNextLine()) {

            LineChecker = sc.nextLine();
// checker om linechecker String ikke indeholder CPR input og gemmer de linjer der ikke container i en temp fil
            if (!LineChecker.contains(CPR)) {
                // denne else opretter en temp fil med alle informationerene der skal forblive og overskriver den nuværende DailyOverviewFile
                FileWriter tempdailyOverviewfw = null;
                try {
                    tempdailyOverviewfw = new FileWriter("src/resourser/TempDailyOverviewFile", true);
                    String tempStringToFile = LineChecker + "\n";
                    tempdailyOverviewfw.write(tempStringToFile);
                    tempdailyOverviewfw.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        // dailyoverwievFilen bliver slettet ved af lave et Write med en tom string til filen uden append.
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("src/resourser/DailyOverviewFile");
            writer.print("");
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // her overskrives så dailyOverviewFile med TempDailyOverviewFile "som er den ændrede information"
        Scanner overridesc = null;
        try {
            overridesc = new Scanner(new File("src/resourser/TempDailyOverviewFile")).useDelimiter("\\s*BREAK\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String overrideText = "";
        while(overridesc.hasNextLine()){
            overrideText=overridesc.nextLine();


            FileWriter tempfw = null;
            try {
                tempfw = new FileWriter("src/resourser/DailyOverviewFile",true);
                String tempString = overrideText + "\n";
                tempfw.write(tempString);
                tempfw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            // her slettes indholdet af tempDailyOverviewFile med et tomt string Write så den er parat til næste opgave
            PrintWriter writer2 = null;
            try {
                writer2 = new PrintWriter("src/resourser/TempDailyOverviewFile");
                writer2.print("");
                writer2.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

