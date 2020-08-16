package bolaleka.avajlauncher.aircraft;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Coordinates{

    // Instance variale.
    private int longitude;
    private int latitude;
    private int height;
    
    //private coordinates method.
    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height= height;
    }

    //Get longitude method.
    public int getLongitude() {
       return this.longitude;
    }

    //Get latitude method.
    public int getLatitude() {
        return this.latitude;
    }

    //Get height method.
    public int getHeight() {
        return this.height;
    }
   
}