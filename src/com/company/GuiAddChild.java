package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAddChild extends GuiBoss implements ActionListener {

    static JLabel child_information;
    static JLabel child_name;
    static JTextField c_name;
    static JLabel child_cpr;
    static JTextField c_cpr;
    static JLabel child_address;
    static JTextField c_address;
    static JLabel child_note;
    static JTextField c_note;
    static JButton next;
    //static String user;
    //static String password;

    GuiAddChild(){}

    public void guiAddChild(){
        Gui.frame.setTitle("Roskilde frie børnehave - AddChild");

        GuiAddChild te = new GuiAddChild();

        child_information = new JLabel("Indtast barnets oplysninger");
        child_name = new JLabel("Navn:");
        child_cpr = new JLabel("CPR-Nummer:");
        child_address = new JLabel("Adresse:");
        child_note = new JLabel("Note (Allergier, \n sygdomme mm):");

        c_name = new JTextField("");
        c_cpr = new JTextField("");
        c_address = new JTextField("");
        c_note = new JTextField("");

        next = new JButton("Næste");

        child_information.setBounds(120,45,200,20);
        child_name.setBounds(70,90,150,20);
        child_cpr.setBounds(70,130,150,20);
        child_address.setBounds(70,170,150,20);
        child_note.setBounds(70,210,200,20);

        c_name.setBounds(152,90,150,20);
        c_cpr.setBounds(152,130,150,20);
        c_address.setBounds(152,170,150,20);
        c_note.setBounds(70,240,235,70);

        next.setBounds(245, 320, 75, 20);

        frame.add(child_information);
        frame.add(child_name);
        frame.add(child_note);
        frame.add(child_cpr);
        frame.add(child_address);

        frame.add(c_name);
        frame.add(c_note);
        frame.add(c_cpr);
        frame.add(c_address);

        frame.add(next);

        next.addActionListener(te);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Næste") {
            System.out.println("Guardian: " + s); //ændres til login();

            clean.guiAddChild();

            GuiAddGuardian guardian = new GuiAddGuardian();
            guardian.guiAddGuardian();
        }
    }
}
