package com.company;

import java.awt.event.ActionListener;

public class GuiViewChild extends GuiCheckChild implements ActionListener {


    GuiViewChild(){}

    public void guiViewChild(){
        Gui.frame.setTitle("Roskilde frie børnehave - ViewChild");
        System.out.println("Hello");
    }
}
