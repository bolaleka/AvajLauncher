package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();
    private int curHeight;
    private int sunhi;
    private int snowhi;
    private int rainhi;
    private int foghi;
    private int lon;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString(){
        return String.format("Tower says: Baloon#%s(%d)", name, id);
    }

    public void updateConditions(){ 
        String weather = weatherTower.getWeather(coordinates);

        if(weather.equals("SUN")) {
            sunhi = sunhi + 4;
            lon = lon + 2;
            curHeight = sunhi + coordinates.getHeight();
            if(curHeight > 100) {
                curHeight = 100;
                System.out.println("Baloon#"+name + "(" + id +"):"+ " This weather is Hot(Baloon)" + curHeight );
            }else {
               System.out.println("Baloon#"+name + "(" + id +"):"+ " This weather is Hot(Baloon)" + curHeight);
            }
        }else if(weather.equals("RAIN")) {
            rainhi = rainhi - 5;
            curHeight = rainhi + coordinates.getHeight();
            if(curHeight > 100) {
                curHeight = 100;
                System.out.println("Baloon#"+name + "(" + id +"):"+ " Raining period, let get some coffee(Baloon)" + curHeight );
            }else{
                System.out.println("Baloon#"+name + "(" + id +"):"+ " Raining period, let get some coffee(Baloon)"+curHeight);
            }
        }else if(weather.equals("FOG")) {
            foghi = foghi - 3;
             curHeight = foghi + coordinates.getHeight();
            if(curHeight > 100) {
                curHeight = 100;
                System.out.println("Baloon#"+name + "(" + id +"):"+ " The weather is not clear, it will be difficult to land (Baloon)" + curHeight );
            }else{
                System.out.println("Baloon#"+name + "(" + id +"):"+ " The weather is not clear, it will be difficult to land (Baloon)"+curHeight);  
            }
        }else if(weather.equals("SNOW")) {
            snowhi = snowhi - 15;
             curHeight = sunhi + coordinates.getHeight();
            if(curHeight > 100) {
                curHeight = 100;
                System.out.println("Baloon#"+name + "(" + id +"):"+  " Need to be aware of the white snow (Baloon)" + curHeight );
            }else {
                System.out.println("Baloon#"+name + "(" + id +"):" + " Need to be aware of the white snow (Baloon)" + curHeight);
            }
        }

        if(curHeight <= 0){
            curHeight = 0;
            System.out.println("Baloon#"+ name + "(" + id +")  " + "Landing." + curHeight );
            weatherTower.unregister(this);
        }

    }

    public void registerTower(WeatherTower weatherTower){
         this.weatherTower = weatherTower;
    }
}