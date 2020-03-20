package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GuiAddChild extends GuiBoss implements ActionListener {

    GuiAddChild(){}

    public void guiAddChild(){
        Gui.frame.setTitle("Roskilde frie børnehave - AddChild menu");
    }
}
