package com.company;

import java.util.ArrayList;

public class WorkDay {
    //A WorkDay is assumed to be from 7:00-17:00, and is only splitted in full hours, meaning employees
    //will have to be scheduled for a minumum of one hour and any subsequent full hour.
    private ArrayList<WorkHour> workHours;
    private DailyManager dailyManager;
    private DailyOverview dailyOverview;

    public WorkDay(){
        //For now only 7:00-17:00 is workable hours, so hour at index 0 is hour 7-8, index 1 is 8-9.
        makeWorkHoursInADay();
        //Daily Manager assigned to this day is initially none, but should be set manually.

        dailyOverview = new DailyOverview();
    }


    public ArrayList<WorkHour> getWorkHours() {
        return workHours;
    }

    public void makeWorkHoursInADay(){
        workHours = new ArrayList<WorkHour>();
        for(int i=0; i<10; i++){
            WorkHour workhour = new WorkHour();
            workHours.add(workhour);
        }
    }

    public void setDailyManager(DailyManager dailyManager) {
        this.dailyManager = dailyManager;
    }




    public void clearWorkDay(){

    }
}
