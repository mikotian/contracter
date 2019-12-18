package com.example;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
@Controller("/weather")
public class WeatherController {
    @Get(value="/1234",produces="application/json; charset=UTF-8")
    public Weather get(){
        return new Weather(1851632,"Shuzenji",32400,new Wind(107.538F,0.47F));
    }
}
