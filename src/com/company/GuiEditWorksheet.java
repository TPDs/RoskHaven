package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.WatchEvent.Kind;

public class GuiEditWorksheet extends GuiWorksheetWeek implements ActionListener {

    static JLabel worker_cpr_label, day_of_month_label, start_time_label, end_time_label;
    static JButton load_day_button, add_emp_button, delete_day_button;
    static JTextField worker_cpr_text, day_of_month_text, start_time_text, end_time_text;


    GuiEditWorksheet(){}

    public void guiEditWorksheet(){
        Gui.frame.setTitle("Roskilde frie børnehave - EditWorksheet");
        worksheet_info.setVisible(true);
        scroll3.setVisible(true);
        back.setVisible(true);
        scroll3.setBounds(35,20,320,180);

        worker_cpr_label = new JLabel("CPR:");
        day_of_month_label= new JLabel("Dag:");
        start_time_label =  new JLabel("Start time:");
        end_time_label = new JLabel("Slut time:");

        load_day_button = new JButton("Se Dag");
        add_emp_button = new JButton("Tilføj");
        delete_day_button = new JButton("Fjern");

        add_emp_button.setBackground(new Color(62, 249, 106));
        add_emp_button.setForeground(Color.BLACK);
        add_emp_button.setFocusPainted(false);

        delete_day_button.setBackground(new Color(249, 34, 47));
        delete_day_button.setForeground(Color.BLACK);
        delete_day_button.setFocusPainted(false);

        worker_cpr_text = new JTextField();
        day_of_month_text = new JTextField(week_nr);
        start_time_text = new JTextField("7");
        end_time_text = new JTextField("17");

        back.setText("Afslut");

        worker_cpr_label.setBounds(30,220,70,20);
        day_of_month_label.setBounds(30,250,70,20);
        start_time_label.setBounds(200,220,70,20);
        end_time_label.setBounds(200,250,70,20);

        worker_cpr_text.setBounds(65,220,100,20);
        day_of_month_text.setBounds(65,250,100,20);
        start_time_text.setBounds(270,220,30,20);
        end_time_text.setBounds(270,250,30,20);

        load_day_button.setBounds(20,290,90,20);
        add_emp_button.setBounds(270,290,80,20);
        delete_day_button.setBounds(180,290,80,20);


        Gui.frame.add(worker_cpr_label);
        Gui.frame.add(day_of_month_label);
        Gui.frame.add(start_time_label);
        Gui.frame.add(end_time_label);
        Gui.frame.add(worker_cpr_text);
        Gui.frame.add(day_of_month_text);
        Gui.frame.add(start_time_text);
        Gui.frame.add(end_time_text);
        Gui.frame.add(load_day_button);
        Gui.frame.add(add_emp_button);
        Gui.frame.add(delete_day_button);

        GuiEditWorksheet te = new GuiEditWorksheet();

        load_day_button.addActionListener(te);
        add_emp_button.addActionListener(te);
        delete_day_button.addActionListener(te);
        back.addActionListener(te);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();
        int day = Integer.parseInt(day_of_month_text.getText());
        int day_start = Integer.parseInt(start_time_text.getText());
        int day_end = Integer.parseInt(end_time_text.getText());

        if (s== "Se Dag") {
            worksheet_info.setText("");
            String weekliste = Kindergarten.getInstance().findWorksheet(yr,mb).workScheduleOfDay(Integer.parseInt(day_of_month_text.getText()));
            worksheet_info.setText(weekliste);
        }

        else if (s == "Tilføj") {
            Kindergarten.getInstance().findWorksheet(yr,mb).addWorkerToSchedule(worker_cpr_text.getText(),day,day_start,day_end);
            worksheet_info.setText("\n\n\n    " + worker_cpr_text.getText() + " er tilføjet på dag "+ day +" fra "+ day_start + " til "+ day_end);

        }
        else if (s=="Fjern") {
            Kindergarten.getInstance().findWorksheet(yr,mb).removeEmpFromDay(worker_cpr_text.getText(),day);
            worksheet_info.setText("\n\n\n    " + worker_cpr_text.getText() + " er fjernet fra dag " + day);
        }


        else if (s == "Afslut") {
            clean.guiRemoveEditWorksheet();
            Gui.logo.setVisible(true);
            GuiBoss bigboss = new GuiBoss();
            bigboss.GuiBoss();
        }


    }
}
