package com.asos.codetest.se.app;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Customer {

    private int id;
    private String firstName;
    private String surname;
    private LocalDateTime dateOfBirth;
    private String emailAddress;
    private boolean hasCreditLimit;
    private int creditLimit;

    private Company company;

    public Company getCompany() {

        return company;
    }

    public void setCompany(Company company) {

        this.company = company;
    }

    public int getCreditLimit() {

        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {

        this.creditLimit = creditLimit;
    }

    public LocalDateTime getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public boolean getHasCreditLimit() {

        return hasCreditLimit;
    }

    public void setHasCreditLimit(boolean hasCreditLimit) {

        this.hasCreditLimit = hasCreditLimit;
    }
}
