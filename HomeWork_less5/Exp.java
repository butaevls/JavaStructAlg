package lessonFive.HomeWork_less5;

public class Exp {
    public static void main(String[] args) {

        int a = 3;
        int b = 7;
        int c = 1;

        System.out.println(expParam(a,b));

        for (int i = 0; i < b; i++) {
            c = c * a;
        }
        System.out.println(c);

    }

    public static int expParam(int a, int b){
        if (b==0) {
            return 1;
        }
        return a*expParam(a,--b);
    }
}
