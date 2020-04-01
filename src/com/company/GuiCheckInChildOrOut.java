package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCheckInChildOrOut extends GuiDailyOverview implements ActionListener {

    static JLabel topText;
    static JLabel child_cpr;
    static JTextField c_cpr;
    static JButton checkInChild;
    static JButton checkOutChild;
    static JButton back;
    static String barn1_cpr;
    static String barn2_cpr;
    static JLabel checked;
    String cpr_name = "test";

    GuiCheckInChildOrOut() {
    }

    public void guiCheckInChildOrOut() {
        Gui.frame.setTitle("Roskilde frie børnehave - CheckInChildOrOut");

        GuiCheckInChildOrOut te = new GuiCheckInChildOrOut();

        topText = new JLabel("Indtast CPR-nummeret på barnet");
        child_cpr = new JLabel("CPR:");
        checked = new JLabel("");

        c_cpr = new JTextField(null);

        checkInChild = new JButton("Tjek barn ind");
        checkOutChild = new JButton("Tjek barn ud");

        back = new JButton("Tilbage");

        topText.setBounds(120, 80, 380, 20);
        checked.setBounds(135, 110, 300, 20);

        child_cpr.setBounds(70, 160, 110, 20);
        c_cpr.setBounds(140, 160, 200, 20);

        checkInChild.setBounds(70, 220, 110, 20);
        checkOutChild.setBounds(200, 220, 110, 20);

        back.setBounds(70, 250, 110, 20);

        frame.getContentPane().add(topText, BorderLayout.NORTH);
        frame.getContentPane().add(checked, BorderLayout.NORTH);

        frame.getContentPane().add(child_cpr, BorderLayout.NORTH);
        frame.getContentPane().add(c_cpr, BorderLayout.NORTH);

        frame.getContentPane().add(checkInChild, BorderLayout.NORTH);
        frame.getContentPane().add(checkOutChild, BorderLayout.NORTH);

        frame.getContentPane().add(back, BorderLayout.NORTH);

        checkInChild.addActionListener(te);
        checkOutChild.addActionListener(te);

        back.addActionListener(te);

        frame.add(topText);
        frame.add(checked);
        frame.add(child_cpr);
        frame.add(c_cpr);
        frame.add(checkInChild);
        frame.add(checkOutChild);
        frame.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();
        barn2_cpr = c_cpr.getText();
        //Using a singleton-instance to ensure the actionListener-loop takes the updated childrenInGartenNow list
        Kindergarten.getInstance().createNewWorksheet(2020, 5);
        DailyOverview check = Kindergarten.getInstance().getWorksheetList().get(0).getWorkDays().get(2).getDailyOverview();
        //check.childCheckIn(barn2_cpr);
        // Skal laves når worksheet er done

        if (s == "Tjek barn ind") {

            topText.setText("");
            c_cpr.setText("");
            check.childCheckIn(barn2_cpr);
            checked.setText(Kindergarten.getInstance().searchAndFindChild(barn2_cpr).getName() + " er blevet tjekket ind");

        } else if (s == "Tjek barn ud") {
            topText.setText("");
            c_cpr.setText("");
            check.childCheckOut(barn2_cpr);
            checked.setText(Kindergarten.getInstance().searchAndFindChild(barn2_cpr).getName() +" er blevet tjekket ud");

        } else if (s == "Tilbage") {
            if (ansatliste.getSelectedItem() == "Daglig leder") {
                clean.guiCheckInChildOrOut();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if (ansatliste.getSelectedItem() == "pædagog") {
                clean.guiCheckInChildOrOut();
                Gui.logo.setVisible(true);

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }
}
