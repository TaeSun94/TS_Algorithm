package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 숨바꼭질2 {
	static int N, K, ans, count;
	static class Subin{
		int now, cnt;

		public Subin(int now, int cnt) {
			super();
			this.now = now;
			this.cnt = cnt;
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		ans = Integer.MAX_VALUE;
		count = 0;
		bfs();
		System.out.println(ans);
		System.out.println(count);
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Subin> que = new LinkedList<>();
		que.add(new Subin(N,0));
		boolean[] check = new boolean[100001];
		while(!que.isEmpty()) {
			Subin su = que.poll();
			check[su.now] = true;
			if(ans != Integer.MAX_VALUE && ans < su.cnt) {
				continue;
			}
			if(su.now == K) {
				if(ans > su.cnt) {
					ans = su.cnt;
					count = 1;
				}
				else if(ans == su.cnt) {
					count++;
				}
				continue;
			}
			if(su.now-1 >= 0 && !check[su.now-1])
				que.add(new Subin(su.now-1, su.cnt+1));
			if(su.now+1 <= check.length-1 && !check[su.now+1])
				que.add(new Subin(su.now+1,su.cnt+1));
			if(su.now*2 <= check.length-1 && !check[su.now*2])
				que.add(new Subin(su.now*2,su.cnt+1));
		}
	}
}
