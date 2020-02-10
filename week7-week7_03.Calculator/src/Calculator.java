public class Calculator {
    //Object attributes/vars
    private Reader reader;  //Creates a reader obj to get user input(strings/ints)
    private int stats;

    //Object constructors
    public Calculator(){
        this.reader = new Reader();
        this.stats = 0;
    }

    //Object methods
    public void start(){
        while (true) {
            System.out.print("command: ");
            String command = this.reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }

    //Prompts user for 2 ints, sums them and prints the sum.
    private void sum(){
        int[] values = getUserInts();
        System.out.println("sum of the values " + (values[0] + values[1]));
    }

    //Prompts user for 2 ints, find the difference and prints the difference.
    private void difference(){
        int[] values = getUserInts();
        System.out.println("difference of the values " + (values[0] - values[1]));
    }

    //Prompts user for 2 ints, multiplies them and prints the product.
    private void product(){
        int[] values = getUserInts();
        System.out.println("product of the values " + (values[0] * values[1]));
    }

    //Increments stats by 1.  Prompts the user for 2 values and stores the input in an array
    private int[] getUserInts(){
        this.stats++;
        int[] values = new int[2];

        for(int i = 0; i < values.length; i++){
            System.out.print("value" + (i+1) + ": ");
            values[i] = this.reader.readInteger();
        }

        return values;
    }

    //Prints out how many valid operations were performed during 1 cycle of the calculator object
    private void statistics(){
        System.out.println("Calculations done " + this.stats);
    }
}
