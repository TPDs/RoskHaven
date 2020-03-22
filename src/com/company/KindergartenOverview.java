package com.company;

import java.util.ArrayList;

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

    // this method moves child from queue list to garten list and removes the child from que list
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

    //this method removes the child from the active garten list
    public void removeChildFromGarten(String CPR){
        for(int i=0;i<childrenInGarten.size();i++){
            if(childrenInGarten.get(i).getCPR().equals(CPR)){
                childrenInGarten.get(i).setStatus(ChildStatus.PASSIVE);
                childrenInGarten.remove(i);
                break;
            }
        }
    }

    // this method removes the child from the que list
    public void removeChildFromQueue(String CPR){
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                childrenInQueue.remove(i);
                break;
            }
        }
    }

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
