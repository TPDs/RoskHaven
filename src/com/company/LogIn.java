package com.company;

import java.util.ArrayList;

public class LogIn {
    ArrayList<Employee> employees;
    ArrayList<DailyManager> dailyManagers;
    Boss boss;

    public LogIn(InitiateArray ia){

    }

    public boolean logIn(String id, String password){
        boolean loginAttempt = false;

        if(id.equals(boss.getId())){
            loginAttempt = boss.login(password);
            return loginAttempt;
        }


        for(int i=0; i<dailyManagers.size(); i++){
            if(id.equals(dailyManagers.get(i).getId())){
                loginAttempt = dailyManagers.get(i).login(password);
                return loginAttempt;
            }
        }


        for(int i=0; i<employees.size(); i++){
            if(id.equals(employees.get(i).getId())){
                loginAttempt = employees.get(i).login(password);
                return loginAttempt;
            }
        }

        return loginAttempt;
    }
}
