package 쩜문제추천;

import java.util.Scanner;

public class One으로만들기 {
	static int[] mem;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		mem = new int[N+1];
		parent = new int[N+1];
		int ans = go(N);
		System.out.println(ans);
		String str = N+"";
		int idx = N;
		while(idx != 1) {
			str += " "+parent[idx];
			idx = parent[idx];
		}
		System.out.println(str);
	}
	private static int go(int num) {
		// TODO Auto-generated method stub
		if(num == 1) {
			return 0;
		}
		if(mem[num]>0) {
			return mem[num];
		}
		mem[num] = go(num-1)+1;
		parent[num] = num-1;
		if(num%3 == 0) {
			int tmp = go(num/3)+1;
			if(tmp < mem[num]) {
				mem[num] = tmp;
				parent[num] = num/3;
			}
		}
		if(num%2 == 0) {
			int tmp = go(num/2)+1;
			if(tmp < mem[num]) {
				mem[num] = tmp;
				parent[num] = num/2;
			}
		}
		return mem[num];
	}
}
