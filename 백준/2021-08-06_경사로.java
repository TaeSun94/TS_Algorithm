package 쩜문제추천;

import java.io.*;
import java.util.*;

public class 경사로 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// init map
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		// 가로 체크
		for (int i = 0; i < N; i++) {
			if (check(i, 0, L, false)) {
				answer++;
			}
		}

		// 세로 체크
		for (int i = 0; i < N; i++) {
			if (check(0, i, L, true)) {
				answer++;
			}
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();
	}

	private static boolean check(int row, int col, int L, boolean dir) {
		// TODO Auto-generated method stub
		int cnt = 1;
		int currentHeight = map[row][col];
		boolean flag = false;
		if (!dir) {
			for (int i = 1; i < map.length; i++) {
				if(currentHeight != map[row][i]) {
					if(Math.abs(currentHeight-map[row][i])> 1)
						return false;
					if(currentHeight > map[row][i]) {
						if(!flag) {
							flag = true;
							cnt = 1;
							currentHeight = map[row][i];
						}
						else {
							if(cnt < L) {
								return false;
							}
							cnt = 1;
							currentHeight=map[row][i];
							flag = false;
						}
					}
					else {
						if(flag) {
							cnt -= L;
						}
						if(cnt < L)
							return false;
						else {
							cnt = 1;
							currentHeight = map[row][i];
							flag = false;
						}
					}
				}else {
					cnt++;
					if(flag) {
						if(cnt >= L) {
							cnt -=L;
							flag = false;
						}
					}
				}
			}
		} else {
			for (int i = 1; i < map.length; i++) {
				if(currentHeight != map[i][col]) {
					if(Math.abs(currentHeight-map[row][i]) > 1)
						return false;
					if(currentHeight > map[i][col]) {
						if(!flag) {
							flag = true;
							cnt = 1;
							currentHeight = map[i][col];
						}
						else {
							if(cnt < L)
								return false;
							cnt = 1;
							currentHeight = map[i][col];
							flag = false;
						}
					}
					else {
						if(flag)
							cnt -= L;
						if(cnt < L)
							return false;
						else {
							cnt = 1;
							currentHeight = map[i][col];
							flag = false;
						}
					}
				}else {
					cnt++;
					if(flag) {
						if(cnt >= L) {
							cnt -= L;
							flag = false;
						}
					}
				}
			}
		}
		if(flag) {
			return cnt < L ? false:true;
		}
		return true;
	}
}
