package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiBoss extends Gui implements ActionListener {

    static JButton create_kid;
    static JButton check_kid;
    static JButton workSheet;
    static JButton logout;
    static String barn_navn;
    static String barn_cpr;
    static String barn_note;

    GuiBoss() {
    }

    public void GuiBoss() {

        Gui.frame.setTitle("Roskilde frie børnehave - Boss");

        l_name.setText("Velkommen "+ Kindergarten.getInstance().getBoss().getName());
        l_name.setVisible(true);

        GuiBoss te = new GuiBoss();

        create_kid = new JButton("Opret barn");
        check_kid = new JButton("Ret barn");
        workSheet = new JButton("Uge plan");
        logout = new JButton("Log ud");
        frame.getContentPane().add(logout,BorderLayout.CENTER);

        create_kid.setBounds(70, 220, 120, 20);
        check_kid.setBounds(200, 220, 120, 20);
        workSheet.setBounds(70, 260, 120, 20);
        logout.setBounds(220,260,75,20);

        create_kid.addActionListener(te);
        check_kid.addActionListener(te);
        workSheet.addActionListener(te);
        logout.addActionListener(te);

        frame.add(create_kid);
        frame.add(check_kid);
        frame.add(workSheet);
        frame.add(logout);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Opret barn") {
            clean.guiBossClear();
            GuiAddChild child = new GuiAddChild();
            child.guiAddChild();

        } else if (s == "Ret barn") {

            clean.guiBossClear();

            GuiCheckChild child = new GuiCheckChild();
            child.guiCheckChild();

        } else if (s.equals("Uge plan")) {

            clean.guiBossClear();
            GuiWorksheet work = new GuiWorksheet();
            work.guiWorksheet();

        } else if (s.equals("Log ud")) {
            frame.setTitle("Roskilde frie børnehave");
            user=null;
            password=null;
            l_name.setText("CPR: ");
            clean.guiBossClear();
            clean.guiLogOut();
        }


    }
}