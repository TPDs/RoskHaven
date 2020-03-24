package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiWorksheetWeek extends GuiWorksheet implements ActionListener {

    static JLabel label;
    static JTextArea worksheet_info;
    static JButton edit_worksheet;
    static JButton back;


    GuiWorksheetWeek(){}
    public void guiWorksheetWeek(){
        Gui.frame.setTitle("Roskilde frie børnehave - WorksheetWeek");

        GuiWorksheetWeek te = new GuiWorksheetWeek();

        label = new JLabel("Hvad kunne du tænke dig at gøre?");

        worksheet_info = new JTextArea(/*Worksheet oplysninger*/);

        edit_worksheet = new JButton("Ændre uge plan");
        back = new JButton("Tilbage");

        Gui.frame.getContentPane().add(label, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(worksheet_info, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(edit_worksheet, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);

        label.setBounds(95,25,360,20);

        worksheet_info.setBounds(20,50,340,230);

        edit_worksheet.setBounds(130,290,140,20);
        back.setBounds(20,330,90,20);

        edit_worksheet.addActionListener(te);
        back.addActionListener(te);

        frame.add(label);
        frame.add(worksheet_info);
        frame.add(edit_worksheet);
        frame.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Ændre uge plan") {
            clean.guiWorksheetWeek();

            GuiEditWorksheet editWorksheet = new GuiEditWorksheet();
            editWorksheet.guiEditWorksheet();


        } else if(s =="Tilbage") {
            clean.guiWorksheetWeek();

            GuiBoss bigboss = new GuiBoss();
            bigboss.GuiBoss();
        }
    }

}
