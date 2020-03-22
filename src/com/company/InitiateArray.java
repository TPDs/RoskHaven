package com.company;

import java.util.ArrayList;

//
//
//Singleton class of all arrays to be used globally in the entire program.
//
//

public final class InitiateArray {

    private static InitiateArray instance = null;

    ArrayList<Employee> employeeList;
    ArrayList<DailyManager> dailyManagerList;
    Boss boss;

    ArrayList<Child> completeChildList;
    ArrayList<Child> childrenInGarten;
    ArrayList<Child> childrenInQueue;

    ArrayList<Worksheet> worksheetList;

    private InitiateArray(){

    }



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



    public void initiateBoss(){
        //dummy boss, needs to be read to make sense.
        Boss boss = new Boss("a", "b", "c");
        //READ FROM FILE
        this.boss = boss;
    }

    public void initiateEmployeeList(){
        ArrayList<Employee> empList = new ArrayList<Employee>();
        //READ FROM FILE
        this.employeeList = empList;
    }

    public void initiateDailyManagerList(){
        ArrayList<DailyManager> dmList = new ArrayList<DailyManager>();
        //READ FROM FILE
        this.dailyManagerList = dmList;
    }




    public void initiateChildList(){
        ArrayList<Child> childList = new ArrayList<Child>();
        //READ FROM FILE
        this.completeChildList = childList;
    }

    public void initiateChildrenInGarten(){
        ArrayList<Child> childrenInGarten = new ArrayList<Child>();
        for(int i=0; i<this.completeChildList.size(); i++){
            if(this.completeChildList.get(i).getStatus()==ChildStatus.ACTIVE){
                childrenInGarten.add(this.completeChildList.get(i));
            }
        }
        this.childrenInGarten = childrenInGarten;
    }

    public void initiateChildrenInQueue(){
        ArrayList<Child> childrenInQueue = new ArrayList<Child>();
        for(int i=0; i<this.completeChildList.size(); i++){
            if(this.completeChildList.get(i).getStatus()==ChildStatus.QUEUE){
                childrenInQueue.add(this.completeChildList.get(i));
            }
        }
        this.childrenInQueue = childrenInQueue;
    }




    public void initiateWorksheet(){
        ArrayList<Worksheet> worksheetList = new ArrayList<Worksheet>();
        //READ FROM FILE
        this.worksheetList = worksheetList;
    }

}
