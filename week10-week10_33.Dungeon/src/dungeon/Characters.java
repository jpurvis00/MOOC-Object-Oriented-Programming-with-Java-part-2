package dungeon;

/*I created this abstract class so that the Player and Vampire class could inherit from it.  I did
this so that I could create an arrayList in the Dungeon class and add both objects to that arrayList.
 */
public abstract class Characters {
    public abstract void setCoord(int X, int Y);
    public abstract char getName();
    public abstract int getX();
    public abstract int getY();
}
