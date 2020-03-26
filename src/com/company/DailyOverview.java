package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

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

        ArrayList<Child> childrenInGarten = InitiateArray.getInstance().childrenInGarten;
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
        return "" + childrenInGartenNow;
    }









    //
    //
    //All of the methods below this point handles files and file storaging of changes.
    //
    //


    // Her er 3 metoder der skriver til en fil med børn, daily manager, samt employee der bliver checket ind.
    // der skal laves en metode der regner ud hvor mange timer de forskellige employee har været på arbejde
    // samt tilføjer denne tids information i en anden fil


    // ser ud somom den skriver fra første linje hver gang så der skal laves en rettelse så den først starter med at skrive
    // når der er en tom linje
    private void childCheckInToDailyOverviewFile(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter childInGartenTodayfw = new FileWriter("src/resourser/DailyOverviewFile",true);

        for(int i = 0; i< childrenInGartenNow.size(); i++){
            System.out.println("her også ?"+ i + CPR);
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

    // der skal laves metoder der fjerner den valgte persons information/checkin info i dailyOverviewFile når de checker
    // checker ud, så listen ikke bliver initialiseret ved fejlopstart igen på den liste over folk der er checket ind

    //der skal også tilføjes en dato på de forskellige "checkout" filskrivninger når folk bliver checket ud og tilføjet
    //til filendailyOverviewCheckOutFile så vi kan holde styr på hvilke dato dataen er fra.

    private void childCheckOutOfDailyOverview(String CPR) throws IOException {
        LocalDateTime tempDateTime = LocalDateTime.now();
        FileWriter childOutOfGartenTodayfw = new FileWriter("src/resourser/DailyOverviewCheckedOutFile");
        Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));
        for(int i = 0; i< childrenInGartenNow.size(); i++){
            if(childrenInGartenNow.get(i).getChild().getCPR().equals(CPR)){
                String theStringINeed="";

                File file = new File("src/resourser/DailyOverviewFile");
                try {
                    // Create a new Scanner object which will read the data
                    // from the file passed in. To check if there are more
                    // line to read from it we check by calling the
                    // scanner.hasNextLine() method. We then read line one
                    // by one till all lines is read.
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

//                while (sc.hasNextLine()) {
//
//                    if(sc.nextLine().contains(CPR)){
//
//                         theStringINeed=sc.nextLine();
//                    }
//                }

                String childCheckOutToFile = childrenInGartenNow.get(i).getChild().getCPR() + " " + theStringINeed + " " + tempDateTime.getHour()+ ":" + tempDateTime.getMinute();
                childOutOfGartenTodayfw.write(childCheckOutToFile);
                childOutOfGartenTodayfw.close();
                removeChildFromDailyOverviewFile(CPR);

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


    private void removeUserFromDailyOverviewFile(String ID){

    }


    private void removeChildFromDailyOverviewFile(String CPR)throws IOException{


        Scanner sc = new Scanner("src/resourser/DailyOverviewFile");
        while(sc.hasNextLine()){
            String tempString = sc.nextLine();
            System.out.println(tempString);
            if(tempString.contains(CPR)){
                System.out.println("This is the file im looking for !");
            }
        }


        // lave en metode der iterere gennem dailyOverviewFile filen og sletter child med cpr nummer som matcher.
//        Scanner data = new Scanner("src/resourser/DailyOverviewFile");
//        if(data.hasNextLine()){
//            while(data.hasNextLine()){
//                if(data.nextLine().contains(CPR)){
//
//                    data.nextLine();
//                }
//                else{
//                    // denne else opretter en temp fil med alle informationerene der skal forblive og overskriver den nuværende DailyOverviewFile
//
//                    FileWriter tempdailyOverviewfw = new FileWriter(new File("src/resourser/TempDailyOverviewFile"));
//                    String tempStringToFile = data.nextLine() + "\n";
//                    tempdailyOverviewfw.write(tempStringToFile);
//                    tempdailyOverviewfw.close();
//                }
//            }
//            // her overskrives så dailyOverviewFile med TempDailyOverviewFile "som er den ændrede information"
//
//            Path source = Paths.get("src/resourser/TempDailyOverviewFile");
//            Path newdir = Paths.get("src/resourser/DailyOverviewFile");
//            Files.move(source, newdir.resolve(source.getFileName()), REPLACE_EXISTING);
//        }
//        new PrintWriter("src/resourser/TempDailyOverviewFile").close();

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

