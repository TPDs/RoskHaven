package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GuiAddChild extends GuiBoss implements ActionListener {

    static JLabel child_information;
    static JLabel child_name;
    static JTextField c_name;
    static JLabel child_birth;
    static JTextField c_birth;
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

        ImageIcon icon = new ImageIcon("src/resourser/window_icon.png");

        child_information = new JLabel("Indtast barnets oplysninger");
        child_name = new JLabel("Navn: ");
        child_birth = new JLabel("Fødselsdato: ");
        child_cpr = new JLabel("CPR-Nummer");
        child_address = new JLabel("Adresse: ");
        child_note = new JLabel("Note (Allergier, sygdomme, medicin mm.: ");

        c_name = new JTextField("");
        c_birth = new JTextField("");
        c_cpr = new JTextField("");
        c_address = new JTextField("");
        c_note = new JTextField("");

        next = new JButton("Næste");

        child_information.setBounds(140,45,200,20);
        child_name.setBounds(70,70,150,20);
        child_birth.setBounds(70,110,150,20);
        next.setBounds(245, 320, 75, 20);

        frame.add(child_information);
        frame.add(child_name);
        frame.add(child_birth);
        frame.add(next);


    }
}
