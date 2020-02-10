package dungeon;

public class Player extends Characters {
    //Object attributes/instance vars
    private char name;
    private int X;
    private int Y;

    //Object constructors
    public Player(int X, int Y){
        this.name = '@';
        this.X = X;
        this.Y = Y;
    }

    //Object methods
    @Override
    public void setCoord(int X, int Y){
        this.X = X;
        this.Y = Y;
    }

    @Override
    public char getName(){
        return this.name;
    }

    @Override
    public int getX(){
        return this.X;
    }

    @Override
    public int getY(){
        return this.Y;
    }

    @Override
    public String toString(){
        return this.name + " " + this.X + " " + this.Y;
    }
}
