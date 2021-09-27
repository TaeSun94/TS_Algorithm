package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 색종이만들기 {
	static int[][] map;
	static int white, blue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		white = 0;
		blue = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0,0,N);
		bw.write(white+"\n");
		bw.write(blue+"");
		bw.flush();
		bw.close();
	}
	private static void divide(int r, int c, int n) {
		// TODO Auto-generated method stub
		if(check(r,c,n)) {
			if(map[r][c] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		int size = n/2;
		divide(r,c,size);
		divide(r,c+size,size);
		divide(r+size,c,size);
		divide(r+size,c+size,size);
	}
	private static boolean check(int r, int c, int n) {
		// TODO Auto-generated method stub
		int color = map[r][c];
		for(int i = r; i < r+n; i++) {
			for(int j = c; j < c+n; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
