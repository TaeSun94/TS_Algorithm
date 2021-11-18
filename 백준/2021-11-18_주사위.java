import java.util.*;
public class 주사위 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S1 = sc.nextInt();
		int S2 = sc.nextInt();
		int S3 = sc.nextInt();
		int[] mem = new int[S1+S2+S3+1];
		for(int i = 1; i <= S1; i++) {
			for(int j = 1; j <= S2; j++) {
				for(int k = 1; k <= S3; k++) {
					mem[i+j+k]++;
				}
			}
		}
		int max = 0;
		int ans = 0;
		for(int i = 3; i < mem.length; i++) {
			if(max < mem[i]) {
				max = mem[i];
				ans = i;
			}
		}
		System.out.println(ans);
	}
}
