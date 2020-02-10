package application;

import java.util.Random;

public class Thermometer implements Sensor{
    //Object attributes/instance vars
    private boolean thermIsOn;
    private Random rand;

    //Object constructors
    public Thermometer(){
        this.thermIsOn = false;
        this.rand = new Random();
    }

    //Object methods
    /*Returns true or false indicating if the sensor is on*/
    @Override
    public boolean isOn() {
        return this.thermIsOn;
    }

    /*Sets the sensors state to true indicating it's on*/
    @Override
    public void on() {
        this.thermIsOn = true;
    }

    /*Sets the sensors state to false indicating it's off*/
    @Override
    public void off() {
        this.thermIsOn = false;
    }

    /*If the sensor is on, a random # between -30 and 30 is returned.  If sensor is off, it throws an
    IllegalStateExecption to the user.
     */
    @Override
    public int measure() {
        int measure = 0;

        if(!this.thermIsOn)
            throw new IllegalStateException("Thermometer can not be in an off state");

        if(this.thermIsOn)
            measure = this.rand.nextInt((30 + 30) + 1) - 30;

        return measure;
    }
}
