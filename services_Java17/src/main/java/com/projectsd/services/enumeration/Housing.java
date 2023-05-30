package com.projectsd.services.enumeration;

public enum Housing {

    Apartment("Apartment"),
    House("House"),
    Villa("Villa"),
    Mansion("Mansion");

    private final String housing;

    Housing(String housing) {
        this.housing = housing;
    }

    public String getHousing() {
        return this.housing;
    }
}
