package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();
    private int curHeight;
    private int sunhi;
    private int snowhi;
    private int rainlon;
    private int foglon;
    private int lon;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString(){
        return String.format("Tower says: Helicopter#%s(%d)", name, id);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);

        if(weather.equals("SUN")) {
            sunhi = sunhi + 2;
            lon = lon + 10;
            curHeight = sunhi + coordinates.getHeight();
            if(curHeight > 100) {
                curHeight = 100;
                System.out.println("Helicopter#"+name + "(" + id +"):"+ " This weather is Hot");
            }else {
               System.out.println("Helicopter#"+name + "(" + id +"):"+ " This weather is Hot");
            }
        }else if(weather.equals("RAIN")) {
            rainlon = rainlon + 5;
            System.out.println("Helicopter#"+name + "(" + id +"):" +" Raining period, let get some coffee");
        }else if(weather.equals("FOG")) {
            foglon = foglon + 1;
            System.out.println("Helicopter#"+name + "(" + id +"):" +" The weather is not clear, it will be difficult to land ");
        }else if(weather.equals("SNOW")) {
            snowhi = snowhi - 12;
            curHeight = snowhi + coordinates.getHeight();
           if(curHeight > 100) {
               curHeight = 100;
               System.out.println("Helicopter#"+name + "(" + id +"):"+  " Need to be aware of the white snow " );
           }else {
               System.out.println("Helicopter#"+name + "(" + id +"):" + " Need to be aware of the white snow ");
           }
        }
        if(curHeight <= 0){
            curHeight = 0;
            System.out.println("JetPlane#"+ name + "(" + id +")  " + "Landing." );
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
         this.weatherTower = weatherTower;
    }
}