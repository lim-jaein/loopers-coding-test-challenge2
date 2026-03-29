import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String input = st.nextToken();
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String item = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            if (item.contains("_"+input+"_") || item.endsWith("_"+input) || item.startsWith(input+"_") || item.equals(input)) {
                result += cnt;
            }
        }

        System.out.println(result);
    }
}