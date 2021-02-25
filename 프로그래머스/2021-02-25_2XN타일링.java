import java.util.*;
public class Nx2타일링 {
	static int[] mem;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		mem = new int[n+1];

		int answer = go(n);
		System.out.println(answer);
	}
	private static int go(int n) {
		// TODO Auto-generated method stub
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(mem[n]>0)
			return mem[n];
		mem[n] = go(n-1)+go(n-2);
		return mem[n];
	}
}
