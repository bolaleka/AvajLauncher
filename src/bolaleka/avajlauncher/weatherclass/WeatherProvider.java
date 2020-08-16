package bolaleka.avajlauncher.weatherclass;

import bolaleka.avajlauncher.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private String[] weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};

    private static void WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        System.out.println("hoping" + coordinates.getLongitude());
        return weather[0];
        //int totalCoord = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() % 4;

        // if(totalCoord <= 10) {
        //     return weather[3];
        // }else if(totalCoord > 10 && totalCoord <= 24) {
        //     return weather[2];
        // }else if(totalCoord > 24 && totalCoord <= 29) {
        //     return weather[1];
        // }else {
        //     return weather[0];
        // }
        // if((coordinates.getLongitude() += 10) && (coordinates.getHeight() += 2) ){
        //     System.out.println(weather[0]);
        //     return weather[0];
        // }
    }


}