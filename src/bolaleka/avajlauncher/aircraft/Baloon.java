package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.WeatherTower;
import bolaleka.avajlauncher.weatherclass.Tower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();
    private Tower newTower = new Tower();
    private Flyable flyable;
    

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString(){
        // fl.forEach(s -> System.out.println(Arrays.toString((String[]) s )));
        return String.format("Tower says: Baloon#%s(%d)", name, id);
    }

    public void updateConditions(){
        
        String weather = weatherTower.getWeather(coordinates);
        int hi = coordinates.getHeight();
        int lon = coordinates.getLongitude();
        int lat = coordinates.getLatitude();

        if(hi > 100 ){
            hi = 100;
        }else if(hi < 0) {
            hi = 0;
            System.out.println("Baloon#"+name + "(" + id +"):" + "landing");
            newTower.unregister(flyable);
        }

        if(weather.equals("SUN")) {
            System.out.println("Baloon#"+name + "(" + id +"):"+ " What kind of sun is shinning today(Baloon)");
            new Coordinates(lon+2, lat, hi+4);
        }else if(weather.equals("RAIN")) {
            System.out.println("Baloon#"+name + "(" + id +"):"+ " Raining period, let get some coffee(Baloon)");
            new Coordinates(lon, lat, hi-5);
        }else if(weather.equals("FOG")) {
            System.out.println("Baloon#"+name + "(" + id +"):"+ " The weather is not clear, it will be difficult to land (Baloon)");
            new Coordinates(lon, lat, hi-3);
        }else if(weather.equals("SNOW")) {
            System.out.println("Baloon#"+name + "(" + id +"):" + " Need to be aware of the white snow (Baloon)");
            new Coordinates(lon, lat, hi-15);
        }

    }

    public void registerTower(WeatherTower weatherTower){
         this.weatherTower = weatherTower;
    }
}