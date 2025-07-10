
enum Status {
    Running, Failed, Pending, Success; // these are named constants
}

public class Enum {

    public static void main(String[] args) {
        int i = 5;
        Status s = Status.Running;
        System.out.println(s);
        System.out.println(s.ordinal()); // means index
        Status[] status = Status.values();
        for (Status st : status) {
            System.out.println(st + " : " + st.ordinal());
        }

        // using switch case
        switch (s) {
            case Running:
                System.out.println("All Good");
                break;
            case Failed:
                System.out.println("Try Again");
                break;
            case Pending:
                System.out.println("Please Wait");
                break;
            default:
                System.out.println("Done");
        }
    }
}
