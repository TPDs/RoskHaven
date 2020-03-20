package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

        GuiBoss te = new GuiBoss();

        create_kid = new JButton("Opret barn");
        check_kid = new JButton("Ret barn");
        workSheet = new JButton("Uge plan");
        salary = new JButton("Løn");
        logout = new JButton("Log ud");

        create_kid.setBounds(70, 220, 120, 20);
        check_kid.setBounds(200, 220, 120, 20);
        workSheet.setBounds(70, 250, 120, 20);
        salary.setBounds(200, 250, 120, 20);
        logout.setBounds(245,320,75,20);

        create_kid.addActionListener(te);

        frame.add(create_kid);
        frame.add(check_kid);
        frame.add(workSheet);
        frame.add(salary);
        frame.add(logout);


        create_kid.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    create_kid.doClick();

                }
            }
        });

        check_kid.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    check_kid.doClick();

                }
            }
        });

        workSheet.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    workSheet.doClick();

                }
            }
        });

        salary.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    salary.doClick();

                }
            }
        });

        logout.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    logout.doClick();

                }
            }
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Opret barn")) {
            System.out.println("Test: " + s); //ændres til login();
            GuiClear clean = new GuiClear();
            clean.guiBossClear();

            GuiAddChild child = new GuiAddChild();
            child.guiAddChild();
        }
            else if(s.equals("Ret barn")){
                System.out.println("Test: " + s);
                GuiClear clean = new GuiClear();
                clean.guiBossClear();

                GuiCheckChild child = new GuiCheckChild();
                child.guiCheckChild();
            }
                else if(s.equals("Uge plan")){
                    System.out.println("Test: " + s);
                    GuiClear clean = new GuiClear();
                    clean.guiBossClear();

                    GuiWorksheet work = new GuiWorksheet();
                    work.guiWorksheet();
                }
                    else if(s.equals("Løn")){
                        System.out.println("Test: " + s);
                        GuiClear clean = new GuiClear();
                        clean.guiBossClear();

                        GuiSalary salary = new GuiSalary();
                        salary.guiSalary();
                    }
                        /*else if(s.equals("Log ud")){
                            System.out.println("Test: " + s);
                            GuiClear clean = new GuiClear();
                            clean.guiBossClear();

                            GuiAddChild child = new GuiAddChild();
                            child.guiAddChild();
                        }*/


    }
}