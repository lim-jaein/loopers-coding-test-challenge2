import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 3:43
        // N 입력
        // N학기의 성적 입력
        // 한글자씩 읽는다. 알파벳 + 문자(선택, +, - 0, 없음) 형태
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        char[] n_grade = new char[N];

        String prev = "";
        int j = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            char p = '0';

            // + - 0 탐색
            if (i + 1 < line.length()) {
                if (line.charAt(i + 1) != 'A' && line.charAt(i + 1) != 'B' && line.charAt(i + 1) != 'C') {
                    p = line.charAt(i + 1);
                    i += 1;
                }
            }

            // 평어가 C+, C0, C- 가운데 하나이면, 새로운 평어는 B이다.
            if (c == 'C') {
                n_grade[j] = 'B';
            } else if (c == 'B' && (p == '-' || p == '0')) {
                // 첫 학기이거나 이전 학기의 평어가 C+, C0, C- 가운데 하나이면, 새로운 평어는 D이다.
                if (prev.isEmpty() || prev.charAt(0) == 'C') {
                    n_grade[j] = 'D';
                } else {
                    n_grade[j] = 'B';
                }
            } else if (c == 'A' && p == '0') {
                // 이전 학기의 평어가 A+, A0 가운데 하나이면, 새로운 평어는 P이다.
                // 첫 학기이거나 이전 학기의 평어가 A-, B+, B0, B-, C+, C0, C- 가운데 하나이면, 새로운 평어는 E이다.
                if (!prev.isEmpty() && prev.charAt(0) == 'A' && prev.charAt(1) != '-') {
                    n_grade[j] = 'P';
                } else {
                    n_grade[j] = 'E';
                }
            } else if (c == 'A' && p == '+') {
                n_grade[j] = 'E';
            } else {
                // 첫 학기이거나 이전 학기의 평어가 B0, B-, C+, C0, C- 가운데 하나이면, 새로운 평어는 P이다.
                // 이전 학기의 평어가 A+, A0, A-, B+ 가운데 하나이면, 새로운 평어는 D이다.
                if (!prev.isEmpty() && prev.charAt(0) == 'A' || (prev.equals("B+"))) {
                    n_grade[j] = 'D';
                } else {
                    n_grade[j] = 'P';
                }
            }
            j += 1;
            prev = c + "";
            prev += p + "";
        }

        for (int i = 0; i < N; i++) {
            System.out.print(n_grade[i]);
        }
        br.close();
    }

}