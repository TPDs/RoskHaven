package com.company;

import java.util.Scanner;

public class User implements ClassesToStoreInFiles{
    private String name;
    private String id;
    private String password;

    public boolean login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast venligst password: ");
        String passwordInput = sc.nextLine();
        return passwordInput.equals(this.password);
    }


    public String getId() {
        return id;
    }

    @Override
    public void writeToFile() {

    }
}
