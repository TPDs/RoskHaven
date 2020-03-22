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

    @Override
    public void writeToFile() {

        try {
            FileWriter Guardianfw = new FileWriter("src/resourser/GuardianFile");
            String StringToFile = ""+ this.name + "" + this.mail + "" + this.phoneNumber + "" + this.address + "\n";
            Guardianfw.write(StringToFile);
            Guardianfw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}