package dungeon;

import java.util.ArrayList;
import java.util.List;

public class Board {
    //Object attributes/instance vars
    private int length;
    private int height;

    //Object constructors
    public Board(int length, int height) {
        this.length = length;
        this.height = height;
    }

    //Object methods
    /*Draws a text representation of a game board.  Height and length of the board are gotten when a
    dungeon object is created.  It will also display the player and all vampires on the board.  Player
    is represented with an @.  Vampires are represented with an v.
     */
    public void drawBoard(List<Characters> allChars) {
        /*keeps track of whether or not we found a player to print out.  We need this so that
        we print out the correct # of *.  Without it I was printing extra *'s.
         */
        boolean found = false;
        System.out.println();

        allChars = killVampire(allChars);

        /*First for loop controls height of board*/
        for (int i = 0; i < this.height; i++) {
            /*Second for loop controls length of board*/
            for (int j = 0; j < this.length; j++) {
                /*Third for loop iterates through the player and all vampires.  We do this so we
                know where to print their symbol.  If character X = i, we know we need to print the
                character symbol on that row.  If character Y = j, we know we need to print that
                character symbol in that column.
                 */
                for (Characters chars : allChars) {
                    if (chars.getX() == j && chars.getY() == i) {
                        /*Found player*/
                        if (chars.getName() == '@') {
                            System.out.print('@');
                            found = true;
                        }
                        /*Found vampire*/
                        else if (chars.getName() == 'v') {
                            System.out.print('v');
                            found = true;
                        }
                    }
                }

                /*If no character was found, print */
                if (!found) {
                    System.out.print('*');

                    /*Print new line to start next row*/
                    if (j == this.length - 1)
                        System.out.println();
                }
                /*Character was found*/
                else {
                    /*Print new line to start new row and reset found for next row iteration*/
                    if (j == this.length - 1) {
                        System.out.println();
                        found = false;
                    } else {
                        found = false;
                    }

                }
            }
        }
    }

    /*Kills a vampire if our player is on the same X, Y coordinate as a vampire.  This is done
    by iterating through the Characters list.  If we find one, we add it to an arrayList(toBeRemoved).
    We then use the removeAll on that arrayList to remove all vampires we found. This is done this way
    to avoid a ConcurrentModificationException error since we can't remove and object while iterating
    through the list at the same time.
     */
    private List<Characters> killVampire(List<Characters> allChars){
        /*Stores all vampires to kill/remove*/
        ArrayList<Characters> toBeRemoved = new ArrayList<Characters>();

        /*Get the X/Y coord of the player.  We created the List so that the player is always the first entry*/
        int X = allChars.get(0).getX();
        int Y = allChars.get(0).getY();

        /*Only do comparisons on the vampires*/
        for(Characters chars : allChars){
            if(chars.getName() == 'v'){
                if(chars.getX() == X && chars.getY() == Y)
                    toBeRemoved.add(chars);
            }
        }

        /*Remove all vampires from the arrayList of Characters*/
        allChars.removeAll(toBeRemoved);

        return allChars;
    }
}