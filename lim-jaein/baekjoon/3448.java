import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String line = "";
        double ratio = 0.0;
        for (int i = 0; i < N; i++) {
            sb.setLength(0);
            while(true) {
                line = br.readLine();

                if(line == null || line.isEmpty())
                    break;
                sb.append(line);
            }
            line = sb.toString();
            ratio = (double) line.replace("#", "").length() / line.length() * 100;

            // 소수점 두자리 이상인 경우 둘째 자리에서 반올림
            ratio = Math.round(ratio * 10) / 10.0;

            // 반올림 결과가 정수이면 정수 부분만 출력
            if (ratio - (int)ratio == 0) {
                System.out.println("Efficiency ratio is " + (int)ratio + "%.");
            }else {
                System.out.println("Efficiency ratio is " + ratio + "%.");
            }
        }

        br.close();
    }
}