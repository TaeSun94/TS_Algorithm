package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 트리의순회 {
	static int[] inOrder;
	static int[] postOrder;
	static int[] idx;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		inOrder = new int[n+1];
		idx = new int[n+1];
		postOrder = new int[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <= n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <= n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		for(int i =1; i <= n; i++) {
			idx[inOrder[i]] = i;
		}
		go(1,n,1,n);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void go(int in_s, int in_e, int post_s, int post_e) {
		// TODO Auto-generated method stub
		if(in_s > in_e || post_s > post_e)
			return;
		int root = postOrder[post_e];
		sb.append(root+" ");
		int rIdx = idx[root];
		int left = rIdx-in_s;
		go(in_s,rIdx-1,post_s, post_s+left-1);
		go(rIdx+1,in_e, post_s+left, post_e-1);
	}
}
/*
rLR
LRr

*/
