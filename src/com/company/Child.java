package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

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
        writeToFile();
    }

    // this constructor is for initiating Arrays when reading from file at the start of the program.
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
        Guardian guardian = new Guardian(name, mail, phoneNumber, address,this.CPR);
        this.guardians.add(guardian);
    }




    public void removeGuardian(){

    }





    public int calcAge(){
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

    // skriver de ønskede informationer omkring objektet ind i den nuværende fil placering
    @Override
    public void writeToFile(){

        try {
            FileWriter Childqueuefw = new FileWriter("src/resourser/ChildFile");
            String StringToFile = ""+ this.name + " " + this.CPR + " " + this.note + " " + this.status + "\n";
            Childqueuefw.write(StringToFile);
            Childqueuefw.close();
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateChildInFile()throws IOException{

            // lave en metode der iterere gennem child filen og sletter child med cpr nummer som matcher.
            Scanner data = new Scanner("src/resourser/ChildFile");
            if(data.hasNextLine()){
                for(int j = 0; data.hasNextLine();j++){
                    if(data.nextLine().contains(CPR)){

                        String tempStringFileChange = this.name +" "+ this.CPR + " " + this.note +" " + this.status + "\n";
                        FileWriter tempChildqueuefw = new FileWriter(new File("src/resourser/tempChildFile"));
                        tempChildqueuefw.write(tempStringFileChange);
                        tempChildqueuefw.close();
                    }
                    else{
                        FileWriter tempChildqueuefw = new FileWriter(new File("src/resourser/tempChildFile"));
                        String tempStringToFile = data.nextLine() + "\n";
                        tempChildqueuefw.write(tempStringToFile);
                        tempChildqueuefw.close();
                    }
                }// her overskrives så childfile med tempChildFile "som er den ændrede information"

                Path source = Paths.get("src/resourser/tempChildFile");
                Path newdir = Paths.get("src/resourser/ChildFile");
                Files.move(source, newdir.resolve(source.getFileName()), REPLACE_EXISTING);
            }
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

