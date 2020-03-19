package com.company;

public class Guardian implements ClassesToStoreInFiles {

    private String name;
    private String mail;
    private String phoneNumber;

    public Guardian( String name, String mail, String phoneNumber){
        this.name=name;
        this.mail=mail;
        this.phoneNumber=phoneNumber;
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