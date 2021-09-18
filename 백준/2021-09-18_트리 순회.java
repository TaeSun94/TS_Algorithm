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
			this.data = data;
		}

	}
	static class Tree{
		Node root;
		public void add(char data, char left, char right) {
			if(root == null) {
				if(data != '.') root = new Node(data);
				if(left != '.') root.left = new Node(left);
				if(right != '.') root.right = new Node(right);
			}
			else
				search(root, data,left,right);
		}
		private void search(Node node, char data, char left, char right) {
			// TODO Auto-generated method stub
			if(node == null) return;
			else if(node.data == data) {
				if(left != '.') node.left = new Node(left);
				if(right != '.') node.right = new Node(right);
			}
			else {
				search(node.left,data,left,right);
				search(node.right,data,left,right);
			}
		}
		public void preorder(Node Root) {
			System.out.print(Root.data);
			if(Root.left != null) preorder(Root.left);
			if(Root.right != null) preorder(Root.right);
		}
		public void postorder(Node Root) {
			if(Root.left != null) postorder(Root.left);
			if(Root.right != null) postorder(Root.right);
			System.out.print(Root.data);
		}
		public void inorder(Node Root) {
			if(Root.left != null) inorder(Root.left);
			System.out.print(Root.data);
			if(Root.right != null) inorder(Root.right);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		Tree tree = new Tree();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.add(root, left, right);
		}
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
	}
}
