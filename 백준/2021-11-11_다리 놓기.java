import java.util.*;
public class 다리놓기 {
	static int[][] mem=new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(comb(M,N));
		}
	}
	private static int comb(int n, int r) {
		// TODO Auto-generated method stub
		if(mem[n][r] > 0) {
			return mem[n][r];
		}
		if(n == r || r == 0) {
			return mem[n][r] = 1;
		}
		mem[n][r] = comb(n-1,r-1)+comb(n-1,r);
		return mem[n][r];
	}
}
