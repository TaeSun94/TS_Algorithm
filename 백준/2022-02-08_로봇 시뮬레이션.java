import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static int A, B, N, M;
    private static boolean isCrush;
    private static Pos[] pos;
    private static int[][] check;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static HashMap<String, Integer> dirMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = "";

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pos = new Pos[N + 1];
        check = new int[B + 1][A + 1];

        dirMap.put("N", 0);
        dirMap.put("E", 1);
        dirMap.put("S", 2);
        dirMap.put("W", 3);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            pos[i] = new Pos(x, y, dirMap.get(dir));
            check[y][x] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int robot = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int commandCount = Integer.parseInt(st.nextToken());

            answer = getCrush(robot, command, commandCount);
            if (isCrush) {
                break;
            }
        }

        System.out.println(answer);

    }

    private static String getCrush(int robot, String command, int commandCount) {
        for (int i = 0; i < commandCount; i++) {
            Pos curRobotPos = pos[robot];

            if (command.equals("L") || command.equals("R")) {
                int nextRobotDir = getNextDir(curRobotPos.dir, command);
                pos[robot] = new Pos(curRobotPos.x, curRobotPos.y, nextRobotDir);
            } else if (command.equals("F")) {
                int nextX = curRobotPos.x + dx[curRobotPos.dir];
                int nextY = curRobotPos.y + dy[curRobotPos.dir];

                if (nextX < 1 || nextY < 1 || nextX > A || nextY > B) {
                    isCrush = true;
                    return "Robot " + robot + " crashes into the wall";
                } else {
                    if (check[nextY][nextX] != 0) {
                        isCrush = true;
                        return "Robot " + robot + " crashes into robot " + check[nextY][nextX];
                    } else {
                        check[curRobotPos.y][curRobotPos.x] = 0;
                        check[nextY][nextX] = robot;
                        pos[robot] = new Pos(nextX, nextY, curRobotPos.dir);
                    }
                }
            }
        }

        return "OK";
    }

    private static int getNextDir(int dir, String command) {
        if (command.equals("L")) {
            if (dir == 0) {
                dir = 3;
            } else {
                dir--;
            }
        } else if (command.equals("R")) {
            if (dir == 3) {
                dir = 0;
            } else {
                dir++;
            }
        }
        return dir;
    }

    private static class Pos {
        int x;
        int y;
        int dir;

        public Pos(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
