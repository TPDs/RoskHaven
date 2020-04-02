package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // husk at slette IOException når dummy data bliver slettet.
    public static void main(String[] args) {
        //Gui gui = new Gui();
        //gui.gui();


        //System.out.println(Kindergarten.getInstance().getAllChildren());
        //System.out.println(Kindergarten.getInstance().getWorksheetList());

        //Worksheet w1 = Kindergarten.getInstance().findWorksheet(2020,3);
        //Worksheet w2 = Kindergarten.getInstance().findWorksheet(2020,4);




        // dummy data til test af funktionaliteter i DailyOverview classen
/*
        Child child = new Child("Cirkeline","030503-2451","hun spiser ikke kartofler om onsdagen");
        Child child1 = new Child("Hansi","032332-2451","hun spiser ikke kartofler om onsdagen");
        Child child2 = new Child("Gurgemau","031231-2453","hun spiser ikke kartofler om onsdagen");

        child.addGuardian("As", "as@mail.dk", "22222222", "As,2. st");

        Kindergarten.getInstance().getChildrenInGarten().add(child);
        Kindergarten.getInstance().getChildrenInGarten().add(child1);
        Kindergarten.getInstance().getChildrenInGarten().add(child2);

        //System.out.println(child);

        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Søren", "020202-7878","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Ulla", "030303-7474","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Faisal", "040404-0000","1234" ));
        Kindergarten.getInstance().getEmployeesInGarten().add(new Employee("Kian", "050505-1111","1234" ));

        Kindergarten.getInstance().getDailyManagersInGarten().add(new DailyManager("ManaWar", "020302-2817","43211" ));
        Kindergarten.getInstance().getDailyManagersInGarten().add(new DailyManager("Søren", "201854-8745","43241" ));
        Kindergarten.getInstance().getDailyManagersInGarten().add(new DailyManager("Rygesen", "060302-5221","432334" ));

        Kindergarten.getInstance().setBoss(new Boss("Trolle", "9992","iddqd"));


        Kindergarten.getInstance().addChildToQueue("søren","010101-2200","allergi:pære");
        Kindergarten.getInstance().addChildToQueue("søren1","010101-2211","allergi:kumkvut");
        Kindergarten.getInstance().addChildToQueue("søren2","010101-2222","allergi:kumkvut");
        Kindergarten.getInstance().addChildToQueue("søren3","010101-2233","allergi:ja");

        Kindergarten.getInstance().removeChildFromQueue("010101-2222");

        Kindergarten.getInstance().addChildToGarten("010101-2211");
*/

        //Kindergarten.getInstance().createNewWorksheet(2020,3);
        //Kindergarten.getInstance().createNewWorksheet(2020,4);

        Worksheet worksheet1 = Kindergarten.getInstance().findWorksheet(2020,3);
        Worksheet worksheet2 = Kindergarten.getInstance().findWorksheet(2020,4);

        DailyOverview dailyO = worksheet1.getWorkDays().get(0).getDailyOverview();
        DailyOverview dailyO1 = worksheet2.getWorkDays().get(2).getDailyOverview();

        System.out.println(dailyO.getChildrenInGartenNow());

        //dailyO1.childCheckOut("030503-2451");
/*
        dailyO.childCheckIn("030503-2451");
        dailyO.childCheckOut("030503-2451");

        dailyO.childCheckIn("032332-2451", 12,21);
        dailyO.childCheckOut("032332-2451", 16,10);

        dailyO.childCheckIn("031231-2453");

        dailyO1.childCheckIn("030503-2451");
*/
        //System.out.println(dailyO.getChildrenInGartenNow());




        //worksheet1.addDailyManagerToSchedule("020302-2817", 2);
        //worksheet1.addDailyManagerToSchedule("201854-8745", 3);
        //worksheet1.addDailyManagerToSchedule("201854-8745", 4);
        //worksheet1.addDailyManagerToSchedule("201854-8745", 10);


        //worksheet2.addDailyManagerToSchedule("020302-2817", 1);
        //worksheet2.addDailyManagerToSchedule("020302-2817", 2);
        //worksheet2.addDailyManagerToSchedule("020302-2817", 3);
        //worksheet2.addDailyManagerToSchedule("201854-8745", 4);


        //worksheet1.addWorkerToSchedule("040404-0000", 1);
        //worksheet1.addWorkerToSchedule("040404-0000", 2);
        //worksheet1.addWorkerToSchedule("040404-0000", 4);

        //worksheet1.addWorkerToSchedule("030303-7474", 1);
        //worksheet1.addWorkerToSchedule("030303-7474", 3);

        //worksheet1.addWorkerToSchedule("050505-1111", 4);
/*
        Worksheet w1 = Kindergarten.getInstance().findWorksheet(2020,3);
        Worksheet w2 = Kindergarten.getInstance().findWorksheet(2020,4);

        System.out.println(w1.getWorkDays().get(0).getDailyOverview().getDailyManagerScheduled());
        System.out.println(w1.getWorkDays().get(0).getWorkHours().get(1).getEmployeeAtWork().get(0));
        System.out.println(w1.getWorkDays().get(0).getWorkHours().get(1).getEmployeeAtWork().get(1));
   */ }
}