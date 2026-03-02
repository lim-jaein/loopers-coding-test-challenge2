import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int n = 0;
        String result = "";
        for (int i = 0; i < 8; i++) {
            n = Integer.parseInt(st.nextToken());
            if (i + 1 == n && result != "descending") {
                cnt += 1;
                result = "ascending";
            }
            if (8 - i == n && result != "ascending") {
                cnt += 1;
                result = "descending";
            }
        }

        if(cnt == 8) {
            System.out.println(result);
        } else {
            System.out.println("mixed");
        }

        br.close();
    }
}