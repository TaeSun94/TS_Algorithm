package 쩜문제추천;
import java.util.*;
public class IOIOI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String str = sc.next();
		int ans = 0;
		int[] mem = new int[M];
		for(int i = 2; i < M-1; i++) {
			String tmp = str.substring(i-2,i+1);
			if(tmp.equals("IOI")) {
				mem[i] = mem[i-2] + 1;
			}
			if(mem[i] >= N) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
