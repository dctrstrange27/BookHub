package com.example.jason_valley.usermodel;

public class loggedIn {

    private int id;
    private String email;
    private String username;
   private String password;
   private byte[] picture;
   private Boolean verified;
   private int viewBooks;
   private int borrowBooks;

    public loggedIn(int id, String email, String username, String password, byte[] picture, Boolean verified, int viewBooks, int borrowBooks) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.verified = verified;
        this.viewBooks = viewBooks;
        this.borrowBooks = borrowBooks;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
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

    public int getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(int borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
