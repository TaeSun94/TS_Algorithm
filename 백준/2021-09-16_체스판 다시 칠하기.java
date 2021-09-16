package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 체스판다시칠하기 {
	static boolean[][] map;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		//w = false, b = true
		map = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j)=='W' ? true : false;
			}
		}
		int r = N-7;
		int c = M-7;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				find(i,j);
			}
		}
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}

	private static void find(int i, int j) {
		// TODO Auto-generated method stub
		int row = i + 8;
		int col = j + 8;
		int cnt = 0;
		boolean first = map[i][j];
		for(int r = i; r < row; r++) {
			for(int c = j; c < col; c++) {
				if(map[r][c] != first) {
					cnt++;
				}
				first = !first;
			}
			first = !first;
		}
		cnt = Math.min(cnt, 64-cnt);
		min = Math.min(min, cnt);
	}
}
