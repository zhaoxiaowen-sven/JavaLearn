package mem;

public class FinalKeyWord {
    final int j;
    int i;
    static FinalKeyWord obj;

    public FinalKeyWord() {
        i = 1;
        j = 2;
    }
    public static void writer() {
        obj = new FinalKeyWord();
    }
    public static void reader(){
        FinalKeyWord object = obj;
        int b = object.j;

        System.out.println("b = " + b);

//        int a = object.i;
//        System.out.println("a = " + a );


    }
}
