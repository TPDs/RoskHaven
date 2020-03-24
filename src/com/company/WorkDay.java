package com.company;

import java.util.ArrayList;

public class WorkDay {
    //A WorkDay is assumed to be from 7:00-17:00, and is only splitted in full hours, meaning employees
    //will have to be scheduled for a minumum of one hour and any subsequent full hour.
    private ArrayList<WorkHour> workHours;
    private ArrayList<Employee> employeesScheduled;
    private DailyManager dailyManagerScheduled;
    private DailyOverview dailyOverview;

    public WorkDay(){
        //For now only 7:00-17:00 is workable hours, so hour at index 0 is hour 7-8, index 1 is 8-9.
        makeWorkHoursInADay();
        //Daily Manager assigned to this day is initially none, but should be set manually.

        employeesScheduled = new ArrayList<Employee>();
    }

    public ArrayList<WorkHour> getWorkHours() {
        return workHours;
    }




    //Ideally this is only called on the day (or maybe the day before). That way it's ensured that all scheduled employees are added automatically.
    //However, there are modification methods added to thet DailyOverview-class to changes to plans.
    public void makeDailyOverview(){
        dailyOverview = new DailyOverview(employeesScheduled, dailyManagerScheduled);
    }




    //Using the customized, but auto-generated (for now) by IntelliJ, .equals-method in User.
    public void addEmployeeToListOfScheduled(Employee employee){
        for(int i=0; i<employeesScheduled.size(); i++){
            if(employeesScheduled.get(i).equals(employee)){
                break;
            } else {
                employeesScheduled.add(employee);
            }
        }
    }




    public void makeWorkHoursInADay(){
        workHours = new ArrayList<WorkHour>();
        for(int i=0; i<10; i++){
            WorkHour workhour = new WorkHour();
            workHours.add(workhour);
        }
    }

    public void setDailyManagerScheduled(DailyManager dailyManagerScheduled) {
        this.dailyManagerScheduled = dailyManagerScheduled;
    }




    public void clearWorkDay(){

    }
}
