package application;

public class ConstantSensor implements Sensor {
    //Object attributes/instance vars
    private int measure;

    //Object constructors
    public ConstantSensor(int measure){
        this.measure = measure;
    }

    //Object methods
    /*Returns sensor measure number*/
    public int getMeasure(){
        return this.measure;
    }

    /*ConstantSensor objects always have an on state represented by true*/
    @Override
    public boolean isOn(){
        return true;
    }

    @Override
    public void on(){
        //do nothing
    }

    @Override
    public void off(){
        //do nothing
    }

    /*Returns objects measure*/
    @Override
    public int measure(){
        return getMeasure();
    }
}
