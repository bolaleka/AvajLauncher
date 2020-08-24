package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();
    private int curHeight;
    private int sunhi;
    private int snowhi;
    private int rainlon;
    private int foglon;
    private int lat;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString(){
        return String.format("Tower says: JetPlane#%s(%d)", name, id);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
  
        if(weather.equals("SUN")) {
            sunhi = sunhi + 2;
            lat = lat + 10;
            curHeight = sunhi + coordinates.getHeight();
            if(curHeight > 100) {
                curHeight = 100;
                System.out.println("JetPlane#"+name + "(" + id +"):"+ " This weather is Hot(Jet)" + curHeight );
            }else {
               System.out.println("JetPlane#"+name + "(" + id +"):"+ " This weather is Hot(Jet)" + curHeight);
            }
        }else if(weather.equals("RAIN")) {
            rainlon = rainlon + 5;
                System.out.println("JetPlane#"+name + "(" + id +"):"+ " Raining period, let get some coffee(Jet)");
        }else if(weather.equals("FOG")) {
            foglon = foglon + 1;
               System.out.println("JetPlane#"+name + "(" + id +"):"+ " The weather is not clear, it will be difficult to land (Jet)");  
        }else if(weather.equals("SNOW")) {
            snowhi = snowhi - 15;
            curHeight = snowhi + coordinates.getHeight();
           if(curHeight > 100) {
               curHeight = 100;
               System.out.println("JetPlane#"+name + "(" + id +"):"+  " Need to be aware of the white snow (Jet)" + curHeight );
           }else {
               System.out.println("JetPlane#"+name + "(" + id +"):" + " Need to be aware of the white snow (Jet)" + curHeight);
           }
            
        }
        if(curHeight <= 0){
            curHeight = 0;
            System.out.println("JetPlane#"+ name + "(" + id +")  " + "Landing." + curHeight );
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
         this.weatherTower = weatherTower;
    }
}