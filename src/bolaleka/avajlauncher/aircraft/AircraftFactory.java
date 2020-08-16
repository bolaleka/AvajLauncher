package bolaleka.avajlauncher.aircraft;

//import bolaleka.avajlauncher.aircraft.*;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        
        Coordinates getCoord = new Coordinates(longitude, latitude, height);

        if(type.equals("Baloon")) {
           return new Baloon(name, getCoord);
        }else if(type.equals("Helicopter")) {
            return new Helicopter(name, getCoord);
        }else if(type.equals("JetPlane")){
            return new JetPlane(name, getCoord);
        } else {
            System.out.println("Cannot find such Aircraft in the factory");
            return new Helicopter(name, getCoord);
        }
        
    }
}