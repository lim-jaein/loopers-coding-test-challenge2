import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 0;
        int group = 0;
        Queue<int[]> q = new ArrayDeque<>();

        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            String[] crew = new String[N];
            group += 1;

            if (group > 1)
                System.out.println();
            System.out.println("Group " + group);

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split("\\s+");

                // 학생리스트 저장
                crew[i] = input[0];
                for (int j = 1; j < N; j++) {
                    if (input[j].equals("N")) {
                        // N-j번째 학생이 i번째에게 나쁜말을 했음
                        q.add(new int[]{i, (i-j+N)%N});
                    }
                }
            }

            if (q.isEmpty()) {
                System.out.println("Nobody was nasty");
            }

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                System.out.println(crew[cur[1]] + " was nasty about " + crew[cur[0]]);
            }
        }

        br.close();
    }
}