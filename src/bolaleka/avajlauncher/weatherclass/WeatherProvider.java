package bolaleka.avajlauncher.weatherclass;

import bolaleka.avajlauncher.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private String[] weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};

    private static void WeatherProvider(){}

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        
        int totalCoord = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        if(totalCoord <= 10) {
            return weather[3];
        }else if(totalCoord > 10 && totalCoord <= 24) {
            return weather[2];
        }else if(totalCoord > 24 && totalCoord <= 29) {
            return weather[1];
        }else if(totalCoord > 29){
            return weather[0];
        }else {
            return ("invalid condinates\n");
        }

    }
}