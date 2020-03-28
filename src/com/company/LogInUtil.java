package com.company;

import java.util.ArrayList;

public class LogInUtil {

    private LogInUtil(){

    }

    public static boolean bossLogIn(String CPR, String password) {
        Boss boss = Kindergarten.getInstance().getBoss();
        if (CPR.equals(boss.getCPR())) {
            return boss.login(password);
        }
        return false;
    }

    public static boolean dmLogIn(String CPR, String password) {
        ArrayList<DailyManager> dailyManagers = Kindergarten.getInstance().getDailyManagersInGarten();
        for (int i = 0; i < dailyManagers.size(); i++) {
            if (CPR.equals(dailyManagers.get(i).getCPR())) {
                return dailyManagers.get(i).login(password);
            }
        }
        return false;
    }

    public static boolean empLogIn(String CPR, String password){
        ArrayList<Employee> employees = Kindergarten.getInstance().getEmployeesInGarten();
        for(int i=0; i<employees.size(); i++){
            if(CPR.equals(employees.get(i).getCPR())){
                return employees.get(i).login(password);
            }
        }
        return false;
    }
}
