import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            int rIndex = searchIndex(cards, targets[i], true);
            int lIndex = searchIndex(cards, targets[i], false);

            if (rIndex == -1) {
                sb.append(0);
            } else {
                if (rIndex == lIndex) {
                    sb.append(1);
                } else {
                    sb.append(rIndex - lIndex + 1);
                }
            }

            if (i != M-1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    public static int searchIndex(int[] cards, int target, boolean isR) {
        int left = 0;
        int right = cards.length - 1;
        int result = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (cards[mid] == target) {
                result = mid;
                if (isR) {
                    // 오른쪽으로 계속해서 탐색
                    left = mid + 1;
                } else {
                    // 왼쪽으로 계속해서 탐색
                    right = mid - 1;
                }
            } else if (cards[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}