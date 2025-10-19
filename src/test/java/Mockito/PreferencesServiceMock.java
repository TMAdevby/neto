package Mockito;

import org.example.Mockito.Preference;
import org.example.Mockito.PreferencesService;

import java.util.Set;

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
