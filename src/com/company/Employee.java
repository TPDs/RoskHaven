package com.company;

public class Employee extends User {
    public Employee(String name, String CPR, String password) {
        super("emp", name, CPR, password);
    }

    public Employee(String name, String CPR, String password, boolean readFromFile){
        super("emp", name, CPR, password, readFromFile);
    }
}
