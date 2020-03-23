package com.company;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args){
        LogIn login = new LogIn();
        KindergartenOverview ko = new KindergartenOverview();
        Gui gui = new Gui();
        gui.gui();

        LocalDateTime tempDateTime = LocalDateTime.now();
        System.out.println(tempDateTime);

        System.out.println(tempDateTime.getHour()+":"+tempDateTime.getMinute());
    }
}




//Skal lave en fil scanner som kan bruges til af instantiere de forskellige objekter
//skal lave en nogle metoder der kan læse linjer på filer og lave ændringer, så sætte dem ind i filen igen og slette den " læste linje"
//