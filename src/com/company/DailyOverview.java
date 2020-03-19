package com.company;

import java.util.ArrayList;

public class DailyOverview implements ClassesToStoreInFiles{
    private ArrayList<Child> childrenInGartenToday;
    private ArrayList<Employee> employeesInGartenToday;
    private DailyManager dailyManagerInGartenToday;

    //Initially there is no children in garten, they will all be checked in when they arrive
    //and checked out when they leave.

    //The specific employees and daily manager at work today will be determined by the worksheet,
    //and directly imported from there, i. e. no input needed when instantiating this object.

    public DailyOverview(){
        childrenInGartenToday = new ArrayList<Child>();
        employeesInGartenToday = importEmployeesFromWorksheet();
        dailyManagerInGartenToday = importDailyManagerFromWorksheet();
    }


    //
    //
    //THESE TWO WILL NEED TO BE FINISHED AT A LATER POINT, WHERE WORKSHEET IS DONE.
    //
    //

    public ArrayList<Employee> importEmployeesFromWorksheet(){
        return new ArrayList<Employee>();
    }

    public DailyManager importDailyManagerFromWorksheet(){
        return new DailyManager();
    }






    public void childCheckIn(Child child){
        childrenInGartenToday.add(child);
    }

    public void childCheckOut(Child child){
        for(int i=0; i<childrenInGartenToday.size(); i++){
            if(childrenInGartenToday.get(i).getCPR().equals(child.getCPR())){
                childrenInGartenToday.remove(i);
                break;
            }
        }
    }

    public void employeeCheckIn(Employee employee){
        employeesInGartenToday.add(employee);
    }

    public void employeeCheckOut(Employee employee){
        for(int i=0; i<employeesInGartenToday.size(); i++){
            if(employeesInGartenToday.get(i).getId().equals(employee.getId())){
                employeesInGartenToday.remove(i);
                break;
            }
        }
    }

    public void dailyManagerCheckIn(DailyManager dm){
        dailyManagerInGartenToday = dm;
    }

    public void dailyManagerCheckOut(){
        dailyManagerInGartenToday = null;
    }






    @Override
    public void writeToFile() {

    }


    @Override
    public String toString() {
        return "DailyOverview{" +
                "Children still in kindergarten: " + childrenInGartenToday + "\n\n" +
                "Employees still on work: " + employeesInGartenToday + "\n\n" +
                "Daily Manager still: " + dailyManagerInGartenToday +
                '}';
    }
}
/*
* EmployeeList: ArrayList
* ChildPresent: Arraylist
*
* ChildChekin()
* ChildChekcOut()
* EmployeeCheckout()
* EmployeeCheckin()*/