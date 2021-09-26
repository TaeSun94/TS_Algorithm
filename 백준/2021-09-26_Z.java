package 쩜문제추천;
import java.util.*;
public class Z {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		int n = 1;
		for(int i = 0; i < N; i++) {
			n *= 2;
		}
		int cnt = 0;
		int r = 0;
		int c = 0;
		while(n>0) {
			n /= 2;
			if(R < r+n && C < c + n)
				cnt += n*n*0;
			else if(R < r + n) {
				cnt += n * n*1;
				c += n;
			}
			else if( C < c+n) {
				cnt += n*n*2;
				r += n;
			}
			else {
				cnt += n*n*3;
				r += n;
				c += n;
			}
			if(n == 1) {
				System.out.println(cnt);
				break;
			}
		}
	}
}
