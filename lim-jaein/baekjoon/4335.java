import java.io.*;
import java.util.*;

public class Main {
    public static final String TOO_HIGH = "too high";
    public static final String TOO_LOW = "too low";
    public static final String RIGHT_ON = "right on";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int minNum = 0;
        int maxNum = 11;
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            String input = br.readLine();

            switch (input) {
                case TOO_HIGH:
                    maxNum = Math.min(maxNum, num);
                    break;
                case TOO_LOW:
                    minNum = Math.max(minNum, num);
                    break;
                case RIGHT_ON:
                    if (minNum < num && num < maxNum) {
                        sb.append("Stan may be honest\n");
                    } else {
                        sb.append("Stan is dishonest\n");
                    }
                    minNum = 0;
                    maxNum = 11;
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}