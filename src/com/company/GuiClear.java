package com.company;

import javax.swing.*;

public class GuiClear {

    public void guiClear() {

        Gui.ansatliste.setBounds(10, 10, 10, 10); //dropDown menu der laver en glitch med andre boxe
        Gui.ansatliste.setVisible(false);
        //Gui.frame.remove(Gui.ansatliste);
        Gui.l_name.setVisible(false);
        Gui.l_password.setVisible(false);
        Gui.button.setVisible(false);
        //Gui.frame.remove(Gui.button);
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
        GuiBoss.logout.setVisible(false);
        Gui.logo.setVisible(false);
        GuiBoss.l_name.setVisible(false);


    }

    public void guiAddChild() {
        GuiAddChild.child_name.setVisible(false);
        GuiAddChild.child_note.setVisible(false);
        GuiAddChild.child_information.setVisible(false);
        GuiAddChild.child_cpr.setVisible(false);
        GuiAddChild.c_name.setVisible(false);
        GuiAddChild.c_note.setVisible(false);
        GuiAddChild.c_cpr.setVisible(false);
        GuiAddChild.next.setVisible(false);
        GuiAddChild.back.setVisible(false);
    }

    public void guiAddGuardian() {
        GuiAddGuardian.title.setVisible(false);
        GuiAddGuardian.name_box.setVisible(false);
        GuiAddGuardian.mail_box.setVisible(false);
        GuiAddGuardian.phone_box.setVisible(false);
        GuiAddGuardian.address_box.setVisible(false);
        GuiAddGuardian.adresse_postnummer_box.setVisible(false);
        GuiAddGuardian.name_text.setVisible(false);
        GuiAddGuardian.mail_text.setVisible(false);
        GuiAddGuardian.phone_text.setVisible(false);
        GuiAddGuardian.adresse_text.setVisible(false);
        GuiAddGuardian.adresse_postnummer_text.setVisible(false);
        GuiAddGuardian.next2.setVisible(false);
        GuiAddGuardian.addedG.setVisible(false);
        GuiAddGuardian.add_next.setVisible(false);
        GuiAddGuardian.back.setVisible(false);

    }

    public void guiCheckChild() {
        GuiCheckChild.child_cpr.setVisible(false);
        GuiCheckChild.child_information.setVisible(false);
        GuiCheckChild.c_cpr.setVisible(false);
        GuiCheckChild.next.setVisible(false);
        GuiCheckChild.back.setVisible(false);
    }

    public void guiViewChild(){
        GuiViewChild.topTekst.setVisible(false);
        GuiViewChild.back.setVisible(false);
        GuiViewChild.editChild.setVisible(false);
        GuiViewChild.editGuardian.setVisible(false);
        GuiViewChild.createGuardian.setVisible(false);
        GuiViewChild.removeChild.setVisible(false);
        GuiViewChild.child_info.setVisible(false);
        GuiViewChild.scroll.setVisible(false);
    }

    public void guiWorksheet(){
        GuiWorksheet.info.setVisible(false);
        GuiWorksheet.week_label.setVisible(false);
        GuiWorksheet.week_text.setVisible(false);
        GuiWorksheet.back.setVisible(false);
        GuiWorksheet.next.setVisible(false);
    }

    public void guiEditGuardian(){


        GuiEditGuardian.g_name.setVisible(false);
        GuiEditGuardian.g_info.setVisible(false);
        GuiEditGuardian.guardian_list.setVisible(false);
        GuiEditGuardian.edit.setVisible(false);
        GuiEditGuardian.name.setVisible(false);
        GuiEditGuardian.mail.setVisible(false);
        GuiEditGuardian.adresse.setVisible(false);
        GuiEditGuardian.phone.setVisible(false);
        GuiEditGuardian.exit.setVisible(false);


    }

    public void guiWorksheetWeek(){
        GuiWorksheetWeek.label.setVisible(false);
        GuiWorksheetWeek.worksheet_info.setVisible(false);
        GuiWorksheetWeek.edit_worksheet.setVisible(false);
        GuiWorksheetWeek.back.setVisible(false);
        GuiWorksheetWeek.scroll3.setVisible(false);

    }

    public void guiConfirm(){

        GuiConfirm.quit_button.setVisible(false);
        GuiConfirm.box_info.setVisible(false);
        GuiConfirm.confirm_lable.setVisible(false);
        GuiConfirm.confirm_button.setVisible(false);
        GuiConfirm.scroll2.setVisible(false);

    }

    public void guiEmployeeClear(){
        GuiEmployee.worksheet.setVisible(false);
        GuiEmployee.dailyOverview.setVisible(false);
        GuiEmployee.logout.setVisible(false);
        GuiEmployee.l_name.setVisible(false);
        GuiEmployee.logo.setVisible(false);

    }

    public void guiDailyManagerClear(){
        GuiDailyManager.worksheet.setVisible(false);
        GuiDailyManager.dailyOverview.setVisible(false);
        GuiDailyManager.logout.setVisible(false);
        GuiDailyManager.check_kid.setVisible(false);
        GuiDailyManager.l_name.setVisible(false);
        GuiDailyManager.logo.setVisible(false);
    }

    public void guiDailyOverviewClean(){
        GuiDailyOverview.topText.setVisible(false);
        GuiDailyOverview.check_child_in_or_out.setVisible(false);
        GuiDailyOverview.employee_check_in.setVisible(false);
        GuiDailyOverview.employee_check_out.setVisible(false);
        GuiDailyOverview.back.setVisible(false);
        GuiDailyOverview.l_name.setVisible(false);
        GuiDailyOverview.logo.setVisible(false);
    }

    public void guiCheckInClear(){
        GuiCheckIn.checkInConfirmed.setVisible(false);
        GuiCheckIn.back.setVisible(false);
    }

    public void guiCheckOutClear(){
        GuiCheckOut.checkOutConfirmed.setVisible(false);
        GuiCheckOut.back.setVisible(false);
    }

    public void guiCheckInChildOrOut(){
        GuiCheckInChildOrOut.topText.setVisible(false);
        GuiCheckInChildOrOut.child_cpr.setVisible(false);
        GuiCheckInChildOrOut.c_cpr.setVisible(false);
        GuiCheckInChildOrOut.checkInChild.setVisible(false);
        GuiCheckInChildOrOut.checkOutChild.setVisible(false);
        GuiCheckInChildOrOut.back.setVisible(false);
        Gui.frame.remove(GuiCheckInChildOrOut.back);
        GuiCheckInChildOrOut.checked.setVisible(false);
    }

    public void guiInChildConfirm(){
        GuiCheckInChildConfirm.check_in_confirm.setVisible(false);
        GuiCheckInChildConfirm.back1.setVisible(false);
    }

    public void guiOutChildConfirm(){
        GuiCheckOutChildConfirm.check_out_confirm.setVisible(false);
        GuiCheckOutChildConfirm.back2.setVisible(false);
    }

    public void guiLogOut(){

        Gui.l_name.setVisible(true);
        Gui.l_password.setVisible(true);
        Gui.button.setVisible(true);
        Gui.t_name.setVisible(true);
        Gui.t_password.setVisible(true);
        Gui.l_name.setVisible(true);
        Gui.logo.setVisible(true);
        Gui.button.setVisible(true);
        Gui.ansatliste.setBounds(105, 256, 100, 25);
        Gui.ansatliste.setVisible(true);
    }

    public void guiRemoveChild(){
        GuiRemoveChild.confirmationText1.setVisible(false);
        GuiRemoveChild.confirmationText2.setVisible(false);
        GuiRemoveChild.confirm.setVisible(false);
        GuiRemoveChild.back.setVisible(false);
    }
    public void guiRemoveEditChild(){


        GuiEditChild.ce_name.setVisible(false);
        GuiEditChild.ce_cpr.setVisible(false);
        GuiEditChild.ce_note_lable.setVisible(false);
        GuiEditChild.ce_name_field.setVisible(false);
        GuiEditChild.ce_cpr_field.setVisible(false);
        GuiEditChild.ce_note.setVisible(false);
        GuiEditChild.ce_ok.setVisible(false);
        GuiEditChild.ce_regret.setVisible(false);


    }


}
