# Weather-App-
A Spring Boot weather web app with Thymeleaf. Search any city for current conditions and a multi-day forecast.

Weather Web Application is a Java full-stack project built with Spring Boot and Thymeleaf. Users enter a city name and choose how many forecast days they want. The app then fetches live data from the WeatherAPI.com REST service and shows it on a clean, responsive dashboard.

Features :
Search weather by city name
Current conditions: temperature, “feels like”, humidity, wind speed, local time and a weather icon
Forecast for up to 7 days, with min, max and average temperature, condition and chance of rain
Server-side rendered UI with Thymeleaf and custom CSS (dark theme, mobile-friendly)
Friendly error messages for invalid cities or API failures
REST endpoints that return JSON for the same data:
GET /weather/my/{city}
GET /weather/forecast?city=...&days=...

Tech stack :
Java 17, Spring Boot 3, Spring MVC
Thymeleaf, HTML, CSS
RestTemplate for calling the external API
Maven
WeatherAPI.com

Architecture :
Controller → Service → External API, with DTOs mapping the API’s JSON to clean response objects. The Thymeleaf controller renders the HTML page, and the REST controller exposes the JSON endpoints.

What it demonstrates :

Consuming a third-party REST API
Layered Spring Boot architecture (controller, service, DTO)
Server-side rendering with Thymeleaf templates
Externalized configuration and API key handling

