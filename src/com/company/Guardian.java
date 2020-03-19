package com.company;

public class Guardian implements ClassesToStoreInFiles {

    private String name;
    private String mail;
    private String phoneNumber;
    private String address;

    public Guardian(String name, String mail, String phoneNumber, String address){
        this.name=name;
        this.mail=mail;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    @Override
    public void writeToFile() {

    }
}

/*
* Name: String
* Child:class<child>
* Mail:String
* PhoneNumber;int
* */