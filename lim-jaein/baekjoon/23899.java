import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(selection_sort());
    }

    public static int selection_sort() {
        boolean is_equal = false;

        int swap = 0;
        for (int i = N; i > 0; i--) {

            int target_idx = 0;
            // A B 배열 비교
            for (int j = 0; j < N; j++) {
                if (A[j] != B[j]) {
                    break;
                }
                else {
                    if (j == N-1) {
                        is_equal = true;
                    }
                }
            }

            for (int j = 0; j < i; j++) {
                // 0 ~ j 정렬 구간 내 최대값 위치 탐색
                if (A[target_idx] < A[j]) {
                    target_idx = j;
                }
            }
            // idx i-1과 j 교체
            swap = A[target_idx];
            A[target_idx] = A[i-1];
            A[i-1] = swap;
        }

        return is_equal ? 1 : 0;
    }
}