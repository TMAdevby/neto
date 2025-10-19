package Mockito;

import org.example.Mockito.AdviceService;
import org.example.Mockito.Preference;
import org.example.Mockito.PreferencesService;
import org.example.Mockito.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;
class AdviceServiceTest {
    @Test
    void test_get_advice_in_bad_weather() {
        WeatherService weatherService = ?
        PreferencesService preferencesService = ?;
        AdviceService adviceService = new AdviceService(preferencesService, weatherService);
        Set<Preference> preferences = adviceService.getAdvice("user1");
        Set<Preference> expected = Set.of(Preference.READING, Preference.WATCHING_FILMS);
        Assertions.assertEquals(expected, preferences);
    }
}

