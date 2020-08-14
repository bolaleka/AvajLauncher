package bolaleka.avajluncher.aircraft;

import bolaleka.avajluncher.tower.*;

public interface Flyable{

    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
