package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public String toString(){
        // fl.forEach(s -> System.out.println(Arrays.toString((String[]) s )));
        return String.format("Tower says: Helicopter#%s(%d)", name, id);
    }

    
    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        int hi = coordinates.getHeight();
        int lon = coordinates.getLongitude();
        int lat = coordinates.getLatitude();

        if(weather.equals("SUN")) {
            System.out.println("Helicopter#"+name + "(" + id +"):" +" What kind of sun is shinning today(Helicopter)");
           new Coordinates(lon+10, lat, hi+2);
        }else if(weather.equals("RAIN")) {
            System.out.println("Helicopter#"+name + "(" + id +"):" +" Raining period, let get some coffee(Helicopter)");
            new Coordinates(lon+5, lat, hi);
        }else if(weather.equals("FOG")) {
            System.out.println("Helicopter#"+name + "(" + id +"):" +" The weather is not clear, it will be difficult to land (Helicopter)");
            new Coordinates(lon+1, lat, hi);
        }else if(weather.equals("SNOW")) {
            System.out.println("Helicopter#"+name + "(" + id +"):" +" Need to be aware of the white snow (Helicopter)");
            new Coordinates(lon, lat, hi-12);
        }

        // if(coordinates.getHeight() < 0){
        //     coordinates.getHeight() = 0;
        //     System.out.println("Aircraft landed at 0 height");
        // }else if(coordinates.getHeight() > 100){
        //     coordinates.getHeight() = 100;
        // }
    }

    public void registerTower(WeatherTower weatherTower){
         this.weatherTower = weatherTower;
    }
}