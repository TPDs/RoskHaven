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

    public KindergartenOverview(){
        childrenInGarten = InitiateArray.getInstance().childrenInGarten;
        employeesInGarten = InitiateArray.getInstance().employeeList;
        dailyManagersInGarten = InitiateArray.getInstance().dailyManagerList;
        childrenInQueue = InitiateArray.getInstance().childrenInQueue;
        worksheetList = InitiateArray.getInstance().worksheetList;

    }

    //this method is to add a new child to the queue list
    public void addChildToQueue(String name, String CPR, String note){
        Child child = new Child( name, CPR, note);
        childrenInQueue.add(child);
    }

    //
    // this method VIP need a funktionality that edit the child text file and changes status to active.
    //

    // this method moves child from queue list to active garten list and removes the child from queue list
    // in other words, it changes the status to active, then updates the child file
    public void addChildToGarten(String CPR) throws IOException {
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
                editChildFile(CPR,ChildStatus.PASSIVE);
                break;
            }
        }
    }

    // this method removes the child from the que list and changes childstatus to passive
    //then updates file
    public void removeChildFromQueue(String CPR) throws IOException {
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                childrenInQueue.remove(i);
                editChildFile(CPR , ChildStatus.PASSIVE);
                break;
            }
        }
    }

    //
    // this method need a funktionality that edit the child file and removes the child from the list
    //

    //this method checks first if child status is passive and removes child, and then if age > 10 and removes
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


