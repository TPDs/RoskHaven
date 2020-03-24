package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GuiEditWorksheet extends GuiWorksheetWeek implements ActionListener {

    static JLabel choose_day;


    GuiEditWorksheet(){}

    public void guiEditWorksheet(){
        Gui.frame.setTitle("Roskilde frie børnehave - EditWorksheet");
    }
}
