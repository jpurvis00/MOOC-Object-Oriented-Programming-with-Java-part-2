public class CivilService implements NationalService {
    //Object attributes/vars
    private int daysLeft;

    //Ojbect constructors
    public CivilService(){
        this.daysLeft = 362;
    }

    //Object methods
    //This method is implemented from NationalService interface.  Return daysLeft
    @Override
    public int getDaysLeft(){
        return this.daysLeft;
    }

    //This method is implemented from NationalService interface.  Decrease daysLeft.  Do not go neg
    @Override
    public void work(){
        if(this.daysLeft > 0)
            this.daysLeft -= 1;
    }
}
