package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WorkHour implements ClassesToStoreInFiles {
    private ArrayList<Employee> employeeAtWork;
    int hour;

    public WorkHour(int hour){
        //Initially the arraylist is empty, but they will be added manually over time.
        employeeAtWork = new ArrayList<Employee>();
        this.hour = hour;
        writeToFile();
    }

    public ArrayList<Employee> getEmployeeAtWork() {
        return employeeAtWork;
    }


    @Override
    public void writeToFile() {
        try {
            FileWriter initWriteToWorksheet = new FileWriter("src/resourser/WorkSheetFile", true);
            String idLine = "\n" + hour + "[";
            for(int i=0; i<employeeAtWork.size(); i++){
                 idLine += employeeAtWork.get(i).getCPR() + ",";
            }
            idLine += "]";
            initWriteToWorksheet.write(idLine);
            initWriteToWorksheet.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
