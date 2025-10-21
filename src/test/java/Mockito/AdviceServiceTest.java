package Mockito;

import org.example.Mockito.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;
import org.mockito.Mockito;
class AdviceServiceTest {
    @Test
    void test_get_advice_in_bad_weather() {
        WeatherServiceMock weatherService = new WeatherServiceMock();
        weatherService.setValue(Weather.STORMY);

        PreferencesServiceMock preferencesService = new PreferencesServiceMock();
        preferencesService.setValue(Set.of(Preference.FOOTBALL, Preference.WATCHING_FILMS,
                Preference.READING));

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);

        Set<Preference> preferences = adviceService.getAdvice("user1");
        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);

        Assertions.assertEquals(expected, preferences);
    }

    @Test
    void test_get_advice_in_bad_weather_mockito() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        Mockito.when(weatherService.currentWeather())
                .thenReturn(Weather.STORMY);

        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
        Mockito.when(preferencesService.get(Mockito.any()))
                .thenReturn(Set.of(Preference.FOOTBALL, Preference.WATCHING_FILMS, Preference.READING));

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        Set<Preference> preferences = adviceService.getAdvice("Петя");
        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);

        Assertions.assertEquals(expected, preferences);
    }

    @Test
    void test_get_advice_in_bad_weather_mackito_argument_captor() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.STORMY);

        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
        Mockito.when(preferencesService.get(Mockito.any())).thenReturn(Set.of(Preference.FOOTBALL));

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        adviceService.getAdvice("user1");


        Mockito.verify(preferencesService, Mockito.times(1)).get("user1");
        Mockito.verify(preferencesService, Mockito.times(1)).get("user2");
        Mockito.verify(preferencesService, Mockito.times(2)).get(Mockito.anyString());
    }

    @Test
    void test_get_advice_in_bad_weather_verify() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        Mockito.when(weatherService.currentWeather()).thenReturn(Weather.STORMY);

        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
        Mockito.when(preferencesService.get(Mockito.any())).thenReturn(Set.of(Preference.FOOTBALL));

        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        adviceService.getAdvice("user1");
        adviceService.getAdvice("user2");

        Mockito.verify(weatherService, Mockito.times(2)).currentWeather();
        Mockito.verify(preferencesService, Mockito.times(1)).get("user1");
        Mockito.verify(preferencesService, Mockito.times(1)).get("user2");
        Mockito.verify(preferencesService, Mockito.times(2)).get(Mockito.anyString());
    }
}


