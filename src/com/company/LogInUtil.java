package com.company;

import java.util.ArrayList;

public class LogInUtil {

    private LogInUtil(){

    }

    public boolean logIn(String id, String password){
        Boss boss = Kindergarten.getInstance().getBoss();
        if(id.equals(boss.getCPR())){
            return boss.login(password);
        }

        ArrayList<DailyManager> dailyManagers = Kindergarten.getInstance().getDailyManagersInGarten();
        for(int i=0; i<dailyManagers.size(); i++){
            if(id.equals(dailyManagers.get(i).getCPR())){
                return dailyManagers.get(i).login(password);
            }
        }

        ArrayList<Employee> employees = Kindergarten.getInstance().getEmployeesInGarten();
        for(int i=0; i<employees.size(); i++){
            if(id.equals(employees.get(i).getCPR())){
                return employees.get(i).login(password);
            }
        }

        return false;
    }
}
