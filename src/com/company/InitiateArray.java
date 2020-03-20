package com.company;

import java.util.ArrayList;

public class InitiateArray {
    ArrayList<Employee> employeeList;
    ArrayList<DailyManager> dailyManagerList;
    Boss boss;

    ArrayList<Child> completeChildList;
    ArrayList<Child> childrenInGarten;
    ArrayList<Child> childrenInQueue;

    ArrayList<Worksheet> worksheetList;

    public InitiateArray(){
        employeeList = initiateEmployeeList();
        dailyManagerList = initiateDailyManagerList();
        boss = initiateBoss();

        completeChildList = initiateChildList();
        childrenInGarten = initiateChildrenInGarten(completeChildList);
        childrenInQueue = initiateChildrenInQueue(completeChildList);

        worksheetList = initiateWorksheet();
    }

    public Boss initiateBoss(){
        //dummy boss, needs to be read to make sense.
        Boss boss = new Boss("a", "b", "c");
        //READ FROM FILE
        return boss;
    }

    public ArrayList<Employee> initiateEmployeeList(){
        ArrayList<Employee> empList = new ArrayList<Employee>();
        //READ FROM FILE
        return empList;
    }

    public ArrayList<DailyManager> initiateDailyManagerList(){
        ArrayList<DailyManager> dmList = new ArrayList<DailyManager>();
        //READ FROM FILE
        return dmList;
    }




    public ArrayList<Child> initiateChildList(){
        ArrayList<Child> childList = new ArrayList<Child>();
        //READ FROM FILE
        return childList;
    }

    public ArrayList<Child> initiateChildrenInGarten(ArrayList<Child> completeChildList){
        ArrayList<Child> childrenInGarten = new ArrayList<Child>();
        for(int i=0; i<completeChildList.size(); i++){
            if(completeChildList.get(i).getStatus()==ChildStatus.ACTIVE){
                childrenInGarten.add(completeChildList.get(i));
            }
        }
        return childrenInGarten;
    }

    public ArrayList<Child> initiateChildrenInQueue(ArrayList<Child> completeChildList){
        ArrayList<Child> childrenInQueue = new ArrayList<Child>();
        for(int i=0; i<completeChildList.size(); i++){
            if(completeChildList.get(i).getStatus()==ChildStatus.QUEUE){
                childrenInQueue.add(completeChildList.get(i));
            }
        }
        return childrenInQueue;
    }




    public ArrayList<Worksheet> initiateWorksheet(){
        ArrayList<Worksheet> worksheetList = new ArrayList<Worksheet>();
        //READ FROM FILE
        return worksheetList;
    }

}
