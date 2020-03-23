package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiCheckChild extends GuiBoss implements ActionListener {

    static JLabel child_information;
    static JLabel child_cpr;
    static JTextField c_cpr;
    static JButton next;
    static String barn_cpr;


    GuiCheckChild() {
    }

    public void guiCheckChild(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckChild");

        GuiCheckChild te = new GuiCheckChild();

        child_information = new JLabel("Indtast barnets oplysninger");
        child_cpr = new JLabel("CPR-Nummer:");

        c_cpr = new JTextField("");

        next = new JButton("Næste");

        Gui.frame.getContentPane().add(child_cpr, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(next,BorderLayout.CENTER);

        child_information.setBounds(110,45,200,20);
        child_cpr.setBounds(40,170,150,20);

        c_cpr.setBounds(150,170,150,20);

        next.setBounds(275, 320, 75, 20);

        next.addActionListener(te);

        frame.add(child_information);
        frame.add(child_cpr);

        frame.add(c_cpr);

        frame.add(next);

        c_cpr.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    next.doClick();

                }
            }
        });



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Næste") {
            System.out.println("CPR: " + s); //ændres til login();

            barn_cpr = c_cpr.getText();

            clean.guiCheckChild();

            GuiViewChild view = new GuiViewChild();
            view.guiViewChild();
        }
    }
}

