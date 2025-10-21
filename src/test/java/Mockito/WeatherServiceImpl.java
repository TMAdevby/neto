package Mockito;

import org.example.Mockito.Weather;
import org.example.Mockito.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class WeatherServiceImpl implements WeatherService {
    @Override
    public Weather currentWeather() {
        return Weather.SUNNY;
    }

    @Test
    void test_spy_weather_service() {
        WeatherService weatherService = Mockito.spy(WeatherServiceImpl.class);
        Assertions.assertEquals(Weather.SUNNY, weatherService.currentWeather());
    }
}
