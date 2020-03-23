package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiViewChild extends GuiCheckChild implements ActionListener {


    static JLabel topTekst;
    static JButton back;
    static JButton editChild;
    static JButton editGuardian;
    static JButton createGuardian;
    static JButton removeChild;

    GuiViewChild(){}

    public void guiViewChild() {
        Gui.frame.setTitle("Roskilde frie børnehave - ViewChild");

        GuiViewChild te = new GuiViewChild();

        topTekst = new JLabel("Hvad kunne du tænke dig at gøre?");

        back = new JButton("Tilbage");
        editChild = new JButton("Opdater Barn");
        editGuardian = new JButton("Opdater Værge");
        createGuardian = new JButton("Opret Værge");
        removeChild = new JButton("Fjern Barn");

        Gui.frame.getContentPane().add(topTekst, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(editChild, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(editGuardian, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(createGuardian,BorderLayout.CENTER);
        Gui.frame.getContentPane().add(removeChild, BorderLayout.CENTER);

        topTekst.setBounds(110, 45, 200, 20);

        back.setBounds(40, 340, 150, 20);
        editChild.setBounds(120, 270, 150, 20);
        editGuardian.setBounds(200, 270, 150, 20);
        createGuardian.setBounds(280,270,130,20);
        removeChild.setBounds(340, 270, 150, 20);

        frame.add(topTekst);

        back.addActionListener(te);
        editChild.addActionListener(te);
        editGuardian.addActionListener(te);
        createGuardian.addActionListener(te);
        removeChild.addActionListener(te);

        frame.add(back);
        frame.add(editChild);
        frame.add(editGuardian);
        frame.add(createGuardian);
        frame.add(removeChild);
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
