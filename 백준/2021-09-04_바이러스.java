package 쩜문제추천;
import java.util.*;
public class 바이러스 {
	static class Computer{
		int number;
		ArrayList<Integer> child;
		public Computer(int number) {
			this.number = number;
			this.child = new ArrayList<>();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Computer> comList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			comList.add(new Computer(i+1));
		}
		int E = sc.nextInt();
		for(int i = 0; i < E; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			comList.get(a).child.add(b);
			comList.get(b).child.add(a);
		}
		boolean[] visited = new boolean[N];
		Queue<Computer> que = new LinkedList<>();
		que.add(comList.get(0));
		visited[0] = true;
		while(!que.isEmpty()) {
			Computer com = que.poll();
			for(int number: com.child) {
				if(!visited[number]) {
					visited[number]=true;
					que.add(comList.get(number));
				}
			}
		}
		int cnt = 0;
		for(int i = 1; i < visited.length; i++) {
			if(visited[i])
				cnt++;
		}
		System.out.println(cnt);
	}
}
