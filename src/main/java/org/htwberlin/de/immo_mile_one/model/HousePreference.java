package org.htwberlin.de.immo_mile_one.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HousePreference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double maxPrice;

    private String location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public boolean isHasLift() {
        return hasLift;
    }

    public void setHasLift(boolean hasLift) {
        this.hasLift = hasLift;
    }

    private int numberOfRoom;
    private boolean hasLift;
}
