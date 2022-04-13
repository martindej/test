import java.util.Arrays;

public class exercice3 {

    public static void product(double[] entry) {
        double[] result = new double[entry.length];
        Arrays.fill(result, 1.0);

        for(int i=0;i< entry.length;i++) {
            for(int j=0;j<entry.length - 1;j++) {
                result[i] = result[i] * entry[j >= i ? j + 1 : j];
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
