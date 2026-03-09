import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        int resultPrice = 0;
        int resultSum = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int tempSum = 0;
        for (int i = M - 1; i >= 0; i--) {
            // 현재 인덱스가 달걀 개수보다 작으면 인덱스 만큼만 팔수있음
            if (M-i < N) {
                tempSum = arr[i] * (M-i);
            } else {
                // 그 외는 다 판다
                tempSum = arr[i] * N;
            }

            // 최댓값 비교 (비교 시 같은 경우 가격이 더 작으니 반영)
            if (tempSum >= resultSum) {
                resultSum = tempSum;
                resultPrice = arr[i];
            }

            if (M-i == N) {
                break;
            }
        }
        System.out.println(resultPrice + " " + resultSum);
    }
}