package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 이진검색트리 {
	static class Node{
		int data;
		Node left,right;
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}
	static class Tree{
		Node root;

		public void insert(int data) {
			if(root == null) {
				root = new Node(data,null,null);
				return;
			}
			Node now = root;
			while(true) {
				if(data > now.data) {
					if(now.right == null) {
						now.right = new Node(data,null,null);
						break;
					}
					now = now.right;
				}
				else {
					if(now.left == null) {
						now.left = new Node(data,null,null);
						break;
					}
					now = now.left;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String n = "";
		Tree tree = new Tree();
		while(true) {
			n = br.readLine();
			if(n == null || n.equals(""))
				break;
			tree.insert(Integer.parseInt(n));
		}
		postOrder(tree.root);
	}
	public static void postOrder(Node n) {
		if(n == null)
			return;
		postOrder(n.left);
		postOrder(n.right);
		System.out.println(n.data);
	}
}
