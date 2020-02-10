public class Main {
    public static void main(String[] args) {
        // Test your code here!
        CivilService cs = new CivilService();
        System.out.println(cs.getDaysLeft());

        for(int i = 0; i < 100; i++){
            cs.work();
        }

        System.out.println(cs.getDaysLeft());

        MilitaryService ms = new MilitaryService(365);
        System.out.println(ms.getDaysLeft());
    }
}
