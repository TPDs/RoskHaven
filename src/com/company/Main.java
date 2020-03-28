package com.company;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    // husk at slette IOException når dummy data bliver slettet.
    public static void main(String[] args) throws IOException {
        Gui gui = new Gui();
        gui.gui();



        // dummy data til test af funktionaliteter i DailyOverview classen

        Child child = new Child("Cirkeline","030503-2451","hun spiser ikke kartofler om onsdagen",ChildStatus.ACTIVE);
        Child child1 = new Child("Hansi","032332-2451","hun spiser ikke kartofler om onsdagen",ChildStatus.ACTIVE);
        Child child2 = new Child("Gurgemau","031231-2453","hun spiser ikke kartofler om onsdagen",ChildStatus.ACTIVE);

        Kindergarten.getInstance().getChildrenInGarten().add(child);
        Kindergarten.getInstance().getChildrenInGarten().add(child1);
        Kindergarten.getInstance().getChildrenInGarten().add(child2);

        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Søren", "020202","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Ulla", "030303","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Faisal", "040404","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Kian", "050505","1234" ));

        DailyManager dailyManager = new DailyManager("ManaWar", "2222","4321" );
        DailyOverview dailyOverview = new DailyOverview(Kindergarten.getInstance().getEmployeesInGarten(),dailyManager);
        dailyOverview.childCheckIn("030503-2451");
        dailyOverview.childCheckIn("032332-2451");
        dailyOverview.childCheckIn("031231-2453");

       dailyOverview.employeeCheckIn("020202");
       dailyOverview.employeeCheckIn("030303");
       dailyOverview.employeeCheckIn("040404");
       dailyOverview.employeeCheckIn("050505");


        System.out.println(child2.getCPR());
        System.out.println(child2.getStatus());

        System.out.println(Kindergarten.getInstance().getEmployeesInGarten().get(2).getCPR());


        // vi kan pludselig ikke printe en listo over daily overwiev ud det skal kigges på ?
        // System.out.println(dailyOverview.showDailyOverview());

        dailyOverview.employeeCheckOut("050505");
        dailyOverview.childCheckOut("031231-2453");
    }
}

//Skal lave en fil scanner som kan bruges til af instantiere de forskellige objekter
//skal lave en nogle metoder der kan læse linjer på filer og lave ændringer, så sætte dem ind i filen igen og slette den " læste linje"
//