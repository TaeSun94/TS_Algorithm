import java.util.*;
import java.io.*;
public class 봄버맨 {
	static int[][] map;
	static char[][] board;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		board = new char[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j);
				if(str.charAt(j)=='O') {
					map[i][j] = 3;
				}
			}
		}
		for(int t = 2; t < N; t++) {
			if(t%2 == 0) {
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(board[i][j]=='.') {
							map[i][j] = t+3;
							board[i][j] = 'O';
						}
					}
				}
			}
			else{
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(map[i][j] == t) {
							board[i][j] = '.';
							map[i][j] = 0;
							for(int d = 0; d < 4; d++) {
								int nr = i + dr[d];
								int nc = j + dc[d];
								if(nr < 0 || nc < 0 || nr >= R || nc >= C)
									continue;
								if(board[nr][nc] == 'O' && map[nr][nc] != t) {
									board[nr][nc] = '.';
									map[nr][nc] = 0;
								}
							}
						}
					}
				}
			}
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					bw.write(board[i][j]);
				}
				bw.write("\n");
			}
			bw.write("\n");
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				bw.write(board[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
