package Mockito;

import org.example.Mockito.Preference;
import org.example.Mockito.PreferencesService;

import java.util.Set;
// Это ручной способ тестирования
// Создаем Mock, он реализует PreferencesService
// используем его в AdviceServiceTest в методе test_get_advice_in_bad_weather()
// Mock-и эмитируют работу реальных классов, они не всегда копия этих классов, это заглушка, если например класс пишет в
// базу, то mock меняем и он не пишет
public class PreferencesServiceMock implements PreferencesService {

    private Set<Preference> value;
    @Override
    public Set<Preference> get(String userId) {
        return value;
    }
    public void setValue(Set<Preference> value) {
        this.value = value;
    }

}
