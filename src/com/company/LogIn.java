package com.company;

import java.util.ArrayList;

public class LogIn {
    ArrayList<Employee> employees;
    ArrayList<DailyManager> dailyManagers;
    Boss boss;

    public LogIn(){
        employees = InitiateArray.getInstance().employeeList;
        dailyManagers = InitiateArray.getInstance().dailyManagerList;
        boss = InitiateArray.getInstance().boss;
    }

    public boolean logIn(String id, String password){
        if(id.equals(boss.getId())){
            return boss.login(password);
        }

        for(int i=0; i<dailyManagers.size(); i++){
            if(id.equals(dailyManagers.get(i).getId())){
                return dailyManagers.get(i).login(password);
            }
        }

        for(int i=0; i<employees.size(); i++){
            if(id.equals(employees.get(i).getId())){
                return employees.get(i).login(password);
            }
        }

        return false;
    }
}
