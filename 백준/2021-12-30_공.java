import java.util.*;
public class 공 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int[] cup = new int[4];
		cup[1] = 1;
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			swap(x,y,cup);
		}
		int ans = -1;
		for(int i = 1; i < cup.length; i++)
			if(cup[i]==1)
				ans = i;
		System.out.println(ans);
	}

	private static void swap(int x, int y, int[] cup) {
		// TODO Auto-generated method stub
		int tmp = cup[x];
		cup[x] = cup[y];
		cup[y] = tmp;
	}
}
