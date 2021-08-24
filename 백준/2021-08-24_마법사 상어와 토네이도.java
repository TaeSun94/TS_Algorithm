/*
아직 정해를 얻지 못함.
달팽이 배열 탐색을 반대로 탐색하는 방법을 통하여 모래를 흩날리는 구조로 구현
*/
package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 마법사상어와토네이도 {
	static int[][] sands;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		sands = new int[N][N];
		answer = 0;
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				sands[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] check = new boolean[N][N];

		int len = 1;
		int cnt = 1;
		int row = N/2;
		int col = N/2;
		int dir = 0;
		int idx = -1;
		check[row][col]= true;
		while(len < N) {
			//열
			for(int i = 0; i < len; i++) {
				moveSand(row,col,dir);
				col += idx;
				check[row][col] = true;
			}
			idx *= -1;
			dir = (dir+1)%4;
			//행
			for(int i = 0; i < len; i++) {
				moveSand(row,col,dir);
				row += idx;
				check[row][col] = true;
			}
			len++;
			dir = (dir+1)%4;
			if(len == N) {
				for(int i = 0; i < len-1; i++) {
					col += idx;
					moveSand(row,col,dir);
					check[row][col] = true;
				}
			}
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	private static void moveSand(int row, int col, int dir) {
		// TODO Auto-generated method stub
		int nr = row + dr[dir];
		int nc = col + dc[dir];
		if(nr < 0 || nc < 0 || nr >= sands.length || nc >= sands.length) {
			return;
		}
		int totalSand = sands[nr][nc];
		sands[nr][nc] = 0;
		//알파, 5%
		int nnr = nr + dr[dir];
		int nnc = nc + dc[dir];
		if(nnr < 0 || nnc < 0 || nnr >= sands.length || nnc >= sands.length) {
			answer += totalSand*0.55;
		}
		else {
			sands[nnr][nnc] += totalSand*0.55;
		}
		nnr += dr[dir];
		nnc += dc[dir];
		if(nnr < 0 || nnc < 0 || nnr >= sands.length || nnc >= sands.length) {
			answer += totalSand*0.05;
		}
		else {
			sands[nnr][nnc] += totalSand*0.05;
		}
		//7%, 10%, 2%, 1%
		for(int d = 0; d < 4; d++) {
			if(dir%2 == d%2)
				continue;
			nnr = nr + dr[d];
			nnc = nc + dc[d];
			if(nnr < 0 || nnc < 0 || nnr >= sands.length || nnc >= sands.length) {
				answer += totalSand*0.07;
			}
			else {
				sands[nnr][nnc] += totalSand*0.07;
			}
			for(int dd = 0; dd < 4; dd++) {
				if(dd != d && dd%2 == d%2)
					continue;
				nnr += dr[dd];
				nnc += dc[dd];
				if(nnr < 0 || nnc < 0 || nnr >= sands.length || nnc>=sands.length) {
					if(dd == dir) {
						answer += totalSand*0.1;
					}
					else if(dd%2 == dir%2) {
						answer += totalSand*0.01;
					}
					else {
						answer += totalSand*0.02;
					}
					continue;
				}
				if(dd == dir) {
					sands[nnr][nnc] += totalSand*0.1;
				}
				else if(dd%2 == dir%2) {
					sands[nnr][nnc] += totalSand*0.01;
				}
				else {
					sands[nnr][nnc] += totalSand*0.02;
				}
			}
		}
		for(int[] s: sands)
			System.out.println(Arrays.toString(s));
		System.out.println();
		return;
	}
}
