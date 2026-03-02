import java.io.*;
import java.util.*;

class Node {
    int y;
    int x;
    int cnt;
    long sum;

    Node (int y, int x, int cnt, long sum) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.sum = sum;
    }
}

public class Main {
    public static int[] dy = {0, 0, 1, -1};
    public static int[] dx = {1, -1, 0, 0};

    public static int[][] arr;
    public static long[][][] dp;
    public static PriorityQueue<Node> pq;

    public static int N;
    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.sum, b.sum)
        );

        arr = new int[N][N];
        dp = new long[N][N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Long.MAX_VALUE;
                }
            }
        }

        dp[0][0][0] = 0;
        pq.add(new Node(0, 0, 0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 온적이 있는데, 더 먹었으면? out
            if (dp[cur.y][cur.x][cur.cnt] < cur.sum)
                continue;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                    int ncnt = cur.cnt + 1;
                    long nsum = cur.sum + T;
                    if (ncnt == 3) {
                        nsum += arr[ny][nx];
                    }
                    // dp 보다 덜 먹었을때만 pq 저장
                    if (nsum < dp[ny][nx][ncnt%3]) {
                        dp[ny][nx][ncnt%3] = nsum;
                        pq.add(new Node(ny, nx, ncnt%3, nsum));
                    }
                }
            }
        }

        System.out.println(Math.min(dp[N-1][N-1][2], Math.min(dp[N-1][N-1][0], dp[N-1][N-1][1])));
        br.close();
    }

}