package com.sohaeb.wia.Events.Model;

/**
 * Created by may on 2017-07-10.
 */

public class Event {

    private String name;
    private String start_time;
    private String end_time;
    private String description;
    private Cover cover;
    private com.sohaeb.wia.Events.Model.Place place;
    private String id;

    public Event() {
    }

    public Event(String name, String start_time, String end_time, String description, Cover cover, com.sohaeb.wia.Events.Model.Place place, String id) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
        this.cover = cover;
        this.place = place;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public com.sohaeb.wia.Events.Model.Place getPlace() {
        return place;
    }

    public Cover getCover() {
        return cover;
    }

    public String getName() {
        return name;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getDescription() {
        return description;
    }

}
