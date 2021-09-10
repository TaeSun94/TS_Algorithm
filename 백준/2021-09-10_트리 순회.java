package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 트리순회 {
	static class Node{
		char data;
		Node left,right;
		public Node(char data) {
			super();
			this.data = data;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Node> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(new Node((char)('A'+i)));
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(left != '.') {
				list.get(Integer.parseInt((root-'A')+"")).left = list.get(Integer.parseInt((left-'A')+""));
			}
			if(right != '.') {
				list.get(Integer.parseInt((root-'A')+"")).right= list.get(Integer.parseInt((right-'A')+""));
			}
		}
	}
}
