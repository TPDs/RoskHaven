package com.company;

import java.util.ArrayList;

public class Child implements ClassesToStoreInFiles {

    private String name;
    private String CPR;
    private ArrayList<Guardian> guardians;
    private String note;
    private ChildStatus status;

    // this constructor is for when new child objekts need's to be created.
    public Child(String name, String CPR, String note) {
        this.name = name;
        this.CPR = CPR;
        this.guardians = new ArrayList<Guardian>();
        this.note = note;
        this.status = ChildStatus.QUEUE;
    }

    // this constructor is for initiating Arrays when ready from file at the start of the program.
    public Child(String name, String CPR, String note, ChildStatus status) {
        this.name = name;
        this.CPR = CPR;
        this.guardians = new ArrayList<Guardian>();
        this.note = note;
        this.status = status;
    }

    public String getCPR() {
        return CPR;
    }

    public void addGuardian(String name, String mail,String phoneNumber){
        Guardian guardian = new Guardian(name, mail, phoneNumber);
        this.guardians.add(guardian);
    }


    @Override
    public void writeToFile() {
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", CPR='" + CPR + '\'' +
                ", guardians=" + guardians + "\n" +
                ", note='" + note + '\'' +
                ", status=" + status +
                '}';
    }
}

