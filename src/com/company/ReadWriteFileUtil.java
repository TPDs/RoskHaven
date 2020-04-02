package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//
//
//Singleton class of all arrays to be used globally in the entire program.
//
//

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
                    //System.out.println("broke the line");

                    //Taking a scanner to break the next line in two parts - one being each day, the other being the daily manager responsible for this day.
                    String[] dayHeader = sc.nextLine().split("BREAK");
                    //System.out.println(dayHeader[0]);
                    //System.out.println(dayHeader[1]);
                    //System.out.println(dayHeader.length);
                    String workday = dayHeader[0];
                    String[] workday2 = workday.split("D");
                    String dailyManager = dayHeader[1];

                    worksheet.addDailyManagerFromFile(dailyManager, Integer.parseInt(workday2[1]));

                    for(int i=0; i<10; i++){
                        //System.out.println("hour");
                        String workHours = sc.next();
                        String[] hourParts = workHours.split("\\[");
                        String[] employees = hourParts[1].split(",");

                        for(int j=0; j<employees.length-1; j++){
                            worksheet.addWorkerFromFile(employees[j],Integer.parseInt(workday2[1]),i+7);
                        }
                    }
                    isEnd = sc.nextLine();
                    //System.out.println(isEnd);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return worksheetList;
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
