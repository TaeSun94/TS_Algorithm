package 쩜문제추천;
import java.util.*;
public class 케빈베이컨의6단계법칙 {
	static class Person{
		int number, depth;
		Person(int number, int depth){
			this.depth = depth;
			this.number = number;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] edges = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			edges[a].add(b);
			edges[b].add(a);
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(edges[i].toString());
//		}
		int[][] member = new int[N][N];
		for(int i = 0; i < N; i++) {
			boolean[] check = new boolean[N];
			check[i] = true;
			Queue<Person> que = new LinkedList<>();
			que.add(new Person(i,0));
			while(!que.isEmpty()) {
				Person person = que.poll();
				for(int p: edges[person.number]) {
					if(!check[p]) {
						check[p] = true;
						member[i][p] = person.depth+1;
						que.add(new Person(p,person.depth+1));
					}
				}
			}
		}
		int ans = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += member[i][j];
			}
			if(min > sum) {
				min = sum;
				ans = i+1;
			}
		}
		System.out.println(ans);
	}
}
