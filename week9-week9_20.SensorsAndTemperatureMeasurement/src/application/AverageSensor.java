package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    //Object attributes/instance vars
    private List<Sensor> allSensors;
    private List<Integer> allReadings;

    //Object constructors
    public AverageSensor(){
        this.allSensors = new ArrayList<Sensor>();
        this.allReadings = new ArrayList<Integer>();
    }

    //Object methods
    //Adds a new sensor object ot the arrayList
    public void addSensor(Sensor additional){
        this.allSensors.add(additional);
    }

    //Return the arrayListof all readings
    public List<Integer> readings(){
        return this.allReadings;
    }

    /*Determins if sensor is on.  Returns true if on, false if off*/
    @Override
    public boolean isOn() {
        for(Sensor sensor : this.allSensors){
            if(!sensor.isOn())
                return false;
        }

        return true;
    }

    /*Turns all sensors on*/
    @Override
    public void on() {
        for(Sensor sensor : this.allSensors){
            sensor.on();
        }
    }

    /*Turns all sensors off*/
    @Override
    public void off() {
        for(Sensor sensor : this.allSensors){
            sensor.off();
        }
    }

    /*Measures all readings of the sensors and determines the average and returns it*/
    @Override
    public int measure() {
        int totMeasure = 0;

        if(this.allSensors.size() == 0)
            throw new IllegalStateException("No AverageSensor objects have been added");

        if(!isOn())
            throw new IllegalStateException("All sensors must be on");

        for(Sensor sensor : this.allSensors){
            totMeasure += sensor.measure();
        }

        totMeasure /= this.allSensors.size();
        this.allReadings.add(totMeasure);

        return totMeasure;
    }
}
