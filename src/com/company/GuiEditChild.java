package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiEditChild extends GuiViewChild implements ActionListener {


    static JTextField ce_name_field, ce_cpr_field, ce_note_field;
    static JLabel ce_name, ce_cpr,ce_note_lable;
    static JTextArea ce_note;
    static JButton ce_ok, ce_regret;

    GuiEditChild() {
    }


    public void guiEditChild() {
        Gui.frame.setTitle("Roskilde frie børnehave - EditChild");

        GuiEditChild te = new GuiEditChild();

        ce_name_field = new JTextField();
        ce_cpr_field = new JTextField();
        ce_note_field = new JTextField();

        ce_ok= new JButton("Godkend");
        ce_regret = new JButton("Fortryd");

        ce_name = new JLabel("Navn:");
        ce_cpr = new JLabel("CPR:");
        ce_note_lable = new JLabel("Noter:");

        ce_note = new JTextArea();

        ce_name_field.setBounds(120, 90, 150, 20);
        ce_cpr_field.setBounds(120, 130, 150, 20);
        ce_note.setBounds(50, 210, 285, 90);

        ce_name.setBounds(50, 90, 150, 20);
        ce_cpr.setBounds(50, 130, 150, 20);
        ce_note_lable.setBounds(50, 175, 150, 20);

        ce_ok.setBounds(245, 320, 100, 20);
        ce_regret.setBounds(40, 320, 100, 20);

        ce_ok.addActionListener(te);
        ce_regret.addActionListener(te);

        frame.add(ce_name);
        frame.add(ce_cpr);
        frame.add(ce_note_lable);
        frame.add(ce_name_field);
        frame.add(ce_cpr_field);
        frame.add(ce_note);

        frame.add(ce_ok);
        frame.add(ce_regret);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

    }
}
