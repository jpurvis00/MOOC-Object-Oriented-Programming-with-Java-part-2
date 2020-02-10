package dungeon;

import java.util.*;

public class Dungeon {
    //Object attributes/instance vars
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Scanner reader;
    private List<Characters> charList;
    private Random rand = new Random();
    private Map<Character, Integer> command = new HashMap<Character, Integer>();

    //Object constructors
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.reader = new Scanner(System.in);
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.charList = new ArrayList<Characters>();
        this.command.put('w', -1);
        this.command.put('s', 1);
        this.command.put('a', -1);
        this.command.put('d', 1);
    }

    //Object methods
    public void run(){
        char[] moveInput;
        createPlayer();
        createVampires(this.vampires);

        System.out.println(this.moves);
        System.out.println();

        displayCharList();
        displayBoard();

        while(this.moves > 0) {
            moveInput = getMoves();
            generatePlayerPosition(moveInput);

            if(this.vampiresMove)
                generateVampirePosision();

            this.moves--;

            System.out.println(this.moves);
            System.out.println();

            displayCharList();
            displayBoard();

            if(this.moves == 0)
                System.out.println("\nYOU LOSE");
            else if(this.charList.size() == 1)
                System.out.println("\nYOU WIN");
        }
    }

    /*Creates our player object with a starting x and y coordinate of 0, 0 and adds it to our
      arrayList of Characters.
    */
    private void createPlayer(){
        Player p1 = new Player(0, 0);
        this.charList.add(p1);
    }

    /*Creates a Vampire object.  We also create an X and Y coordinate using a random # with the bounds
    being the height and length of the board.  This makes sure that their starting placement on the board
    is within bounds.  We create as many Vampire objects as specfied and add all these to our Characters
    arrayList.
     */
    private void createVampires(int numbVampires){
        for(int i = 0; i < numbVampires; i++){
            int[] XY = generateRandomXY();

            this.charList.add(new Vampire(XY[0], XY[1]));
        }
    }

    /*Creates two random #'s and adds them to an array.  These represent an X and Y coord.  Returns the array*/
    private int[] generateRandomXY(){
        int[] XY = new int[2];
        /*X coordinate*/
        XY[0] = this.rand.nextInt(this.length);
        /*Y coordinate*/
        XY[1] = this.rand.nextInt(this.height);

        return XY;
    }

    /*Displays all characters board placement in a coordinate type display.
    ex. p 1 0
        v 3 2
     */
    private void displayCharList(){
        for(Characters characters : this.charList){
            System.out.println(characters);
        }
    }

    /*Creates a new Board object and draws the board with the player and vampires displayed on the board*/
    private void displayBoard(){
        Board board = new Board(length, height);
        board.drawBoard(this.charList);
    }

    /*Generates the players position on the board.*/
    private void generatePlayerPosition(char[] moveInput){
        /*Get players current position*/
        int X = this.charList.get(0).getX();
        int Y = this.charList.get(0).getY();

        /*Calculates the new XY coord for the player.  moveInput.length is a string of characters
        that represent up/down/left/right(ssssddd).  Each command(w, s, a, d) are equal to adding/subtracting
        1 from the current X/Y coord.  If they command take you past any edge of the board, set the X/Y
        coord to 0 or the legth/height of the board.
         */
        for(int i = 0; i < moveInput.length; i++){
            if(moveInput[i] == 'w') {
                Y += this.command.get('w');
                if(Y < 0)
                    Y = 0;
            }
            else if(moveInput[i] == 's') {
                Y += this.command.get('s');
                if(Y >= this.height)
                    Y = this.height - 1;
            }
            else if(moveInput[i] == 'a') {
                X += this.command.get('a');
                if(X < 0)
                    X = 0;
            }
            else if(moveInput[i] == 'd') {
                X += this.command.get('d');
                if(X >= this.length)
                    X = this.length - 1;
            }

        }

        this.charList.get(0).setCoord(X, Y);
    }

    /*Get moves from user input and store them in a char array*/
    private char[] getMoves(){
        System.out.println();
        String moves = reader.nextLine();
        char[] ch = moves.toLowerCase().toCharArray();
        return ch;
    }

    /*Generate the XY coord for the vampires*/
    private void generateVampirePosision(){
        int[] XY = new int[2];
        for(Characters chars : this.charList){
            if(chars.getName() == 'v'){
                XY = generateRandomXY();
                chars.setCoord(XY[0], XY[1]);
            }
        }
    }
}
