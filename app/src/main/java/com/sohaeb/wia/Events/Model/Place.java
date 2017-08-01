package com.sohaeb.wia.Events.Model;

/**
 * Created by may on 2017-07-10.
 */

public class Place {

    private String name;
    private Location location;

    public Place() {

    }

    public Place(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
