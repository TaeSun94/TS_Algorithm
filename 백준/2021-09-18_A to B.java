package 쩜문제추천;
import java.util.*;
import java.io.*;
public class AB {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		answer = -1;
		dfs(A,B,1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(long a, long b, int cnt) {
		// TODO Auto-generated method stub
		if(a>b)
			return;
		if(a == b) {
			if(answer == -1) {
				answer = cnt;
			}
			else {
				answer = Math.min(answer, cnt);
			}
			return;
		}
		dfs(a*2,b,cnt+1);
		dfs(a*10+1,b,cnt+1);
	}
}
