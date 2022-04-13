import java.util.Arrays;

public class main {

    public static void main (String[] args) {

        // exo 1
        System.out.println("exercice 1");
        exercice1.spiralOrder(4);

        // exo 2
        System.out.println("exercice 2");
        exercice2 ex2 = new exercice2();
        ex2.push_back(8);
        System.out.println(ex2.getListString());
        ex2.push_back(15);
        System.out.println(ex2.getListString());
        ex2.push_front(20);
        System.out.println(ex2.getListString());
        ex2.push_back(30);
        System.out.println(ex2.getListString());
        int result = ex2.pop_back().orElseThrow();
        System.out.println(ex2.getListString());
        System.out.println(result);
        int result2 = ex2.pop_front().orElseThrow();
        System.out.println(ex2.getListString());
        System.out.println(result2);

        // exo 3
        System.out.println("exercice 3");
        double[] arrayTest = {2, 1, 3, 4, 5};
        exercice3.product(arrayTest);

        // exo 4
        System.out.println("exercice 4");
        int[][] arrayTestBis = {
                { 0, 1, 2, 3 },
                {3, 1, 2, 4},
                {1, 0, 2, 3},
                {5, 9, 2, 5 } };
        exercice4.matrix(arrayTestBis);
    }
}
