package bolaleka.avajlauncher;

import bolaleka.avajlauncher.weatherclass.WeatherTower;
import bolaleka.avajlauncher.aircraft.Flyable;
import bolaleka.avajlauncher.aircraft.AircraftFactory;

import java.io.*;
import java.util.*;
import java.lang.*;

public class SimulatorMain{
    public static void main(String[] args) {

        WeatherTower gettower = new WeatherTower();
        try {
            if(args.length != 1) {
                System.out.println("Invalid argument");
                System.exit(1);
            }

            BufferedReader readFile = new BufferedReader(new FileReader(args[0]));
            String line = readFile.readLine();
            Flyable air;
            if(!args[0].equalsIgnoreCase("scenario.txt")){
                System.out.println("Not a valid file name");
                System.exit(1);
            }
            if(line != null) { 
               int simCount = Integer.parseInt(line.split(" ")[0]);
                if(simCount <= 0) {
                    System.out.println(simCount+" is an invalid number of time weather changes");
                    System.exit(1);
                }
                File createFile = new File("simulation.txt");  
                FileOutputStream returnOutput = new FileOutputStream(createFile);  
                System.setOut(new PrintStream (returnOutput));       
                while((line = readFile.readLine()) != null) {

                    if(line.split(" ").length != 5){
                        System.out.println("wrong format");
                        System.exit(1);
                    }
                    String[] getlinecolumn = line.split(" ");
                    int longitude = Integer.parseInt(line.split(" ")[2]);
                    int latitude = Integer.parseInt(line.split(" ")[3]);
                    int height = Integer.parseInt(line.split(" ")[4]);

                    air = AircraftFactory.newAircraft(getlinecolumn[0], getlinecolumn[1], longitude, latitude, height);
            
                    gettower.register(air);
                    air.registerTower(gettower);

                } 
                for(int i = 1; i <= simCount; i++) {
                    gettower.changeWeather();
                } 

            }
           readFile.close();        
        } catch (Exception e) {
            System.out.println("An error occur");
        }  
 
    }
}