package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


//
//
//This class is made Singleton, because there should only ever be one instance of it. It contains
//all lists and methods with connectivity to all of the program's core functionalities.
//
//
public class Kindergarten {
    private static Kindergarten instance = null;

    private ArrayList<Child> allChildren;

    private ArrayList<Child> childrenInGarten;
    private ArrayList<Employee> employeesInGarten;
    private ArrayList<DailyManager> dailyManagersInGarten;
    private LinkedList<Child> childrenInQueue;
    //private ArrayList<Child> listOfShame;

    private Boss boss;

    private ArrayList<Worksheet> worksheetList;

    private Kindergarten(){
        //Empty constructor
    }

    public static Kindergarten getInstance(){
        if(instance == null){
            instance = new Kindergarten();
            instance.makeAttributeArrays();
        }
        return instance;
    }

    public void makeAttributeArrays(){
        boss = ReadWriteFileUtil.readBoss();

        allChildren = ReadWriteFileUtil.readChildList();

        childrenInGarten = findChildrenInGarten();
        childrenInQueue = findChildrenInQueue();

        employeesInGarten = ReadWriteFileUtil.readEmployeeList();
        dailyManagersInGarten = ReadWriteFileUtil.readDailyManagerList();

        worksheetList = ReadWriteFileUtil.readWorksheet();
    }

    public ArrayList<Child> findChildrenInGarten(){
        ArrayList<Child> childrenInGarten = new ArrayList<Child>();
        for(int i=0; i<allChildren.size(); i++){
            if(allChildren.get(i).getStatus()==ChildStatus.ACTIVE){
                childrenInGarten.add(allChildren.get(i));
            }
        }
        return childrenInGarten;
    }

    public LinkedList<Child> findChildrenInQueue(){
        LinkedList<Child> childrenInQueue = new LinkedList<>();
        for(int i=0; i<allChildren.size(); i++){
            if(allChildren.get(i).getStatus()==ChildStatus.QUEUE){
                childrenInQueue.add(allChildren.get(i));
            }
        }
        return childrenInQueue;
    }

    public ArrayList<Child> getChildrenInGarten() {
        return childrenInGarten;
    }

    public ArrayList<Employee> getEmployeesInGarten() {
        return employeesInGarten;
    }

    public ArrayList<Worksheet> getWorksheetList() {
        return worksheetList;
    }

    public ArrayList<DailyManager> getDailyManagersInGarten() {
        return dailyManagersInGarten;
    }

    public Boss getBoss() {
        return boss;
    }

    public ArrayList<Child> getAllChildren() {
        return allChildren;
    }

    // denne midlertidige boss setter skal slettes.! husk daniel på det når han glemmer det.!
    public void setBoss(Boss boss) {
        this.boss = boss;
    }


    public Child searchAndFindChild(String CPR){
        Child child = null;
        for(int i=0; i<allChildren.size(); i++){
            if(allChildren.get(i).getCPR().equals(CPR)){
                child = allChildren.get(i);
                break;
            }
        }
        return child;
    }


    //this method is to add a new child to the queue list
    //adds a new child to queue list and then updates the file with the new info
    public Child addChildToQueue(String name, String CPR, String note){
        Child child = new Child( name, CPR, note);
        childrenInQueue.add(child);
        allChildren.add(child);
        return child;
    }


    // this method moves child from queue list to active garten list and removes the child from queue list
    // in other words, it changes the status to active, then updates the child file
    public void addChildToGarten(String CPR)  {
        if(childrenInQueue.size()==0){
            System.out.println("The queue is empty.");
        } else {
            Child child = childrenInQueue.pop();
            childrenInGarten.add(child);
            try {
                child.updateChildInFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //this method removes the child from the active garten list
    //changes child status to passive and updates file
    public void removeChildFromGarten(String CPR){
        for(int i=0;i<childrenInGarten.size();i++){
            if(childrenInGarten.get(i).getCPR().equals(CPR)){
                childrenInGarten.get(i).setStatus(ChildStatus.PASSIVE);
                try {
                    childrenInGarten.get(i).updateChildInFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                childrenInGarten.remove(i);
                break;
            }
        }
    }

    // this method removes the child from the que list and changes childstatus to passive
    //then updates file
    public void removeChildFromQueue(String CPR){
        for(int i=0; i<allChildren.size(); i++){
            if(allChildren.get(i).getCPR().equals(CPR)){
                Child child = allChildren.get(i);
                childrenInQueue.remove(child);
                child.setStatus(ChildStatus.PASSIVE);

                try {
                    child.updateChildInFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            }
        }
    }

    //this method checks first if child status is passive and removes child, and then if age > 10 and removes
    //the child, it also changes status to passive if age > 10 and updates file.
    //this is to make sure that children aren't in the wrong list!
    public void updateChildQueue(){
        for(int i=0; i<childrenInQueue.size(); i++){
            if(childrenInQueue.get(i).getStatus().equals(ChildStatus.PASSIVE)){
                childrenInQueue.remove(i);
            }
            if(childrenInQueue.get(i).calcAge()>10){
                childrenInQueue.get(i).setStatus(ChildStatus.PASSIVE);
                try {
                    childrenInQueue.get(i).updateChildInFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                childrenInQueue.remove(i);

            }
        }
    }


    //Creates a new worksheet for a month and year of the user's choice.
    public void createNewWorksheet(int year, int month){
        //check whether the worksheet for the desired month already exists.
        String newID = "Y" + year + "M" + month;
        boolean flag = false;
        for(int i=0; i<worksheetList.size(); i++){
            if(worksheetList.get(i).getWorkSheetID().equals(newID)){
                flag = true;
                break;
            }
        }
        if(!flag){
            worksheetList.add(new Worksheet(year, month));
        }
    }

    public Worksheet findWorksheet(int year, int month){
        Worksheet worksheet = null;
        for(int i=0; i<worksheetList.size(); i++){
            if(worksheetList.get(i).getYear()==year && worksheetList.get(i).getMonth()==month){
                worksheet = worksheetList.get(i);
                break;
            }
        }
        return worksheet;
    }
}