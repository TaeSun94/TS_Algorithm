package 쩜문제추천;
import java.util.*;
public class 카잉달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int ans = -1;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			//x = ans%M, y = ans%N;
			int idx = x%M;
			while(true) {
				if(idx > M*N)
					break;
				if(idx%N == y%N) {
					ans = idx;
					break;
				}
				idx += M;
			}
			System.out.println(ans);
		}
	}
}
