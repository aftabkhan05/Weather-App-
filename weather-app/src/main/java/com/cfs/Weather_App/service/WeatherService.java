package com.cfs.Weather_App.service;

import com.cfs.Weather_App.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.forecast.key}")
    private String apiforecastKey;

    @Value("${weather.api.forecast.url}")
    private String apiforecastUrl;

    private final RestTemplate template = new RestTemplate();

    public String test() {
        return "App working";
    }

    public WeatherResponse getData(String city) {
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("key", apiKey)
                .queryParam("q", city)
                .build().encode().toUri();

        Root response = template.getForObject(uri, Root.class);
        WeatherResponse weatherResponse = new WeatherResponse();

        weatherResponse.setCity(response.getLocation().getName());
        weatherResponse.setRegion(response.getLocation().getRegion());
        weatherResponse.setCountry(response.getLocation().getCountry());
        weatherResponse.setLocalTime(response.getLocation().getLocaltime());

        Current current = response.getCurrent();
        weatherResponse.setCondition(current.getCondition().getText());
        weatherResponse.setIconUrl(fullIconUrl(current.getCondition().getIcon()));
        weatherResponse.setTemperature(current.getTemp_c());
        weatherResponse.setFeelsLike(current.getFeelslike_c());
        weatherResponse.setHumidity(current.getHumidity());
        weatherResponse.setWindKph(current.getWind_kph());

        return weatherResponse;
    }

    public WeatherForeCast getForeCast(String city, int days) {
        WeatherForeCast response = new WeatherForeCast();
        response.setWeatherResponse(getData(city));

        List<DayTemp> dayList = new ArrayList<>();

        URI uri = UriComponentsBuilder.fromHttpUrl(apiforecastUrl)
                .queryParam("key", apiforecastKey)
                .queryParam("q", city)
                .queryParam("days", days)
                .build().encode().toUri();

        Root apiresponse = template.getForObject(uri, Root.class);
        ForeCast forecast = apiresponse.getForecast();
        for (ForecastDay rs : forecast.getForecastday()) {
            DayTemp d = new DayTemp();
            d.setDate(rs.getDate());
            d.setMinTemp(rs.getDay().getMintemp_c());
            d.setAvgTemp(rs.getDay().getAvgtemp_c());
            d.setMaxTemp(rs.getDay().getMaxtemp_c());
            d.setCondition(rs.getDay().getCondition().getText());
            d.setIconUrl(fullIconUrl(rs.getDay().getCondition().getIcon()));
            d.setChanceOfRain(rs.getDay().getDaily_chance_of_rain());
            dayList.add(d);
        }

        response.setDayTemp(dayList);
        return response;
    }

    /** WeatherAPI returns protocol-relative icon URLs ("//cdn.weatherapi.com/...") */
    private String fullIconUrl(String icon) {
        if (icon == null) return null;
        return icon.startsWith("//") ? "https:" + icon : icon;
    }
}
