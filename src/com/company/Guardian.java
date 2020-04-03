package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Guardian implements ClassesToStoreInFiles {
    private String guardianID;
    private String name;
    private String mail;
    private String phoneNumber;
    private String address;
    private String childCPR;

    public Guardian(String name, String mail, String phoneNumber, String address, String childCPR){
        this.name=name;
        this.mail=mail;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.childCPR=childCPR;
        this.guardianID = makeGuardianID();
    }

    //Constructor used when reading files.
    public Guardian(String guardianID, String name, String mail, String phoneNumber, String address, String childCPR){
        this.guardianID = guardianID;
        this.name=name;
        this.mail=mail;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.childCPR=childCPR;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGuardianID() {
        return guardianID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String makeGuardianID(){
        ArrayList<Child> allChildren = Kindergarten.getInstance().getAllChildren();
        String id = this.childCPR + "G";
        for(int i=0; i<allChildren.size(); i++){
            if(childCPR.equals(allChildren.get(i).getCPR())){
                id += allChildren.get(i).getGuardians().size();
                break;
            }
        }
        return id;
    }


    @Override
    public void writeToFile() {

        try {
            FileWriter Guardianfw = new FileWriter("src/resourser/GuardianFile",true);
            String StringToFile = ""+ this.guardianID + "BREAK" + this.name + "BREAK" + this.mail + "BREAK" + this.phoneNumber + "BREAK" + this.address + "BREAK" + this.childCPR +"\n";
            Guardianfw.write(StringToFile);
            Guardianfw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}