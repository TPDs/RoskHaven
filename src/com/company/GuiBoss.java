package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GuiBoss extends Gui implements ActionListener {


    static JButton create_kid;
    static JButton check_kid;
    static JButton workSheet;
    static JButton salary;
    static JButton logout;



    GuiBoss() {
    }

    public void GuiBoss() {

        Gui.frame.setTitle("Roskilde frie børnehave - Boss menu");

        l_name.setText("Velkommen " + Gui.user );
        l_name.setVisible(true);


        create_kid = new JButton("Opret barn");
        check_kid = new JButton("Ret barn");
        workSheet = new JButton("Uge plan");
        salary = new JButton("Løn");
        logout = new JButton("Log ud");

        create_kid.setBounds(70, 220, 120, 20);
        check_kid.setBounds(200, 220, 120, 20);
        workSheet.setBounds(70, 250, 120, 20);
        salary.setBounds(200, 250, 120, 20);
        logout.setBounds(300,320,75,20);


        frame.add(create_kid);
        frame.add(check_kid);
        frame.add(workSheet);
        frame.add(salary);
        frame.add(logout);



        /*
        frame.add(check_kid);
        frame.add(workSheet);
        frame.add(salary);
        frame.add(logout);
        */


    }
}