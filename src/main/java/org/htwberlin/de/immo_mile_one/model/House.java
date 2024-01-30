package org.htwberlin.de.immo_mile_one.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //TODO Add new Table for House Images and House
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<HouseImage> getHouseImages() {
        return houseImages;
    }

    public void setHouseImages(Set<HouseImage> houseImages) {
        this.houseImages = houseImages;
    }

    @ManyToMany()
    @JoinTable(
            name = "person_apply_house",
            joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> person_apply_house;

    public Set<Person> getPerson_apply_house() {
        return person_apply_house;
    }

    public void setPerson_apply_house(Set<Person> person_apply_house) {
        this.person_apply_house = person_apply_house;
    }


    public Person getMyHome() {
        return myHome;
    }

    public void setMyHome(Person myHome) {
        this.myHome = myHome;
    }

    @OneToMany
    @JoinColumn(name="house_image_id")
    private Set<HouseImage> houseImages;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private Person myHome;

    private int floor;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    private int room;
    private double price;
    private String location;
    private String postalCode;
    private Date available;
    private Boolean lift;
    public int getRoom(){
        return room;
    }
    public void setRoom( int room){
        this.room= room;
    }
    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAvailable() {
        return available;
    }

    public void setAvailable(Date available) {
        this.available = available;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getLift() {
        return lift;
    }

    public void setLift(Boolean lift) {
        this.lift = lift;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode ;
    }

}
