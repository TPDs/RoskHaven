package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // husk at slette IOException når dummy data bliver slettet.
    public static void main(String[] args) throws IOException {
        Gui gui = new Gui();
        gui.gui();


        // dummy data til test af funktionaliteter i DailyOverview classen

        Child child = new Child("Cirkeline","030503-2451","hun spiser ikke kartofler om onsdagen",ChildStatus.ACTIVE);
        Child child1 = new Child("Hansi","032332-2451","hun spiser ikke kartofler om onsdagen",ChildStatus.ACTIVE);
        Child child2 = new Child("Gurgemau","031231-2453","hun spiser ikke kartofler om onsdagen",ChildStatus.ACTIVE);

        child.addGuardian("As", "as@mail.dk", "22222222", "As,2. st");

        Kindergarten.getInstance().getChildrenInGarten().add(child);
        Kindergarten.getInstance().getChildrenInGarten().add(child1);
        Kindergarten.getInstance().getChildrenInGarten().add(child2);

        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Søren", "020202-7878","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Ulla", "030303-7474","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Faisal", "040404-0000","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Kian", "050505-1111","1234" ));

        Kindergarten.getInstance().getDailyManagersInGarten().add(new DailyManager("ManaWar", "020302-2817","43211" ));
        Kindergarten.getInstance().getDailyManagersInGarten().add(new DailyManager("Søren", "201854-8745","43241" ));
        Kindergarten.getInstance().getDailyManagersInGarten().add(new DailyManager("Rygesen", "060302-5221","432334" ));

        Kindergarten.getInstance().setBoss(new Boss("Trolle", "9992","iddqd"));

        Worksheet worksheet = new Worksheet(2020,3);
        DailyOverview dailyOverview = worksheet.getWorkDays().get(2).getDailyOverview();

        System.out.println(dailyOverview.getDailyOverViewID());

        dailyOverview.childCheckIn("030503-2451");
        dailyOverview.childCheckIn("032332-2451");
        dailyOverview.childCheckIn("031231-2453");

       dailyOverview.employeeCheckIn("020202-7878");
       dailyOverview.employeeCheckIn("030303-7474");
       dailyOverview.employeeCheckIn("040404-0000");
       dailyOverview.employeeCheckIn("050505-1111");

        dailyOverview.dailyManagerCheckIn("020302-2817");

        System.out.println(child2.getCPR());
        System.out.println(child2.getStatus());

        System.out.println(Kindergarten.getInstance().getEmployeesInGarten().get(1));

        System.out.println(Kindergarten.getInstance().getEmployeesInGarten().get(2).getCPR());

        dailyOverview.employeeCheckOut("030303-7474");
        dailyOverview.childCheckOut("031231-2453");

        Kindergarten.getInstance().addChildToQueue("søren","010101-2200","allergi:pære");
        Kindergarten.getInstance().addChildToQueue("søren1","010101-2211","allergi:kumkvut");
        Kindergarten.getInstance().addChildToQueue("søren2","010101-2222","allergi:kumkvut");
        Kindergarten.getInstance().addChildToQueue("søren3","010101-2233","allergi:ja");

        Kindergarten.getInstance().removeChildFromQueue("010101-2222");

        Kindergarten.getInstance().addChildToGarten("010101-2211");

        dailyOverview.dailyManagerCheckOut("020302-2817");


        System.out.println(ReadFileUtil.readChildList());
    }
}

//Skal lave en fil scanner som kan bruges til af instantiere de forskellige objekter
//skal lave en nogle metoder der kan læse linjer på filer og lave ændringer, så sætte dem ind i filen igen og slette den " læste linje"
//