import java.util.*;
public class 피시방알바 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] pc = new boolean[101];
		int N = sc.nextInt();
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(pc[num]) {
				ans++;
			}
			else {
				pc[num] = true;
			}
		}
		System.out.println(ans);
	}
}
