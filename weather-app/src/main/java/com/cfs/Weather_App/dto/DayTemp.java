package com.cfs.Weather_App.dto;

public class DayTemp {

    private String date;
    private Double minTemp;
    private Double avgTemp;
    private Double maxTemp;

    // extra fields used by the Thymeleaf UI
    private String condition;
    private String iconUrl;
    private Integer chanceOfRain;

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Double getMinTemp() { return minTemp; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }

    public Double getAvgTemp() { return avgTemp; }
    public void setAvgTemp(Double avgTemp) { this.avgTemp = avgTemp; }

    public Double getMaxTemp() { return maxTemp; }
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }

    public Integer getChanceOfRain() { return chanceOfRain; }
    public void setChanceOfRain(Integer chanceOfRain) { this.chanceOfRain = chanceOfRain; }
}
