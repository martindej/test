public class exercice1 {

    public static void spiralOrder(int n) {
        String result = "";

        boolean[] seen = new boolean[n*n];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int r = 0, c = 0, di = 0;

        for (int i = 0; i < n*n; i++) {
            result =  result + " " + (r * n + c + 1);
            seen[r * n + c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];

            if (0 <= cr && cr < n && 0 <= cc && cc < n
                    && !seen[cr * n + cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }

        }
        System.out.println(result);
    }


}
