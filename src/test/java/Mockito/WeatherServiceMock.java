package Mockito;

import org.example.Mockito.Weather;
import org.example.Mockito.WeatherService;
// Это ручной способ тестирования
// Создаем Mock, он реализует WeatherService
// используем его в AdviceServiceTest в методе test_get_advice_in_bad_weather()
// Mock-и эмитируют работу реальных классов, они не всегда копия этих классов, это заглушка, если например класс пишет в
// базу, то mock меняем и он не пишет
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
