package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 집합의표현 {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		rank = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			parents[i] = i;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(oper > 0) {
				int pA = find(a);
				int pB = find(b);
				if(pA==pB) {
					bw.write("YES\n");
				}
				else
					bw.write("NO\n");
			}
			else {
				union(a,b);
			}
		}
		bw.flush();
		bw.close();
	}
	static int find(int x) {
		if(parents[x] == x)
			return x;
		else
			return parents[x] = find(parents[x]);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)
			return;
		if(rank[a]<rank[b]) {
			parents[a] = b;
		}else {
			parents[b] = a;
			if(rank[a]==rank[b])
				rank[a]++;
		}
	}
}
