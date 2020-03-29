package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Guardian implements ClassesToStoreInFiles {

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
        writeToFile();
    }

    public String getGName(){
        return name;
    }
    public String getMail(){
        return mail;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public void writeToFile() {

        try {
            FileWriter Guardianfw = new FileWriter("src/resourser/GuardianFile",true);
            String StringToFile = ""+ this.name + "BREAK" + this.mail + "BREAK" + this.phoneNumber + "BREAK" + this.address + "BREAK" + this.childCPR +"\n";
            Guardianfw.write(StringToFile);
            Guardianfw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}