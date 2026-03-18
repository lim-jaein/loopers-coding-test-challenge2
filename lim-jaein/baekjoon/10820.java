import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            int lower_alp_cnt = 0;
            int upper_alp_cnt = 0;
            int number_cnt = 0;
            int space_cnt = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    space_cnt += 1;
                } else if (line.charAt(i) - 'a' >= 0) {
                    lower_alp_cnt += 1;
                } else if (line.charAt(i) - 'A' >= 0) {
                    upper_alp_cnt += 1;
                } else if (line.charAt(i) - '0' >= 0) {
                    number_cnt += 1;
                }
            }
            sb.append(lower_alp_cnt);
            sb.append(" ");
            sb.append(upper_alp_cnt);
            sb.append(" ");
            sb.append(number_cnt);
            sb.append(" ");
            sb.append(space_cnt);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}