package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       /* InitiateArray ia = new InitiateArray();
        LogIn login = new LogIn(ia);
        KindergartenOverview ko = new KindergartenOverview(ia);
    */  // ikke lave et push med code der ikke virker tak :)
        Gui gui = new Gui();
        gui.gui();

    }
}




//Skal lave en fil scanner som kan bruges til af instantiere de forskellige objekter
//skal lave en nogle metoder der kan læse linjer på filer og lave ændringer, så sætte dem ind i filen igen og slette den " læste linje"
//