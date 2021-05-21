package com.isaProject.isa.Model.DTO;

public class ChangePasswordDTO {

    private String oldPass;

    private String newPass;

    private String repeatNewPass;

    public ChangePasswordDTO() {
    }

    public ChangePasswordDTO(String oldPass, String newPass, String repeatNewPass) {
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.repeatNewPass = repeatNewPass;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getRepeatNewPass() {
        return repeatNewPass;
    }

    public void setRepeatNewPass(String repeatNewPass) {
        this.repeatNewPass = repeatNewPass;
    }
}
