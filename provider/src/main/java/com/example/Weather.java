package com.example;

public class Weather {

    private final Integer id;
    private final String name;
    private final Integer timezone;
    private final Wind wind;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public Wind getWind() {
        return wind;
    }

    public Weather(Integer id, String name, Integer timezone, Wind wind) {
        this.id = id;
        this.name = name;
        this.timezone = timezone;
        this.wind = wind;
    }
}
