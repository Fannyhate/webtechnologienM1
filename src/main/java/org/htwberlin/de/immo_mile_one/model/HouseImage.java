package org.htwberlin.de.immo_mile_one.model;

import jakarta.persistence.*;

@Entity
public class HouseImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String urlImg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }


}

