package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 종이의개수 {
	static int[][] map;
	static HashMap<Integer,Integer> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = new HashMap<>();
		for(int i = -1; i <= 1; i++) {
			ans.put(i,0);
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		checkMap(0,0,N);
//		System.out.println(ans.size());
		bw.write(ans.get(-1)+"\n");
		bw.write(ans.get(0)+"\n");
		bw.write(ans.get(1)+"");
		bw.flush();
		bw.close();
	}
	private static void checkMap(int r, int c, int N) {
		// TODO Auto-generated method stub
		int data = map[r][c];
//		System.out.println(data+" "+r+" "+c+" "+N);
//		System.out.println(check(r,c,data,N));
		if(check(r,c,data,N)) {
			ans.replace(data, ans.get(data)+1);
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					checkMap(r+N/3*i,c+N/3*j,N/3);
				}
			}
		}
	}
	private static boolean check(int r, int c,int data, int N) {
		// TODO Auto-generated method stub
		for(int i = r; i < r+N; i++) {
			for(int j = c; j < c+N; j++) {
				if(map[i][j] != data) {
					return false;
				}
			}
		}
		return true;
	}
}
