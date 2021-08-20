package 쩜문제추천;

import java.io.*;
import java.util.*;

public class 원판돌리기 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// 회전
			for (int i = 0; i < N; i++) {
				if ((i + 1) % x == 0) {
					rotate(i, d, k);
				}
			}
			// 근접한 수 중 같은 수가 있는지 확인 있다면 0으로 표시
			if (!check()) {
				// 없다면 평균 구한 뒤 빼기
				minus();
			}
//			for (int i = 0; i < N; i++)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println();
		}
		/*
		 * [1, 1, 2, 3] [2, 5, 2, 4] [3, 1, 3, 5] [2, 2, 1, 3]
		 */
		int answer = 0;
		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
			for (int j = 0; j < map[i].length; j++) {
				answer += map[i][j];
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
	}

	private static void minus() {
		// TODO Auto-generated method stub
		double sum = 0;
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sum += map[i][j];
				if(map[i][j] != 0)
					cnt++;
			}
		}
		sum /= cnt;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0)
					continue;
				if (map[i][j] > sum) {
					map[i][j]--;
				} else if(map[i][j] < sum)
					map[i][j]++;
			}
		}
		return;
	}

	private static boolean check() {
		// TODO Auto-generated method stub
		boolean flag = false;
		int[][] tmp = new int[map.length][map[0].length];
		for (int i = 0; i < tmp.length; i++)
			Arrays.fill(tmp[i], -1);
		/*
		 * (i, 1)은 (i, 2), (i, M)과 인접하다. (i, M)은 (i, M-1), (i, 1)과 인접하다. (i, j)는 (i,
		 * j-1), (i, j+1)과 인접하다. (2 ≤ j ≤ M-1)
		 */
		for (int i = 0; i < map.length; i++) {
//		(1, j)는 (2, j)와 인접하다.
			if (i == 0) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 0)
						continue;
					if (map[i][j] == map[i + 1][j]) {
						tmp[i][j] = 0;
						tmp[i + 1][j] = 0;
					}
					if (j == 0) {
						if (map[i][j] == map[i][j + 1]) {
							tmp[i][j] = 0;
							tmp[i][j + 1] = 0;
						}
						if (map[i][j] == map[i][map[i].length - 1]) {
							tmp[i][j] = 0;
							tmp[i][map[i].length - 1] = 0;
						}
					} else if (j == map[i].length - 1) {
						if (map[i][j] == map[i][j - 1]) {
							tmp[i][j] = 0;
							tmp[i][j - 1] = 0;
						}
						if (map[i][j] == map[i][0]) {
							tmp[i][j] = 0;
							tmp[i][0] = 0;
						}
					} else {
						if (map[i][j - 1] == map[i][j]) {
							tmp[i][j] = 0;
							tmp[i][j - 1] = 0;
						}
						if (map[i][j + 1] == map[i][j]) {
							tmp[i][j] = 0;
							tmp[i][j + 1] = 0;
						}
					}
				}
			}
//		(N, j)는 (N-1, j)와 인접하다.
			else if (i == map.length - 1) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 0)
						continue;
					if (map[i][j] == map[i - 1][j]) {
						tmp[i][j] = 0;
						tmp[i - 1][j] = 0;
					}
					if (j == 0) {
						if (map[i][j] == map[i][j + 1]) {
							tmp[i][j] = 0;
							tmp[i][j + 1] = 0;
						}
						if (map[i][j] == map[i][map[i].length - 1]) {
							tmp[i][j] = 0;
							tmp[i][map[i].length - 1] = 0;
						}
					} else if (j == map[i].length - 1) {
						if (map[i][j] == map[i][j - 1]) {
							tmp[i][j] = 0;
							tmp[i][j - 1] = 0;
						}
						if (map[i][j] == map[i][0]) {
							tmp[i][j] = 0;
							tmp[i][0] = 0;
						}
					} else {
						if (map[i][j - 1] == map[i][j]) {
							tmp[i][j] = 0;
							tmp[i][j - 1] = 0;
						}
						if (map[i][j + 1] == map[i][j]) {
							tmp[i][j] = 0;
							tmp[i][j + 1] = 0;
						}
					}
				}
			}
//		(i, j)는 (i-1, j), (i+1, j)와 인접하다. (2 ≤ i ≤ N-1)
			else {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 0)
						continue;
					if (map[i][j] == map[i + 1][j]) {
						tmp[i][j] = 0;
						tmp[i + 1][j] = 0;
					}
					if (map[i][j] == map[i - 1][j]) {
						tmp[i][j] = 0;
						tmp[i - 1][j] = 0;
					}
					if (j == 0) {
						if (map[i][j] == map[i][j + 1]) {
							tmp[i][j] = 0;
							tmp[i][j + 1] = 0;
						}
						if (map[i][j] == map[i][map[i].length - 1]) {
							tmp[i][j] = 0;
							tmp[i][map[i].length - 1] = 0;
						}
					} else if (j == map[i].length - 1) {
						if (map[i][j] == map[i][j - 1]) {
							tmp[i][j] = 0;
							tmp[i][j - 1] = 0;
						}
						if (map[i][j] == map[i][0]) {
							tmp[i][j] = 0;
							tmp[i][0] = 0;
						}
					} else {
						if (map[i][j - 1] == map[i][j]) {
							tmp[i][j] = 0;
							tmp[i][j - 1] = 0;
						}
						if (map[i][j + 1] == map[i][j]) {
							tmp[i][j] = 0;
							tmp[i][j + 1] = 0;
						}
					}
				}
			}

		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (tmp[i][j] == -1) {
					tmp[i][j] = map[i][j];
				} else
					flag = true;
			}
		}
		map = tmp;
		return flag;
	}

	private static void rotate(int i, int d, int k) {
		// TODO Auto-generated method stub
		if (d == 0) {
			for (int cnt = 0; cnt < k; cnt++) {
				int tmp = map[i][map[i].length - 1];
				for (int j = map[i].length - 1; j > 0; j--) {
					map[i][j] = map[i][j - 1];
				}
				map[i][0] = tmp;
			}
		} else {
			for (int cnt = 0; cnt < k; cnt++) {
				int tmp = map[i][0];
				for (int j = 0; j < map[i].length - 1; j++) {
					map[i][j] = map[i][j + 1];
				}
				map[i][map[i].length - 1] = tmp;
			}
		}
		return;
	}
}
