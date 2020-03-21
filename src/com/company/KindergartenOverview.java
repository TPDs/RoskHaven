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

    public void addChildToQueue(String name, String CPR, String note){
        Child child = new Child( name, CPR, note);
        childrenInQueue.add(child);
    }

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

    //denne metode remover child men ikke fra en specifik liste. så vi skal evt lave en metode mere eller organisere aktiv / ikke aktiv liste
    public void removeChildFromGarten(String CPR){
        for(int i=0;i<childrenInGarten.size();i++){
            if(childrenInGarten.get(i).getCPR().equals(CPR)){
                childrenInGarten.get(i).setStatus(ChildStatus.PASSIVE);
                childrenInGarten.remove(i);
                break;
            }
        }
    }

    public void removeChildFromQueue(String CPR){
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                childrenInQueue.remove(i);
                break;
            }
        }
    }


    //Checks whether a child should still be in queue, or removed entirely due to reasons.
    //Reasons could be:     Age broke the upper boundary, Child is somehow passive but is not removed from list
    //
    public void updateChildQueue(){
        for(int i=0; i<childrenInQueue.size(); i++){
            //childrenInQueue.get(i)
        }
    }

    public ArrayList<Child> getChildrenInQueue() {
        return childrenInQueue;
    }
}
