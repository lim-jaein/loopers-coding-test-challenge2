import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N의 뒤에 두자리를 바꿔서 F로 나눠지면 성공
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        // 일단 뒤 두자리를 제거 (100으로 나눴다가 100 곱하기)
        N = N / 100;
        N = N * 100;

        // 00 -> 99 까지 넣기
        for (int i = 0; i < 100; i++) {
            if ((N + i) % F == 0) {
                String result = String.valueOf(N + i);
                System.out.println(result.substring(result.length() - 2));
                break;
            }
        }
    }
}