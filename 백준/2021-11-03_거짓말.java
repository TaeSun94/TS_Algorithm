import java.io.*;
import java.util.*;
public class 거짓말 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		boolean[] check = new boolean[N+1];
		HashSet<Integer>[] party = new HashSet[M+1];
		for(int i = 1; i <= M; i++) {
			party[i] = new HashSet<>();
		}
		st = new StringTokenizer(br.readLine()," ");
		int cnt = Integer.parseInt(st.nextToken());
		for(int i = 0; i < cnt; i++) {
			check[Integer.parseInt(st.nextToken())] = true;
		}
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for(int i = 1; i <= M; i++) {
			String[] data = br.readLine().split(" ");
			cnt = Integer.parseInt(data[0]);
			if(cnt == 1) {
				party[i].add(Integer.parseInt(data[1]));
			}
			for(int j = 1; j < cnt; j++) {
				int a = Integer.parseInt(data[j]);
				int b = Integer.parseInt(data[j+1]);
				union(a,b);
				party[i].add(a);
				party[i].add(b);
			}
		}
		for(int i = 1; i <= N; i++) {
			if(check[i]) {
				int tmp = find(i);
				for(int j = 1; j <= N; j++) {
					if(find(j)==tmp) {
						check[j] = true;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(parent));
//		System.out.println(Arrays.toString(check));
		int ans = 0;
		for(int i = 1; i <= M; i++) {
			boolean flag = false;
			for(int num: party[i]) {
				if(check[num]) {
					flag = true;
					break;
				}
			}
			if(!flag) ans++;
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	public static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px > py) {
			parent[x] = py;
			parent[px] =py;
		}
		else {
			parent[y] = px;
			parent[py] = px;
		}
	}
}
