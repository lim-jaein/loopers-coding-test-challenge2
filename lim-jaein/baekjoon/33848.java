import java.io.*;
import java.util.*;

public class Main {
    static class History {
        int type;
        int num;

        History(int type, int num) {
            this.type = type;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<History> pstack = new Stack<>();

        StringTokenizer st = null;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int num = 0;
            if (type == 1 || type == 3) {
                num = Integer.parseInt(st.nextToken());
            }
            switch (type) {
                case 1:
                    stack.push(num);
                    pstack.push(new History(type, num));
                    break;
                case 2:
                    int tmp = stack.pop();
                    pstack.push(new History(type, tmp));
                    break;
                case 3:
                    while(num-->0) {
                        History h = pstack.pop();
                        if (h.type == 1) {
                            stack.pop();
                        } else {
                            stack.push(h.num);
                        }
                    }
                    break;
                case 4:
                    sb.append(stack.size()).append("\n");
                    break;
                case 5:
                    sb.append(stack.isEmpty()? -1:stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}