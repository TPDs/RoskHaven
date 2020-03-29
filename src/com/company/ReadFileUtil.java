package com.company;

import java.io.File;
import java.io.FileNotFoundException;
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

public final class ReadFileUtil {

    private ReadFileUtil(){

    }

    public static Boss readBoss(){
        //dummy boss, needs to be read to make sense.
        Boss boss = new Boss("a", "b", "c");
        //READ FROM FILE
        return boss;
    }

    public static ArrayList<Employee> readEmployeeList() {
        ArrayList<Employee> empList = new ArrayList<Employee>();
        //READ FROM FILE
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/resourser/EmployeeListFile")).useDelimiter("\\s*BREAK\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String iName = sc.next();
            String iCPR = sc.next();
            String iPW = sc.next();

            empList.add(new Employee(iName, iCPR, iPW));
        }
        return empList;
    }

    public static ArrayList<DailyManager> readDailyManagerList(){
        ArrayList<DailyManager> dmList = new ArrayList<DailyManager>();
        //READ FROM FILE
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/resourser/EmployeeListFile")).useDelimiter("\\s*BREAK\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String iName = sc.next();
            String iCPR = sc.next();
            String iPW = sc.next();

            dmList.add(new DailyManager(iName, iCPR, iPW));
        }
        return dmList;
    }

    public static ArrayList<Child> readChildList(){
        ArrayList<Child> childList = new ArrayList<Child>();
        //READ FROM FILE
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/resourser/ChildFile")).useDelimiter("\\s*BREAK\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String iName = sc.next();
            String iCPR = sc.next();
            String note = sc.next();
            String status = sc.next();
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
        return childList;
    }

    public static ArrayList<Worksheet> readWorksheet(){
        ArrayList<Worksheet> worksheetList = new ArrayList<Worksheet>();
        //READ FROM FILE



        return worksheetList;
    }


    private void readFileChild(){

    }

}
