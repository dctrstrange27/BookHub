package com.example.jason_valley.usermodel;

public class Books {
    private int id;
    private String title;
    private String author;
    private String description;
    private String language;
    private String category;
    private  String images;
    private  String pdf;

    public Books(int id, String title, String author, String description, String language, String category, String images, String pdf) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.language = language;
        this.category = category;
        this.images = images;
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", category='" + category + '\'' +
                ", images='" + images + '\'' +
                ", pdf='" + pdf + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}

