import java.io.*;
import java.util.*;

public class Main {
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // bfs 로 같은 거리로 갈수있는 건들을 일괄처리
        // -1로 초기화 후 -1 이면 update, -1아니면 이미 도착한 위치이니 queue에 담지 않음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] result = new int[n][m];
        int sy = 0;
        int sx = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;

                if (arr[i][j] == 2) {
                    sy = i;
                    sx = j;
                }
            }
        }

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(sy, sx, 0));
        result[sy][sx] = 0;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            // 방문 가능한 포인트 탐색
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                // 지도 내 정상 인덱스이고 갈 수 있는 땅이고, 방문한 적 없는 경우
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == 1 && result[ny][nx] == -1) {
                    result[ny][nx] = cur.dist + 1;
                    q.add(new Point(ny, nx, cur.dist + 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == -1 && arr[i][j] == 0) {
                    System.out.print(0);
                } else {
                    System.out.print(result[i][j]);
                }
                if (j != m-1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

}

class Point {
    int y;
    int x;
    int dist;

    Point(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}