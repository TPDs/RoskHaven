package com.company;

public class DailyManager extends User {
    public DailyManager(String name, String CPR, String password) {
        super("dm", name, CPR, password);
    }

    public DailyManager(String name, String CPR, String password, boolean readFromFile){
        super("dm", name,CPR,password,readFromFile);
    }
}

/*
* Hours: Double
* Salery : Double
* MaxHours: Double
* phoneNumber: int
*
* getChildInfo()
* getContactInfo()
* ContactGuardian()*/