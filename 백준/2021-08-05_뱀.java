import java.util.*;

public class Main {
	static int N, K, L;
	static int[][] map;
	static boolean[][] check;
	static char[] directions = new char[10001];

	static class Head {
		int r, c, dir;

		Head(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Head [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < K; i++) {
			map[sc.nextInt()-1][sc.nextInt()-1] = 1;
		}
		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			directions[sc.nextInt()] = sc.next().charAt(0);
		}
		int time = 0;
		Deque<Head> deque = new ArrayDeque<>();
		deque.add(new Head(0, 0, 1));
		check[0][0] = true;
		while (true) {
			Head head = deque.getFirst();
			if (directions[time] == 'D' || directions[time] == 'L') {
				if (directions[time] == 'D') {
					if (head.dir == 3) {
						head.dir = -1;
					}
					head.dir += 1;
				} else {
					if (head.dir == 0) {
						head.dir = 4;
					}
					head.dir -= 1;
				}
			}
			time++;
			int nr = head.r + dr[head.dir];
			int nc = head.c + dc[head.dir];
			if (nr >= N || nc >= N || nr < 0 || nc < 0 || check[nr][nc]) {
				System.out.println(time);
				return;
			}
			if (map[nr][nc] != 1) {
				Head tail = deque.pollLast();
				check[tail.r][tail.c] = false;
			}
			if(map[nr][nc] == 1) {
				map[nr][nc] = 0;
			}
			deque.push(new Head(nr, nc, head.dir));
			check[nr][nc] = true;
		}
	}
}
