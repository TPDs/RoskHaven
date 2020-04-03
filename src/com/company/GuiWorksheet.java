package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.WatchEvent.Kind;

public class GuiWorksheet extends GuiBoss implements ActionListener {

    static JLabel info;
    static JLabel week_label;
    static JTextField week_text;
    static JButton back;
    static JButton next;
    static String week_nr;
    static JTextField set_yr, set_mb;

    static int mb;
    static int yr;


    GuiWorksheet() {
    }

    public void guiWorksheet() {
        Gui.frame.setTitle("Roskilde frie børnehave - Worksheet");

        GuiWorksheet te = new GuiWorksheet();


        info = new JLabel("Vagtplan:");
        week_label = new JLabel("Indtast dag, måned og år:");
        back = new JButton("Tilbage");
        next = new JButton("Næste");

        set_yr = new JTextField();
        set_mb = new JTextField();
        week_text = new JTextField();

        Gui.frame.getContentPane().add(info, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(week_label, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(week_text, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(next, BorderLayout.CENTER);

        info.setBounds(100, 145, 360, 20);
        week_label.setBounds(100,175,150,20);
        week_text.setBounds(130, 195, 30, 20);
        set_mb.setBounds(170,195,30,20);
        set_yr.setBounds(210,195,40,20);


        next.setBounds(275, 320, 75, 20);
        back.setBounds(40, 320, 100, 20);

        next.addActionListener(te);
        back.addActionListener(te);
        frame.add(set_yr);
        frame.add(set_mb);
        frame.add(info);
        frame.add(week_label);
        frame.add(week_text);
        frame.add(back);
        frame.add(next);


        week_text.addKeyListener(new KeyAdapter() {
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
            week_nr = week_text.getText();
            yr = Integer.parseInt(set_yr.getText());
            mb = Integer.parseInt(set_mb.getText());
            clean.guiWorksheet();
            Kindergarten.getInstance().createNewWorksheet(yr,mb);
            GuiWorksheetWeek worksheetWeek = new GuiWorksheetWeek();
            worksheetWeek.guiWorksheetWeek();


        } else if(s =="Tilbage") {
            if(ansatliste.getSelectedItem().equals("Boss")) {
                clean.guiWorksheet();
                Gui.logo.setVisible(true);

                GuiBoss bigboss = new GuiBoss();
                bigboss.GuiBoss();
            }

            if(ansatliste.getSelectedItem().equals("Daglig leder")){
                clean.guiWorksheet();
                Gui.logo.setVisible(true);

                GuiDailyManager dm = new GuiDailyManager();
                dm.guiDailyManager();
            }

            if(ansatliste.getSelectedItem().equals("pædagog")){
                clean.guiWorksheet();
                Gui.logo.setVisible(true);

                GuiEmployee emp = new GuiEmployee();
                emp.guiEmployee();
            }
        }
    }
}