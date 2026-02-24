import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // N은 팀의 수, 모든 팀원의 레이팅이 L 이상이고, 팀원 세 명의 레이팅의 합이 K 이상인 팀만이 가입할 수 있게 하였다.
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 팀 N개를 탐색하며 팀, 개인 레이팅 체크
        int[] p = new int[3];
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[0] = Integer.parseInt(st.nextToken());
            p[1] = Integer.parseInt(st.nextToken());
            p[2] = Integer.parseInt(st.nextToken());

            if (p[0] >= L && p[1] >= L && p[2] >= L && Arrays.stream(p).sum() >= K) {
                count += 1;
                if (sb.length() != 0) sb.append(" ");
                sb.append(p[0] + " " + p[1] + " " + p[2]);
            }
        }

        System.out.println(count);
        System.out.print(sb.toString());
    }
}