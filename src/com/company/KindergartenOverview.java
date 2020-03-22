package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class KindergartenOverview {
    private ArrayList<Child> childrenInGarten;
    private ArrayList<Employee> employeesInGarten;
    private ArrayList<DailyManager> dailyManagersInGarten;
    private ArrayList<Child> childrenInQueue;
    //private ArrayList<Child> listOfShame;

    private ArrayList<Worksheet> worksheetList;

    public KindergartenOverview(InitiateArray allArrays){
        childrenInGarten = allArrays.childrenInGarten;
        employeesInGarten = allArrays.employeeList;
        dailyManagersInGarten = allArrays.dailyManagerList;
        childrenInQueue = allArrays.childrenInQueue;
        worksheetList = allArrays.worksheetList;
    }

    //this method is to add a new child to the queue list
    public void addChildToQueue(String name, String CPR, String note){
        Child child = new Child( name, CPR, note);
        childrenInQueue.add(child);
    }

    //
    // this method VIP need a funktionality that edit the child text file and changes status to active.
    //

    // this method moves child from queue list to garten list and removes the child from queue list
    public void addChildToGarten(String CPR){
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                childrenInGarten.add(childrenInQueue.get(i));
                childrenInQueue.get(i).setStatus(ChildStatus.ACTIVE);
                childrenInQueue.remove(i);
                break;
            }
        }
    }

    //
    //this method need a funktionality that edit the child status in the child file to passive
    //

    //this method removes the child from the active garten list
    public void removeChildFromGarten(String CPR) throws IOException {
        for(int i=0;i<childrenInGarten.size();i++){
            if(childrenInGarten.get(i).getCPR().equals(CPR)){
                childrenInGarten.get(i).setStatus(ChildStatus.PASSIVE);
                childrenInGarten.remove(i);
                break;
            }
        }
    }

    public static void deleteFromFile(ArrayList<String> ChildFile, String search) {

    }
    //
    //this method need a funktionality that removes the child from the text file aswell
    //

    // this method removes the child from the que list
    public void removeChildFromQueue(String CPR) throws IOException {
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                childrenInQueue.get(i).setStatus(ChildStatus.PASSIVE);
                childrenInQueue.remove(i);
                childrenInQueue.get(i).updateChildInFile();
                break;
            }
        }
    }

    //
    // this method need a funktionality that edit the child file and removes the child from the list
    //

    //this method checks first if child status is passive and removes child, and then if age > 10 and removes
    //this is to make sure that children aren't in the wrong list!
    public void updateChildQueue(){
        for(int i=0; i<childrenInQueue.size(); i++){
            if(childrenInQueue.get(i).getStatus().equals(ChildStatus.PASSIVE)){
                childrenInQueue.remove(i);
            }
            if(childrenInQueue.get(i).calcAge()>10){
            childrenInQueue.remove(i);
            }
        }
    }
}

//            File oldfile =new File("src/resourser/ChildFile");
//            oldfile.delete();
//            File newFile = new File("src/resourser/tempChildFile");
//            newFile.renameTo(src/resourser/ChildFile);

