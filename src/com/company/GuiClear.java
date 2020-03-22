package com.company;

import javax.swing.*;
import java.awt.*;

public class GuiClear {

    public void guiClear() {

        Gui.ansatliste.setBounds(10,10,10,10); //dropDown menu der laver en glitch med andre boxe
        Gui.ansatliste.setVisible(false);
        Gui.frame.remove(Gui.ansatliste);
        Gui.l_name.setVisible(false);
        Gui.l_password.setVisible(false);
        Gui.button.setVisible(false);
        Gui.frame.remove(Gui.button);
        Gui.t_name.setVisible(false);
        Gui.t_password.setVisible(false);
        Gui.l_name.setVisible(false);
        // Gui.logo.setVisible(false);
        //Gui.l_test.setVisible(false);
        //Gui.frame.remove(Gui.l_test);


    }

    public void guiBossClear() {
        GuiBoss.create_kid.setVisible(false);
        GuiBoss.check_kid.setVisible(false);
        GuiBoss.workSheet.setVisible(false);
        GuiBoss.salary.setVisible(false);
        GuiBoss.logout.setVisible(false);
        Gui.logo.setVisible(false);
        GuiBoss.l_name.setVisible(false);




    }

    public void guiAddChild(){
        GuiAddChild.child_name.setVisible(false);
        GuiAddChild.child_birth.setVisible(false);
        GuiAddChild.child_note.setVisible(false);
        GuiAddChild.child_address.setVisible(false);
        GuiAddChild.child_information.setVisible(false);
        GuiAddChild.child_cpr.setVisible(false);
        GuiAddChild.c_name.setVisible(false);
        GuiAddChild.c_birth.setVisible(false);
        GuiAddChild.c_note.setVisible(false);
        GuiAddChild.c_address.setVisible(false);
        GuiAddChild.c_cpr.setVisible(false);
        GuiAddChild.next.setVisible(false);
    }


}
