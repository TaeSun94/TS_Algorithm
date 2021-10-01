package 쩜문제추천;
import java.util.*;
public class 리모컨 {
	static boolean[] broken;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		broken = new boolean[10];
		for(int i = 0; i < M; i++) {
			broken[sc.nextInt()] = true;
		}
		int ans = Math.abs(N-100);
		for(int i = 0; i <= 1000000; i++) {
			int len = check(i);
			if(len > 0) {
				int tmp = Math.abs(N-i);
				ans = Math.min(ans,len+tmp);
			}
		}
		System.out.println(ans);
	}

	private static int check(int n) {
		// TODO Auto-generated method stub
		if(n == 0) {
			if(broken[n]) {
				return 0;
			}
			else
				return 1;
		}
		int len = 0;
		while(n>0) {
			if(broken[n%10]) {
				return 0;
			}
			n /= 10;
			len += 1;
		}
		return len;
	}
}
