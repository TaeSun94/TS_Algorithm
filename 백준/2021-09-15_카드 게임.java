package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 카드게임 {
	static int[][][] mem;
	static int[] cards;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			mem = new int[2][N][N];
			cards = new int[N];
			for(int i = 0; i < N; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(go(0,0,N-1));
		}
	}
	private static int go(int turn, int start, int end) {
		// TODO Auto-generated method stub
		if(mem[turn][start][end] > 0) {
			return mem[turn][start][end];
		}
		if(start == end) {
			if(turn == 0)return cards[start];
			else return 0;
		}
		if(turn == 0) {
			mem[turn][start][end] = Math.max(go(1,start+1,end)+cards[start], go(1,start,end-1)+cards[end]);
		}
		else {
			mem[turn][start][end] = Math.min(go(0,start+1,end), go(0,start,end-1));
		}
		return mem[turn][start][end];
	}
}
