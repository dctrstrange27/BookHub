package com.example.jason_valley.usermodel;

public class loggedIn {
    private int id;
    private String email;
    private String username;
   private String password;
   private String picture;
   private Boolean verified;
   private int viewBooks;

    public loggedIn(int id, String email, String username, String password, String picture, Boolean verified, int viewBooks) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.verified = verified;
        this.viewBooks = viewBooks;
    }

    @Override
    public String toString() {
        return "loggedIn{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", verified=" + verified +
                ", viewBooks=" + viewBooks +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public int getViewBooks() {
        return viewBooks;
    }

    public void setViewBooks(int viewBooks) {
        this.viewBooks = viewBooks;
    }
}
