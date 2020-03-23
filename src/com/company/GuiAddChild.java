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
    static JLabel child_note;
    static JTextArea c_note;
    static JButton next;
    static String barn_navn;
    static String barn_cpr;
    static String barn_note;

    GuiAddChild(){}

    public void guiAddChild(){
        Gui.frame.setTitle("Roskilde frie børnehave - AddChild");

        GuiAddChild te = new GuiAddChild();

        child_information = new JLabel("Indtast barnets oplysninger");
        child_name = new JLabel("Navn:");
        child_cpr = new JLabel("CPR-Nummer:");
        child_note = new JLabel("Note (Allergier, \n sygdomme mm):");

        c_name = new JTextField("");
        c_cpr = new JTextField("");
        c_note = new JTextArea();
        c_note.setLineWrap(true);

        next = new JButton("Næste");

        Gui.frame.getContentPane().add(child_name,BorderLayout.CENTER);
        Gui.frame.getContentPane().add(next,BorderLayout.CENTER);

        child_information.setBounds(110,45,200,20);
        child_name.setBounds(40,90,150,20);
        child_cpr.setBounds(40,130,150,20);
        child_note.setBounds(40,170,200,20);

        c_name.setBounds(150,90,150,20);
        c_cpr.setBounds(150,130,150,20);
        c_note.setBounds(50,210,275,70);

        next.setBounds(275, 320, 75, 20);

        frame.add(child_information);
        frame.add(child_name);
        frame.add(child_note);
        frame.add(child_cpr);

        frame.add(c_name);
        frame.add(c_note);
        frame.add(c_cpr);

        frame.add(next);

        next.addActionListener(te);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Næste") {
            System.out.println("Guardian: " + s); //ændres til login();

            barn_navn = c_name.getText();
            barn_cpr = c_cpr.getText();
            barn_note = c_note.getText();

            clean.guiAddChild();

            GuiAddGuardian guardian = new GuiAddGuardian();
            guardian.guiAddGuardian();


            //Tilfoej parametre, saa man ikke kan klikke videre (!= null)
            //Tilfoej tilbageknap


        }
    }
}
