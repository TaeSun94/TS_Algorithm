package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 쿼드트리 {
	static int[][] map;
	static String ans ="";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		checkMap(0,0,N);
		bw.write(ans);
		bw.flush();
		bw.close();
	}
	private static void checkMap(int r, int c, int n) {
		// TODO Auto-generated method stub
		int data = map[r][c];
		if(check(r,c,data,n)) {
			ans+=data;
		}else {
			ans+="(";
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					checkMap(r+n/2*i,c+n/2*j,n/2);
				}
			}
			ans+=")";
		}
	}
	private static boolean check(int r, int c, int data, int n) {
		// TODO Auto-generated method stub
		for(int i = r; i < r+n; i++) {
			for(int j = c; j < c+n; j++) {
				if(map[i][j]!= data)
					return false;
			}
		}


		return true;
	}
}
