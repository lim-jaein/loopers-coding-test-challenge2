import java.io.*;
import java.util.*;

public class Main {
    public static Set<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            String str = br.readLine();

            int[] input = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                input[j] = str.charAt(j) - '0';
            }
            result = new HashSet<>();
            permutation(input, 0, new boolean[str.length()], 0);
            System.out.println(result.size());
        }
    }

    private static void permutation(int[] arr, int temp, boolean[] isVisited, int len) {
        // input이 소수인지 판별해서 result += 1;
        if (len > 0 && isPrimeNumber(temp)) {
            result.add(temp);
        }
        if (len == arr.length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 앞자리 0 케이스 제외
            if (temp == 0 && arr[i] == 0) {
                continue;
            }
            if (!isVisited[i]) {
                isVisited[i] = true;
                permutation(arr, temp * 10 + arr[i], isVisited, len + 1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean isPrimeNumber(int temp) {
        if (temp == 0 || temp == 1) {
            return false;
        }
        // 루트 temp 만큼 탐색
        for (int i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                return false;
            }
        }
        return true;
    }
}