package bolaleka.avajlauncher.weatherclass;


import bolaleka.avajlauncher.aircraft.Flyable;
import java.util.*;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable) {
         observers.add(flyable);
         System.out.println(flyable + " registered to weather tower.");
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
        System.out.println(flyable + " Unregisterd from weather tower.");
    }

    protected void conditionsChanged(){

        int i = 0;
        while(i < observers.size()) {
            observers.get(i).updateConditions();
            i++;
        }

    }

}