package com.cfs.Weather_App.dto;

public class WeatherResponse {

    private String city;
    private String region;
    private String country;
    private String condition;
    private Double temperature;

    // extra fields used by the Thymeleaf UI
    private String iconUrl;
    private Double feelsLike;
    private Integer humidity;
    private Double windKph;
    private String localTime;

    public WeatherResponse() {
    }

    public WeatherResponse(String city, String region, String country, String condition, Double temperature) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.condition = condition;
        this.temperature = temperature;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }

    public Double getFeelsLike() { return feelsLike; }
    public void setFeelsLike(Double feelsLike) { this.feelsLike = feelsLike; }

    public Integer getHumidity() { return humidity; }
    public void setHumidity(Integer humidity) { this.humidity = humidity; }

    public Double getWindKph() { return windKph; }
    public void setWindKph(Double windKph) { this.windKph = windKph; }

    public String getLocalTime() { return localTime; }
    public void setLocalTime(String localTime) { this.localTime = localTime; }
}
