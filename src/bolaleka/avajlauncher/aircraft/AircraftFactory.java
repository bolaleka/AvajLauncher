package bolaleka.avajlauncher.aircraft;

import java.lang.*;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        
        Coordinates getCoord = new Coordinates(longitude, latitude, height);

        if(type.equalsIgnoreCase("Baloon")) {
           return new Baloon(name, getCoord);
        }else if(type.equalsIgnoreCase("Helicopter")) {
            return new Helicopter(name, getCoord);
        }else if(type.equalsIgnoreCase("JetPlane")){
            return new JetPlane(name, getCoord);
        } else {
            return null;
        }  
    }
}