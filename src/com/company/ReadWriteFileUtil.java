package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//
//
//Changed from a singleton class to a pure utility class
//
//

public final class ReadWriteFileUtil {

    private ReadWriteFileUtil(){

    }

    public static Boss readBoss(){
        Boss boss = null;
        try {
            Scanner sc = new Scanner(new File("src/resourser/EmployeeListFile"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] elements = line.split(",");
                if(elements[0].equals("b")){
                    boss = new Boss(elements[1], elements[2], elements[3], true);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return boss;
    }

    public static ArrayList<Employee> readEmployeeList() {
        ArrayList<Employee> empList = new ArrayList<Employee>();
        try {
            Scanner sc = new Scanner(new File("src/resourser/EmployeeListFile"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] elements = line.split(",");
                if(elements[0].equals("emp")){
                    Employee employee = new Employee(elements[1], elements[2], elements[3], true);
                    empList.add(employee);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return empList;
    }

    public static ArrayList<DailyManager> readDailyManagerList(){
        ArrayList<DailyManager> dmList = new ArrayList<DailyManager>();
        try {
            Scanner sc = new Scanner(new File("src/resourser/EmployeeListFile"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] elements = line.split(",");
                if(elements[0].equals("dm")){
                    DailyManager dailyManager = new DailyManager(elements[1], elements[2], elements[3], true);
                    dmList.add(dailyManager);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dmList;
    }

    public static ArrayList<Child> readChildList(){
        ArrayList<Child> childList = new ArrayList<Child>();
        //READ FROM FILE
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/resourser/ChildFile"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
                String tempStr = sc.nextLine();
                Scanner sc1 = new Scanner(tempStr).useDelimiter("\\s*BREAK\\s*");
            String iName = sc1.next();
            String iCPR = sc1.next();
            String note = sc1.next();
            String status = sc1.next();
            switch(status){
                case "PASSIVE":
                    childList.add(new Child(iName, iCPR, note, ChildStatus.PASSIVE));
                    break;

                case "ACTIVE":
                    childList.add(new Child(iName, iCPR, note, ChildStatus.ACTIVE));
                    break;

                case "QUEUE":
                    childList.add(new Child(iName, iCPR, note, ChildStatus.QUEUE));
                    break;
            }
        }

        readGuardians(childList);
        return childList;
    }


    // skal indlæse og checke guardian filen om der er en guardian til barn
    private static void readGuardians(ArrayList<Child> childList){

        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/resourser/GuardianFile"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(sc.hasNextLine()){
            String tempF = sc.nextLine();
            Scanner sc1=new Scanner(tempF).useDelimiter("\\s*BREAK\\s*");
            String guardianID = sc1.next();
            String name = sc1.next();
            String mail = sc1.next();
            String phoneN = sc1.next();
            String adress = sc1.next();
            String childCPR = sc1.next();

            for(int i=0;i<childList.size();i++){
                if(childCPR.equals(childList.get(i).getCPR())){
                    childList.get(i).addGuardian(guardianID,name,mail,phoneN,adress);
                }
            }
        }
    }


    public static ArrayList<Worksheet> readWorksheet(){
        ArrayList<Worksheet> worksheetList = new ArrayList<Worksheet>();
        //READ FROM FILE
        try {
            Scanner sc = new Scanner(new File("src/resourser/WorkSheetFile"));

            while(sc.hasNextLine()){
                String worksheetID = "";

                if(sc.hasNextLine()){
                    worksheetID = sc.nextLine();
                }

                Worksheet worksheet = new Worksheet(Integer.parseInt(worksheetID.substring(1,5)), Integer.parseInt(worksheetID.substring(6)), worksheetID);
                worksheetList.add(worksheet);

                String isEnd = "";

                while(!isEnd.contains("ENDOFWORKSHEET")){
                    //empty line between each workday in file.
                    if(sc.nextLine().contains("ENDOFWORKSHEET")){
                        break;
                    }


                    //Taking a scanner to break the next line in two parts - one being each day, the other being the daily manager responsible for this day.
                    String[] dayHeader = sc.nextLine().split("BREAK");

                    String workday = dayHeader[0];
                    String[] workday2 = workday.split("D");
                    String dailyManager = dayHeader[1];

                    worksheet.addDailyManagerFromFile(dailyManager, Integer.parseInt(workday2[1]));

                    for(int i=0; i<10; i++){

                        String workHours = sc.next();
                        String[] hourParts = workHours.split("\\[");
                        String[] employees = hourParts[1].split(",");

                        for(int j=0; j<employees.length-1; j++){
                            worksheet.addWorkerFromFile(employees[j],Integer.parseInt(workday2[1]),i+7);
                        }
                    }
                    isEnd = sc.nextLine();

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return worksheetList;
    }



    public static void readDailyOverviewFile(ArrayList<Worksheet> worksheetList){
        try {
            Scanner sc = new Scanner(new File("src/resourser/DailyOverviewFile"));


            while(sc.hasNextLine()){
                String dailyID = sc.nextLine();


                String[] dailySplitted = dailyID.split("D");
                String worksheetID = dailySplitted[0];


                for(int i=0; i<worksheetList.size(); i++){
                    if(worksheetList.get(i).getWorkSheetID().equals(worksheetID)){
                        String[] childCheckInSplitted = sc.nextLine().split("BREAK");
                        String[] hourMinutes = childCheckInSplitted[1].split(":");
                        worksheetList.get(i).getWorkDays().get(Integer.parseInt(dailySplitted[1])-1).getDailyOverview().childCheckIn(childCheckInSplitted[0], Integer.parseInt(hourMinutes[0]), Integer.parseInt(hourMinutes[1]), true);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    //
    //
    //Write to file utils
    //
    //

    public static void addBlankSpaceToFile() {
        try {
            FileWriter initWriteToWorksheet = new FileWriter("src/resourser/WorkSheetFile", true);
            String idLine = "\n";
            initWriteToWorksheet.write(idLine);
            initWriteToWorksheet.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
