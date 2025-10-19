package org.example.Mockito;

public enum Weather {
    RAINY("Дождливо"),
    STORMY("Сильный ветер"),
    SUNNY("Солнечно"),
    CLOUDY("Облачно");

    private String weather;

    Weather(String weather) {
        this.weather = weather;
    }
}
