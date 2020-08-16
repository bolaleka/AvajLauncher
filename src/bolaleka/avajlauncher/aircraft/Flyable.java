package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.*;

public interface Flyable{

    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
