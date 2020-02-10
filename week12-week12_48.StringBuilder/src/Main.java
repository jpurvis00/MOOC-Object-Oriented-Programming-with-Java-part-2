
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    /*Creates a string using the stringbuilder class.  This is more efficient than trying
    * to just add things to a string(str += ", ").  When doing this, we are creating a new string
    * object everytime.  If a program were very large, this could cause a problem on execution time.
    * The stringbuilder class lets us modify the string object instead of creating a new one for each
    * additional addition.  Below code will give us the following format:
    * {
        1, 2, 3, 4,
        5, 6, 7, 8,
        9, 10
      }
    */
    public static String build(int[] t) {
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");

        for(int i = 0; i < t.length; i++){
            sb.append(" " + t[i]);

            if(i < t.length - 1 && !((i + 1) % 4 == 0))
                sb.append(",");
            else if((i + 1) % 4 == 0 && (i < t.length - 1))
                sb.append(",\n");
        }

        sb.append("\n}");

        return sb.toString();
    }
}
