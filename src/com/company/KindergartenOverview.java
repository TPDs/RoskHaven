package com.company;

import java.util.ArrayList;

public class KindergartenOverview {
    private ArrayList<Child> childrenInGarten;
    private ArrayList<Employee> employeesInGarten;
    private ArrayList<DailyManager> dailyManagersInGarten;
    private ArrayList<Child> childrenInQueue;

    public KindergartenOverview(ArrayList<Child> childrenInGarten, ArrayList<Employee> employeesInGarten, ArrayList<DailyManager> dailyManagersInGarten,ArrayList<Child> childrenInQueue){
        this.childrenInGarten = childrenInGarten;
        this.employeesInGarten= employeesInGarten;
        this.dailyManagersInGarten = dailyManagersInGarten;
        this.childrenInQueue = childrenInQueue;
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
}
