package com.mycompany.biblioteca;

public class Material {
    protected String code;
    protected String title;
    protected String publicationYear;

    public Material(String code, String title, String publicationYear) {
        this.code = code;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getPublicationYear() { return publicationYear; }
}

