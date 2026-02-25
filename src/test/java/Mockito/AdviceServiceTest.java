package Mockito;

import org.example.Mockito.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
class AdviceServiceTest {
    @Test
    void test_get_advice_in_bad_weather() {
        // это ручной способ, создали Mock классы под него
        //задали погоду
        WeatherServiceMock weatherService = new WeatherServiceMock();
        weatherService.setValue(Weather.STORMY);
        // задали увлечения
        PreferencesServiceMock preferencesService = new PreferencesServiceMock();
        preferencesService.setValue(Set.of(Preference.FOOTBALL, Preference.WATCHING_FILMS,
                Preference.READING));
        //создали объект тестируемого класса
        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        // вызвали его метод, получили отфильтрованный список интересов
        Set<Preference> preferences = adviceService.getAdvice("user1");
        // задали ожидаемый список
        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);
        //сравнили
        Assertions.assertEquals(expected, preferences);
    }

    @Test
    void test_get_advice_in_bad_weather_mockito() {
        // это способ с Mockito. Образом ниже создаем классы и назначаем им данные
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        // "Когда вызовут currentWeather() → верни STORMY"
        Mockito.when(weatherService.currentWeather())
                //назначаем им данные
                .thenReturn(Weather.STORMY);

        PreferencesService preferencesService = Mockito.mock(PreferencesService.class);
        // "Когда вызовут get(ЛЮБАЯ_СТРОКА) → верни этот набор"
        Mockito.when(preferencesService.get(Mockito.any()))
                //назначаем им данные
                .thenReturn(Set.of(Preference.FOOTBALL, Preference.WATCHING_FILMS, Preference.READING));

        //создали объект тестируемого класса
        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        // вызвали его метод, получили отфильтрованный список интересов
        Set<Preference> preferences = adviceService.getAdvice("Петя");
        // задали ожидаемый список
        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);
        //сравнили
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
        // 1. Создаем «капкан» для типа String
        // 2. Говорим verify: "Когда будешь проверять метод get() — ПОЙМАЙ аргумент в капкан"
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        //Этот метод проверяет факт взаимодействия между объектами. Он отвечает на вопрос: «Был ли вызван этот метод на
        // мок-объекте, и если да, то сколько раз?».
        // verify() убеждается, что метод get() был вызван
        // .capture() кладет аргумент вызова в captor
        Mockito.verify(preferencesService).get(argumentCaptor.capture());
        // 🔥 5. АНАЛИЗ: Проверяем, что именно поймали/
        Assertions.assertEquals("user1", argumentCaptor.getValue());
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
        //Этот метод проверяет факт взаимодействия между объектами. Он отвечает на вопрос: «Был ли вызван этот метод на
        // мок-объекте, и если да, то сколько раз?».
        Mockito.verify(weatherService, Mockito.times(2)).currentWeather();
        Mockito.verify(preferencesService, Mockito.times(1)).get("user1");
        Mockito.verify(preferencesService, Mockito.times(1)).get("user2");
        Mockito.verify(preferencesService, Mockito.times(2)).get(Mockito.anyString());
    }
}


