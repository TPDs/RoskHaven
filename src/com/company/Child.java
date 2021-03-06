package com.company;

import java.io.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

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
    public String getName(){
        return name;
    }

    public String getNote(){
        return note;
    }

    public ArrayList<Guardian> getGuardians() {
        return guardians;
    }

    public void setStatus(ChildStatus status){
        this.status = status;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ChildStatus getStatus() {
        return status;
    }

    //Adds a new guardian to the system and writes to file.
    public void addGuardian(String name, String mail, String phoneNumber, String address){
        Guardian guardian = new Guardian(name, mail, phoneNumber, address, this.CPR);
        this.guardians.add(guardian);
        guardian.writeToFile();
    }

    //Adds a guardian-object when reading from file.
    public void addGuardian(String guardianID, String name, String mail, String phoneNumber, String address){
        Guardian guardian = new Guardian(guardianID, name, mail, phoneNumber, address,this.CPR);
        this.guardians.add(guardian);
    }


    public void editGuardian(String guardianID, String newName, String newMail, String newPhoneNumber, String newAddress){
        for(int i=0; i<guardians.size(); i++){
            if(guardians.get(i).getGuardianID().equals(guardianID)){
                guardians.get(i).setName(newName);
                guardians.get(i).setMail(newMail);
                guardians.get(i).setPhoneNumber(newPhoneNumber);
                guardians.get(i).setAddress(newAddress);

            }
        }
        updateGuardian();
    }

    public void deleteGuardian(String ID){
        for(int i=0;i<guardians.size();i++){
            if(guardians.get(i).getGuardianID().equals(ID)){
                guardians.remove(i);
                updateGuardian();
            }
        }
    }

    // bare gennemgå objekterne guardian og skriv dem til filen. " husk at slette filen først.
    // en fejl ved denne måde at lave en file override / update på et hvis programmet går ned efter filen med guardians bliver slettet
    //så kan informationen om guardians gå tabt

    public void updateGuardian(){

        try {
            FileWriter deletefw= new FileWriter("src/resourser/GuardianFile");
            String delete = "";
            deletefw.write(delete);

        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter tempGuardianfw = null;
        try {
            tempGuardianfw = new FileWriter("src/resourser/GuardianFile",true);
            ArrayList<Child> allChildren = Kindergarten.getInstance().getAllChildren();
            for(int j=0; j<allChildren.size(); j++){
                for(int i =0;i<guardians.size();i++){
                    String strToAdd = allChildren.get(j).guardians.get(i).getGuardianID() + "BREAK" + guardians.get(i).getName() +"BREAK"+ guardians.get(i).getMail() +"BREAK"+ guardians.get(i).getPhoneNumber()+"BREAK"+ guardians.get(i).getAddress()+"BREAK"+ CPR + "\n";
                    tempGuardianfw.write(strToAdd);
                }
            }
            tempGuardianfw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

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

        int childCenturyMinus100 = ((yearOfToday%100)*100+childYear)-100;
        int childCenturyAsIs = (yearOfToday%100)*100+childYear;

        LocalDate secondBirthday = LocalDate.of(childCenturyMinus100, childMonth, childDay);
        LocalDate thirdBirthday = LocalDate.of(childCenturyAsIs, childMonth, childDay);

        Period p0 = Period.between(secondBirthday, today);
        Period p1 = Period.between(thirdBirthday, today);

        if(p0.getYears() < 0){
            return p1.getYears();
        } else if (p0.getYears() < 100){
            return p0.getYears();
        } else {
            return p1.getYears();
        }
    }

    // skriver de ønskede informationer omkring objektet ind i den nuværende fil placering
    @Override
    public void writeToFile(){

        try {
            FileWriter Childqueuefw = new FileWriter("src/resourser/ChildFile",true);
            String StringToFile = ""+ this.name + "BREAK" + this.CPR + "BREAK" + this.note + "BREAK" + this.status + "\n";
            Childqueuefw.write(StringToFile);
            Childqueuefw.close();
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateChildInFile()throws IOException{

            // lave en metode der iterere gennem child filen og sletter child med cpr nummer som matcher.
            Scanner data = new Scanner(new File("src/resourser/ChildFile")).useDelimiter("\\s*BREAK\\s*");
            FileWriter tempChildqueuefw = new FileWriter("src/resourser/tempChildFile",true);
            // her skrives data med ændringer i temp child file
            while(data.hasNextLine()){
                    String tempString =data.nextLine();
                    if(tempString.contains(CPR)){

                        String tempStringFileChange = this.name +"BREAK"+ this.CPR + "BREAK" + this.note +"BREAK" + this.status + "\n";
                        tempChildqueuefw.write(tempStringFileChange);
                    }
                    else{
                        String tempStringToFile = tempString + "\n";
                        tempChildqueuefw.write(tempStringToFile);
                    }

            }
        tempChildqueuefw.close();
                    //her slettes indholdet af child file
                    FileWriter deletefw = new FileWriter("src/resourser/ChildFile");
                    String delete = "";
                    deletefw.write(delete);
                    deletefw.close();

                    // her overskrives så childfile med tempChildFile "som er den ændrede information"
                    Scanner sc = new Scanner(new File("src/resourser/tempChildFile")).useDelimiter("\\s*BREAK\\s*");
                    FileWriter tempFilefw = new FileWriter("src/resourser/ChildFile",true);
                    while(sc.hasNextLine()){
                        String overrideText = sc.nextLine() + "\n";
                        tempFilefw.write(overrideText);
                    }
                    tempFilefw.close();

                //her slettes indholdet af tempchild file
                FileWriter deletefw2 = new FileWriter("src/resourser/tempChildFile");
                deletefw2.write(delete);
                deletefw2.close();

    }


    @Override
    public String toString() {
        return name + CPR;
    }
}

