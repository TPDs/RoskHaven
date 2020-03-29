package com.company;

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

    // prøver at lave en generisk filereader metode. filepath er filens placering - CPR er det ønskede søgte CPR
    // CPR bruges til at modtage info fra den aktive liste så metoden kan bruges til Employee in garten now Arraylisten
//    private void readFileEmployee(String filePath, String Array) throws FileNotFoundException {
//        Scanner sc = new Scanner(filePath);
//
//        while(sc.hasNextLine()){
//            String iName = sc.next();
//            String iCPR = sc.next();
//            String iPW = sc.next();
//
//            Kindergarten.getInstance().getEmployeesInGarten().add(iName,iCPR,iPW);
//        }
//    }



    private void readFileChild(){

    }

}
