package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Child implements ClassesToStoreInFiles {

    private String name;
    private String CPR;
    private ArrayList<Guardian> guardians;
    private String note;
    private ChildStatus status;

    // this constructor is for when new child objects needs to be created.
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

    public void setStatus(ChildStatus status){
        this.status = status;
    }

    public ChildStatus getStatus() {
        return status;
    }

    public void addGuardian(String name, String mail, String phoneNumber, String address){
        Guardian guardian = new Guardian(name, mail, phoneNumber, address);
        this.guardians.add(guardian);
    }

    public int calcAge(){
        CPR.substring(0,6);

        LocalDate today = LocalDate.now();

        int childDay = Integer.parseInt(CPR.substring(0,2));
        int childMonth = Integer.parseInt(CPR.substring(2,4));
        int childYear = Integer.parseInt(CPR.substring(4,6));

        int yearOfToday = today.getYear();

        //This handles possible Y2K-problems, where an age spans over two centuries. The possible age
        //that is lower than 10 years is chosen. The reasoning is that no child above 10 years should
        //be in this kindergarten.

        int childCenturyPlus100 = ((yearOfToday+100)%100)*100+childYear;
        int childCenturyMinus100 = ((yearOfToday-100)%100)*100+childYear;
        int childCenturyAsIs = (yearOfToday%100)*100+childYear;

        LocalDate firstBirthday = LocalDate.of(childCenturyPlus100, childMonth, childDay);
        LocalDate secondBirthday = LocalDate.of(childCenturyMinus100, childMonth, childDay);
        LocalDate thirdBirthday = LocalDate.of(childCenturyAsIs, childMonth, childDay);

        Period p0 = Period.between(firstBirthday, today);
        Period p1 = Period.between(secondBirthday, today);
        Period p2 = Period.between(thirdBirthday, today);

        if(p0.getYears() < 10){
            return p0.getYears();
        } else if(p1.getYears()< 10){
            return p1.getYears();
        } else {
            return p2.getYears();
        }
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

