package bolaleka.avajlauncher;

import bolaleka.avajlauncher.weatherclass.WeatherTower;
import bolaleka.avajlauncher.aircraft.Flyable;
import bolaleka.avajlauncher.aircraft.AircraftFactory;

import java.io.*;
import java.util.*;
import java.util.stream.*; 
import java.lang.*;

public class SimulatorMain{

    public static void main(String[] args) {
        
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(args[0]));
            String line = readFile.readLine();
            int i = 0;

            if(!(args.length == 1 && args[0].equals("scenario.txt"))) {
                System.out.println("Invalid argument");
                System.exit(1);
            }

            try{
                    if(line != null) { 
                        int simulation = Integer.parseInt(line.split(" ")[0]);
                        if(simulation < 0) {
                            System.out.println(simulation+" is an invalid number of time weather changes");
                            System.exit(1);
                        }
                    }
             } catch(Exception e) {
                 System.out.println("Simulation Exception error not yetimplemented");
             }

            WeatherTower gettower = new WeatherTower();
            while((line = readFile.readLine()) != null) {
                
                String[] getlinecolumn = line.split(" ");
                int longitude = Integer.parseInt(line.split(" ")[2]);
                int latitude = Integer.parseInt(line.split(" ")[3]);
                int height = Integer.parseInt(line.split(" ")[4]);

                Flyable air = AircraftFactory.newAircraft(getlinecolumn[0], getlinecolumn[1], longitude, latitude, height);

                gettower.register(air);
                air.registerTower(gettower);

            }         
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }     
    }
}

// public class readFile {
     
//     public static void main(String[] args) { 
//       try {
//           BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//           String airType = null;
//           String airName;
//           String longitude;
//           String latitude;
//           String height;
//           String weth = null;
          
//           String line = reader.readLine();

//           if(line != null) { 
//             int simulation = Integer.parseInt(line.split(" ")[0]);
//             if(simulation < 0) {
//               System.out.println("invalid simulation count" + simulation );
//               System.exit(1);
//             }
//             int i = 0;
//             while((line = reader.readLine()) != null) {
//               i++;
//               airType = line.split("\\s+")[0];
//               airName = line.split("\\s+")[1];
//               longitude = line.split("\\s+")[2];
//               longitude = line.split("\\s+")[3];
//               height = line.split("\\s+")[4];
//               System.out.println("Tower says: " + airType+ "#" + airName +"(" + i + ")"+ " "+ "registered to weather tower.");
//              // System.out.println(airType+ "#" + airName +"(" + i + ")"+ " "+ "registered to weather tower.");          
//             }
              
//           }
//       } catch (Exception e) {
//         System.out.println("An error occurred.");
//         e.printStackTrace();
//       } 
//     }  
//   } 