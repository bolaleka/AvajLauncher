package bolaleka.avajlauncher.weatherclass;

import bolaleka.avajlauncher.aircraft.Coordinates;

public class WeatherTower extends Tower {
    WeatherProvider getnewProvider = new WeatherProvider();

    public String getWeather(Coordinates coordinates) {
        return getnewProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }
}