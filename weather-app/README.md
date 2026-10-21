# 🌦️ Weather Web Application (Spring Boot + Thymeleaf)

Search a city and view current weather plus an N-day forecast.
Pages are rendered server-side with **Thymeleaf**; the original REST endpoints are kept.

## Run

1. Get a free API key from https://www.weatherapi.com
2. Set it (either way):
   - environment variable: `WEATHER_API_KEY=your_key`
   - or edit `src/main/resources/application.properties`
3. Start the app:
   ```
   mvn spring-boot:run
   ```
4. Open http://localhost:8080

> The free WeatherAPI plan supports forecasts up to 3 days; paid plans allow more.
> If you only have a free key, pick 1–3 days.

## Structure

```
src/main/java/com/cfs/Weather_App
├── WeatherAppApplication.java
├── controller
│   ├── WeatherController.java        # REST  -> /weather/my/{city}, /weather/forecast
│   └── WeatherViewController.java    # Thymeleaf -> /
├── service/WeatherService.java
└── dto/...
src/main/resources
├── application.properties
├── templates/index.html              # Thymeleaf template
└── static/css/style.css
```

## Author
Aftab Alam Khan
