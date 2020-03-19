package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

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
                System.out.println("Are you sure that your want to add this child to the active Garten list?" + childrenInQueue.get(i) + " \n Push 1 for Yes, and something else for no");
                Scanner sc = new Scanner(System.in);
                int confirmAdd = sc.nextInt();
                if(confirmAdd==1){
                    childrenInGarten.add(childrenInQueue.get(i));
                    childrenInQueue.remove(i);
                }
                sc.close();
                break;
            }
        }
    }

// denne metode remover child men ikke fra en specifik liste. så vi skal evt lave en metode mere eller organisere aktiv / ikke aktiv liste
    public void removeChildFromGarten(String CPR){
        for(int i=0;i<childrenInGarten.size();i++){
            if(childrenInGarten.get(i).getCPR().equals(CPR)){
                System.out.println("Are you sure that you want to delete: " + childrenInGarten.get(i) + "\n Push 1 for Yes, and something else for no" );
                Scanner sc = new Scanner(System.in);
                int confirmDelete = sc.nextInt();
                if(confirmDelete==1){
                    childrenInGarten.remove(i);
                }
                sc.close();
                break;
            }
        }
    }

    public void removeChildFromQueue(String CPR){
        for(int i=0;i<childrenInQueue.size();i++){
            if(childrenInQueue.get(i).getCPR().equals(CPR)){
                System.out.println("Are you sure that you want to delete: " + childrenInGarten.get(i) + "\n Push 1 for Yes, and something else for no" );
                Scanner sc = new Scanner(System.in);
                int confirmDelete = sc.nextInt();
                if(confirmDelete==1){
                    childrenInQueue.remove(i);
                }
                sc.close();
                break;
            }
        }
    }
}
