import java.util.*;
public class 임시반장정하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<Integer>[] hs = new HashSet[N+1];
		for(int i = 1; i <= N; i++) {
			hs[i] = new HashSet<Integer>();
		}
		ArrayList<Integer>[][] mem = new ArrayList[5][10];
		for(int i = 0; i < 5; i++) {
			for(int j = 1; j < 10; j++) {
				mem[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 5; j++) {
				mem[j][sc.nextInt()].add(i+1);
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 1; j < 10; j++) {
				if(mem[i][j].size() > 1) {
					for(int k = 0; k < mem[i][j].size(); k++) {
						for(int l = 0; l < mem[i][j].size(); l++) {
							if(k == l)
								continue;
							hs[mem[i][j].get(k)].add(mem[i][j].get(l));
						}
					}
				}
			}
		}
		int ans = 1;
		int max = 0;
		for(int i = 1; i <= N; i++) {
			if(hs[i].size() > max) {
				ans = i;
				max = hs[i].size();
			}
		}
		System.out.println(ans);
	}
}
