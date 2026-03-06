import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

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


        for (int i = 0; i < N; i++) {
            hashMap.put(cards[i], hashMap.containsKey(cards[i]) ? hashMap.get(cards[i]) + 1 : 1);
        }


        for (int i = 0; i < M; i++) {
            sb.append(hashMap.getOrDefault(targets[i], 0));
            if (i != M-1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}