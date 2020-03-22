package com.company;

import java.io.*;
import java.util.ArrayList;

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
    //adds a new child to queue list and then updates the file with the new info
    public void addChildToQueue(String name, String CPR, String note){
        Child child = new Child( name, CPR, note);
        childrenInQueue.add(child);

    }

    // this method moves child from queue list to active garten list and removes the child from queue list
    // in other words, it changes the status to active, then updates the child file
    public void addChildToGarten(String CPR) throws IOException {
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                childrenInQueue.get(i).setStatus(ChildStatus.ACTIVE);
                childrenInGarten.add(childrenInQueue.get(i));
                childrenInQueue.get(i).updateChildInFile();
                childrenInQueue.remove(i);
                break;

            }
        }
    }

    //this method removes the child from the active garten list
    //changes child status to passive and updates file
    public void removeChildFromGarten(String CPR) throws IOException {
        for(int i=0;i<childrenInGarten.size();i++){
            if(childrenInGarten.get(i).getCPR().equals(CPR)){
                childrenInGarten.get(i).setStatus(ChildStatus.PASSIVE);
                childrenInGarten.get(i).updateChildInFile();
                childrenInGarten.remove(i);
                break;
            }
        }
    }

    // this method removes the child from the que list and changes childstatus to passive
    //then updates file
    public void removeChildFromQueue(String CPR) throws IOException {
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                childrenInQueue.get(i).setStatus(ChildStatus.PASSIVE);
                childrenInQueue.get(i).updateChildInFile();
                childrenInQueue.remove(i);
                break;
            }
        }
    }

    //this method checks first if child status is passive and removes child, and then if age > 10 and removes
    //the child, it also changes status to passive if age > 10 and updates file.
    //this is to make sure that children aren't in the wrong list!
    public void updateChildQueue() throws IOException {
        for(int i=0; i<childrenInQueue.size(); i++){
            if(childrenInQueue.get(i).getStatus().equals(ChildStatus.PASSIVE)){
                childrenInQueue.remove(i);
            }
            if(childrenInQueue.get(i).calcAge()>10){
                childrenInQueue.get(i).setStatus(ChildStatus.PASSIVE);
                childrenInQueue.get(i).updateChildInFile();
                childrenInQueue.remove(i);

            }
        }
    }
}


