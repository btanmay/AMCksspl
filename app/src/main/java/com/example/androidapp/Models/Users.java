package com.example.androidapp.Models;

public class Users {
    String profilepic , mail ,password ,userId , lastMessage;

    public Users(String profilepic, String mail, String password, String userId, String lastMessage) {
        this.profilepic = profilepic;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.lastMessage = lastMessage;
    }


    public Users(){ }
    public Users( String userId, String mail, String password )
    {

        this.mail =userId;
        this.password = mail ;
        this.userId =password;

    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}


