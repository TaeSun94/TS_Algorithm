package 쩜문제추천;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class 조합 {
	static BigInteger[][] mem;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		mem = new BigInteger[1001][1001];
		go(n,m);
		bw.write(mem[n][m]+"");
		bw.flush();
		bw.close();
	}
	private static void go(int n, int m) {
		// TODO Auto-generated method stub
		for(int i =1; i <=n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j==0 || j == i)
					mem[i][j] = new BigInteger("1");
				else
					mem[i][j] = mem[i-1][j-1].add(mem[i-1][j]);
			}
		}
	}
}
