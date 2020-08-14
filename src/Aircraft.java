package bolaleka.avajluncher.aircraft;

import bolaleka.avajluncher.*;

public class Aircraft {

    // instance variable
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter =  1;

    //protected Aircract method
    protected Aircraft(String name, Coordinates coordinates){
        this.name =  name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    //Id counter method
    private long nextId() {
        return this.idCounter++;
    }
}
