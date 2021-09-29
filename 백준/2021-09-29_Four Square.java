package 쩜문제추천;
import java.util.*;
public class FourSquares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] mem = new int[50001];
		Arrays.fill(mem, Integer.MAX_VALUE);
		mem[0] = 0;
		int idx = 1;
		while(true) {
			if(idx*idx > 50000)
				break;
			mem[idx*idx] = 1;
			idx++;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= (int)Math.sqrt(i);j++) {
				mem[i] = Math.min(mem[i], mem[i-j*j]+mem[j*j]);
			}
		}
		System.out.println(mem[n]);
	}
}
