package com.cfs.Weather_App.controller;

import com.cfs.Weather_App.dto.WeatherForeCast;
import com.cfs.Weather_App.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

/**
 * Thymeleaf (server-side rendered) controller.
 * The REST endpoints in WeatherController (/weather/...) still work as before.
 */
@Controller
public class WeatherViewController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String city,
                        @RequestParam(defaultValue = "3") int days,
                        Model model) {

        model.addAttribute("city", city == null ? "" : city);
        model.addAttribute("days", days);

        if (city == null || city.isBlank()) {
            return "index";
        }

        try {
            WeatherForeCast forecast = weatherService.getForeCast(city.trim(), days);
            model.addAttribute("current", forecast.getWeatherResponse());
            model.addAttribute("forecast", forecast.getDayTemp());
        } catch (HttpClientErrorException e) {
            model.addAttribute("error", "Could not find weather for \"" + city
                    + "\". Check the city name and your API key.");
        } catch (RestClientException e) {
            model.addAttribute("error", "Weather service is unavailable right now. Please try again later.");
        }

        return "index";
    }
}
