package Mockito;

import org.example.Mockito.Weather;
import org.example.Mockito.WeatherService;

public class WeatherServiceMock implements WeatherService {
    private Weather value;
    @Override
    public Weather currentWeather() {
        return value;
    }
    public void setValue(Weather value) {
        this.value = value;
    }
}
