package com.company;

import java.util.ArrayList;

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

    /*
    private static InitiateArray instance = null;

    ArrayList<Employee> employeeList;
    ArrayList<DailyManager> dailyManagerList;
    Boss boss;

    ArrayList<Child> completeChildList;
    ArrayList<Child> childrenInGarten;
    ArrayList<Child> childrenInQueue;

    ArrayList<Worksheet> worksheetList;
    */

    private ReadFileUtil(){

    }


    /*
    public static InitiateArray getInstance(){
        if(instance == null){
            instance = new InitiateArray();
            instance.makeAllArrays();
        }
        return instance;
    }

    public void makeAllArrays(){
        initiateBoss();
        initiateEmployeeList();
        initiateDailyManagerList();
        initiateChildList();
        initiateChildrenInQueue();
        initiateChildrenInGarten();
        initiateWorksheet();
    }
    */



    public static Boss readBoss(){
        //dummy boss, needs to be read to make sense.
        Boss boss = new Boss("a", "b", "c");
        //READ FROM FILE
        return boss;
    }

    public static ArrayList<Employee> readEmployeeList(){
        ArrayList<Employee> empList = new ArrayList<Employee>();
        //READ FROM FILE
        return empList;
    }

    public static ArrayList<DailyManager> readDailyManagerList(){
        ArrayList<DailyManager> dmList = new ArrayList<DailyManager>();
        //READ FROM FILE
        return dmList;
    }

    public static ArrayList<Child> readChildList(){
        ArrayList<Child> childList = new ArrayList<Child>();
        //READ FROM FILE
        return childList;
    }

    public static ArrayList<Worksheet> readWorksheet(){
        ArrayList<Worksheet> worksheetList = new ArrayList<Worksheet>();
        //READ FROM FILE
        return worksheetList;
    }
}
