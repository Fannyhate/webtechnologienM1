package org.htwberlin.de.immo_mile_one.model;

import jakarta.persistence.*;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long  id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    private String lastName;

    private String occupation;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean renter() {

        return renter;
    }

    public void setIsRenter(boolean renter) {
        this.renter = renter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private boolean renter;

    @Column(unique=true)
    private String email;


    public void setId(Long id) {
        this.id = id;
    }



    public boolean getIsRenter() {
        return renter;
    }

    public Long getId() {
        return id;
    }
}
