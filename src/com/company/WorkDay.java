package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WorkDay implements ClassesToStoreInFiles {
    //A WorkDay is assumed to be from 7:00-17:00, and is only splitted in full hours, meaning employees
    //will have to be scheduled for a minumum of one hour and any subsequent full hour.
    private int dayOfMonth;
    private ArrayList<WorkHour> workHours;
    private DailyOverview dailyOverview;

    public WorkDay(String worksheetID, int dayOfMonth){
        //For now only 7:00-17:00 is workable hours, so hour at index 0 is hour 7-8, index 1 is 8-9.
        this.dayOfMonth = dayOfMonth;

        dailyOverview = new DailyOverview(worksheetID, dayOfMonth);
        writeToFile();
        makeWorkHoursInADay();

    }

    public ArrayList<WorkHour> getWorkHours() {
        return workHours;
    }

    public DailyOverview getDailyOverview() {
        return dailyOverview;
    }


    public void makeWorkHoursInADay(){
        workHours = new ArrayList<WorkHour>();
        for(int i=0; i<10; i++){
            WorkHour workhour = new WorkHour(i+7);
            workHours.add(workhour);
        }
    }

    public void clearWorkDay(){

    }


    @Override
    public void writeToFile() {
        try {
            FileWriter initWriteToWorksheet = new FileWriter("src/resourser/WorkSheetFile", true);
            String idLine = "\n" + dailyOverview.getDailyOverViewID() + " ";
            initWriteToWorksheet.write(idLine);
            initWriteToWorksheet.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return dailyOverview.getDailyOverViewID();
    }
}
