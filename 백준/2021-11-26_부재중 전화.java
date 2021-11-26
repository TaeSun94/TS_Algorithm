import java.util.*;
public class 부재중전화 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int D = sc.nextInt();
		boolean[] time = new boolean[N*L+5*(N-1)];
		for(int i = 0; i < N; i++) {
			int during = (L+5)*i;
			for(int j = during; j < during+L; j++) {
				time[j] = true;
			}
		}
		int ans = 0;
		while(ans < time.length) {
			if(!time[ans])
				break;
			ans += D;
		}
		System.out.println(ans);
	}
}
