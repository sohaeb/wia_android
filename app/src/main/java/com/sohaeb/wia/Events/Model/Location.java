package com.sohaeb.wia.Events.Model;

/**
 * Created by may on 2017-07-10.
 */

public class Location {

    private String city, country, street, state, zip;
    private Double longitude, latitude;

    public Location() {
    }

    public Location(String city, String country, String street, String state, String zip, Double longitude, Double latitude) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.state = state;
        this.zip = zip;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }


}
