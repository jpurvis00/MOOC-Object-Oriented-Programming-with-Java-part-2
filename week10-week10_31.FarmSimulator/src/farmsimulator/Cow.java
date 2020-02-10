package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive{
    //Object attributes/instance vars
    private String name;
    private int udderCapacity;
    private double cowVolume;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    //Object constructors
    public Cow(){
        this.udderCapacity = 15 + new Random().nextInt(26);
        this.name = NAMES[new Random().nextInt(NAMES.length)];
    }

    public Cow(String name){
        this.udderCapacity = 15 + new Random().nextInt(26);
        this.name = name;
    }

    //Object methods
    public String getName(){
        return this.name;
    }

    public double getCapacity(){
        return this.udderCapacity;
    }

    public double getAmount(){
        return this.cowVolume;
    }

    @Override
    public String toString(){
        return this.name + " " + Math.ceil(this.cowVolume) + "/" + this.udderCapacity;
    }

    @Override
    public double milk(){
        double milk = this.cowVolume;
        this.cowVolume = 0;
        return milk;
    }

    @Override
    public void liveHour(){
        double vol = 0.7 + new Random().nextInt(2);

        if(this.cowVolume + vol > this.udderCapacity)
            this.cowVolume = this.udderCapacity;
        else
            this.cowVolume += vol;
    }
}
