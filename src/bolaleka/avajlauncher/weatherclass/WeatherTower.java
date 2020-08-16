package bolaleka.avajlauncher.weatherclass;

import bolaleka.avajlauncher.aircraft.Coordinates;

public class WeatherTower extends Tower {
    WeatherProvider getnewProvider = WeatherProvider.getProvider();

    public String getWeather(Coordinates coordinates) {

         return getnewProvider.getCurrentWeather(coordinates);
    }

    private void changeWeather() {
        conditionsChanged();
    }
}