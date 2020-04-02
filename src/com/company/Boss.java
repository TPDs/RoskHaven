package com.company;

public class Boss extends User {


    public Boss(String name, String id, String password) {
        super("b", name, id, password);
    }

    public Boss(String name, String id, String password, boolean readFromFile){
        super("b", name, id, password, readFromFile);
    }
}

// måske skal der være en create id metode " skal bruges til at oprette et id til medarbejdere når de bliver oprettet
// i systemet