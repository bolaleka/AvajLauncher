package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public String toString(){
        // fl.forEach(s -> System.out.println(Arrays.toString((String[]) s )));
        return String.format("Tower says: JetPlane#%s(%d)", name, id);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        int hi = coordinates.getHeight();
        int lon = coordinates.getLongitude();
        int lat = coordinates.getLatitude();

        if(weather.equals("SUN")) {
            System.out.println("JetPlane#"+name + "(" + id +"):" +" What kind of sun is shinning today(Jet)");
            new Coordinates(lon, lat+10, hi+2);
        }else if(weather.equals("RAIN")) {
            System.out.println("JetPlane#"+name + "(" + id +"):" +" Raining period, let get some coffee(Jet)");
           new Coordinates(lon, lat+5, hi);
        }else if(weather.equals("FOG")) {
            System.out.println("JetPlane#"+name + "(" + id +"):" +" The weather is not clear, it will be difficult to land(Jet)");
          new Coordinates(lon+1, lat+1, hi);
        }else if(weather.equals("SNOW")) {
            System.out.println("JetPlane#"+name + "(" + id +"):"+" Need to be aware of the white snow(Jet)");
           new Coordinates(lon, lat, hi-7);
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