package bolaleka.avajlauncher.aircraft;

import bolaleka.avajlauncher.weatherclass.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

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

        if(weather.equals("SUN")) {
            System.out.println("What kind of sun is shinning today");
           //coordinates(this.longitude+10, this.latitude+0, this.height+2);
        }else if(weather.equals("RAIN")) {
            System.out.println("Raining period, let get some coffee");
           // coordinates(longitude+5, latitude, height);
        }else if(weather.equals("FOG")) {
            System.out.println("The weather is not clear, it will be difficult to land");
          //  coordinates(longitude+1, latitude, heigh);
        }else if(weather.equals("SNOW")) {
            System.out.println("Need to be aware of the white snow");
           // coordinates(longitude, latitude, height-12);
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