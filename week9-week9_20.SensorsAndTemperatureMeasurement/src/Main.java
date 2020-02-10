import application.AverageSensor;
import application.ConstantSensor;
import application.Sensor;
import application.Thermometer;

public class Main {
    public static void main(String[] args){
        ConstantSensor ten = new ConstantSensor(10);
        ConstantSensor minusFive = new ConstantSensor(-5);

        System.out.println( ten.measure() );
        System.out.println( minusFive.measure() );

        System.out.println( ten.isOn() );
        ten.off();
        System.out.println( ten.isOn() );

        Sensor kumpula = new Thermometer();
        kumpula.on();
        System.out.println("the temperature in Kumpula is " + kumpula.measure() + " degrees");

        Sensor kaisaniemi = new Thermometer();
        Sensor helsinkiVantaa = new Thermometer();

        AverageSensor helsinkiArea = new AverageSensor();
        helsinkiArea.addSensor(kumpula);
        helsinkiArea.addSensor(kaisaniemi);
        helsinkiArea.addSensor(helsinkiVantaa);

        helsinkiArea.on();
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");

        System.out.println("readings: "+helsinkiArea.readings());

        AverageSensor ka = new AverageSensor();
        ka.addSensor( new ConstantSensor(4) );
        ka.addSensor( new ConstantSensor(5) );
        ka.addSensor( new ConstantSensor(9) );
        System.out.println(ka.measure());

        AverageSensor ka2 = new AverageSensor();
        ka2.addSensor( new ConstantSensor(3) );
        ka2.addSensor( new ConstantSensor(7) );
        System.out.println(ka2.readings());
    }
}
