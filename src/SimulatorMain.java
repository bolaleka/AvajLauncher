package bolaleka.avajluncher;

import bolaleka.avajluncher.*;

import java.io.*;
import java.util.*;
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
            if(line != null) { 
                int simulation = Integer.parseInt(line.split(" ")[0]);
                if(simulation < 0) {
                    System.out.println(simulation+" is an invalid number of time weather changes");
                    System.exit(1);
                }
            }
            while((line = readFile.readLine()) != null) {
                System.out.println(line);
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