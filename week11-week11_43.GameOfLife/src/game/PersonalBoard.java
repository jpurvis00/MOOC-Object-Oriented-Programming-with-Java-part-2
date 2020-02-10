package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {
    //Object attribrutes/instance vars
    private Random rand;
    //private int living;

    //Object constructors
    public PersonalBoard(int width, int height){
        super(width, height);
        this.rand = new Random();
    }

    //Object methods
    /*Marks the coordinates as alive which is true*/
    public void turnToLiving(int x, int y){
        if(isInsideBoard(x, y))
            getBoard()[x][y] = true;
    }

    /*Marks the coordinates as dead which is false*/
    public void turnToDead(int x, int y){
        if(isInsideBoard(x, y))
            getBoard()[x][y] = false;
    }

    /*Returns false if the coordinates are dead and true if they are alive*/
    public boolean isAlive(int x, int y){
        if(isInsideBoard(x, y)) {
            if (!getBoard()[x][y])
                return false;
        } else {
            return false;
        }

        return true;
    }

    /*Accepts a probability # from 0.0 - 1.0.  It then sets coordinates to living
    * if the random double is < the probability*/
    public void initiateRandomCells(double probabilityForEachCell){
        for(int y = 0; y < getHeight(); y++){
            for(int x = 0; x < getWidth(); x++){
                if(rand.nextDouble() < probabilityForEachCell)
                    turnToLiving(x, y);
            }
        }
    }

    /*Checks all surrounding coordinates to see if any are living.  If they are, return how many.*/
    public int getNumberOfLivingNeighbours(int x, int y){
        int living = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isAlive(i, j)) {
                    living++;
                }
            }
        }

        if(isAlive(x, y))
            living--; //Remove 1 from count if orig coordinate

        return living;
    }

    /*If the x/y coordinate has a < 2 or > 3 living neightbours, turn coord dead.  If it has exactly 3
    * living neighbors, turn to living.*/
    public void manageCell(int x, int y, int livingNeighbours){
        if(livingNeighbours < 2 || livingNeighbours > 3)
            turnToDead(x, y);
        else if(livingNeighbours == 3)
            turnToLiving(x, y);
    }

    /*Checks to see if the x and y coordinates are within the board dimensions*/
    private boolean isInsideBoard(int x, int y){
        if(x < 0 || x > getWidth() - 1 || y < 0 || y > getHeight() - 1)
            return false;

        return true;
    }

}
