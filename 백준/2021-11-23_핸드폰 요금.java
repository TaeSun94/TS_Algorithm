import java.util.*;
public class 핸드폰요금 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long Y = 0;
		long M = 0;
		for(int i = 0; i < N; i++) {
			int time = sc.nextInt();
			Y += (time/30)*10 + 10;
			M += (time/60)*15 + 15;
		}
		if(Y > M) {
			System.out.println("M "+M);
		}
		else if(Y == M) {
			System.out.println("Y M "+Y);
		}
		else {
			System.out.println("Y "+Y);
		}
	}
}
