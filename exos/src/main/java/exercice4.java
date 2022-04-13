import java.util.Arrays;

public class exercice4 {

    public static void matrix(int[][] entry) {

        boolean[] cols = new boolean[entry.length];
        boolean[] rows = new boolean[entry.length];

        for(int steps = 0; steps<2;steps++) {
            for(int i=0;i< entry.length;i++) {
                for(int j=0;j< entry.length;j++) {
                    if (steps == 0 && entry[i][j] == 1) {
                        cols[j] = true;
                        rows[i] = true;
                    } else if(steps == 1 && (cols[j] == true || rows[i] == true)){
                        entry[i][j] = 1;
                    }
                }
            }
        }

        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (int[] row : entry) {
            sb.append(Arrays.toString(row))
                    .append(lineSeparator);
        }

        System.out.println(sb.toString());
    }
}
