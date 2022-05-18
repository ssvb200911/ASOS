package com.asos.codetest.se.app;

public class Company {

    private int id;
    private String name;
    private Classification classification;

    public Classification getClassification() {

        return classification;
    }

    public void setClassification(Classification classification) {

        this.classification = classification;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
