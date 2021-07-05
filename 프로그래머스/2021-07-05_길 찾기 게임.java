/*
정확성  테스트
테스트 1 〉	통과 (1.18ms, 52.7MB)
테스트 2 〉	통과 (0.73ms, 52.8MB)
테스트 3 〉	통과 (0.75ms, 53MB)
테스트 4 〉	통과 (0.95ms, 52.6MB)
테스트 5 〉	통과 (0.81ms, 52.5MB)
테스트 6 〉	실패 (9.23ms, 53.6MB)
테스트 7 〉	실패 (9.59ms, 53.4MB)
테스트 8 〉	실패 (40.22ms, 62.9MB)
테스트 9 〉	실패 (46.39ms, 66.5MB)
테스트 10 〉	실패 (13.68ms, 56MB)
테스트 11 〉	실패 (47.28ms, 66.1MB)
테스트 12 〉	실패 (44.74ms, 69.8MB)
테스트 13 〉	실패 (1.36ms, 54.1MB)
테스트 14 〉	실패 (9.63ms, 54MB)
테스트 15 〉	실패 (29.33ms, 57.6MB)
테스트 16 〉	실패 (49.80ms, 69MB)
테스트 17 〉	실패 (11.70ms, 54.3MB)
테스트 18 〉	실패 (29.86ms, 63.1MB)
테스트 19 〉	실패 (13.37ms, 55.2MB)
테스트 20 〉	실패 (18.00ms, 60.7MB)
테스트 21 〉	실패 (28.08ms, 62.3MB)
테스트 22 〉	실패 (41.10ms, 62.3MB)
테스트 23 〉	실패 (35.59ms, 66.8MB)
테스트 24 〉	통과 (0.82ms, 52.6MB)
테스트 25 〉	통과 (0.90ms, 52.3MB)
테스트 26 〉	통과 (24.64ms, 56.1MB)
테스트 27 〉	통과 (0.77ms, 52.4MB)
테스트 28 〉	통과 (1.26ms, 52.1MB)
테스트 29 〉	통과 (0.78ms, 52.2MB)
채점 결과
정확성: 37.9
합계: 37.9 / 100.0
*/
import java.util.*;
class Solution {
	static class Node{
		int x, y, val;
		Node left;
		Node right;
		boolean choose;
		Node(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public static void preorder(Node root) {
		if(root!=null) {
			pre.append(root.val).append(',');
//			System.out.println(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	public static void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
//			System.out.println(root.val);
			post.append(root.val).append(',');
		}
	}
	static StringBuilder post;
	static StringBuilder pre;
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> list = new ArrayList<>();
		post = new StringBuilder();
		pre = new StringBuilder();
		for(int i = 0; i < nodeinfo.length; i++) {
			list.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.y > o2.y) {
					return -1;
				}
				else if(o1.y==o2.y) {
					if(o1.x < o2.x)
						return -1;
				}
				return 0;
			}
		});
		//이제 트리 만들기
		for(int i = 1; i < list.size(); i++) {
			Node root = list.get(0);
			Node tmp = list.get(i);
			while(true) {
				if(root.x > tmp.x) {
					if(root.left == null) {
						root.left = tmp;
						break;
					}
					else {
						root = root.left;
					}
				}else {
					if(root.right == null) {
						root.right = tmp;
						break;
					}
					else {
						root = root.right;
					}
				}
			}
		}
		preorder(list.get(0));
		postorder(list.get(0));
		String[] preord = pre.toString().split(",");
		String[] postord = post.toString().split(",");
		int[] int_preord = new int[preord.length];
		int[] int_postord = new int[postord.length];
		for(int i = 0; i < preord.length; i++) {
			int_preord[i] = Integer.parseInt(preord[i]);
			int_postord[i] = Integer.parseInt(postord[i]);
		}
		int[][] answer = {int_preord,int_postord};
        return answer;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (1.00ms, 52.1MB)
테스트 2 〉	통과 (1.26ms, 52MB)
테스트 3 〉	통과 (0.95ms, 52.1MB)
테스트 4 〉	통과 (0.85ms, 51.3MB)
테스트 5 〉	통과 (0.94ms, 52.5MB)
테스트 6 〉	통과 (10.31ms, 54.1MB)
테스트 7 〉	통과 (10.04ms, 53.6MB)
테스트 8 〉	통과 (16.44ms, 56.8MB)
테스트 9 〉	통과 (49.53ms, 64.9MB)
테스트 10 〉	통과 (8.22ms, 54.5MB)
테스트 11 〉	통과 (39.28ms, 65MB)
테스트 12 〉	통과 (46.79ms, 65.5MB)
테스트 13 〉	통과 (1.61ms, 53.1MB)
테스트 14 〉	통과 (5.78ms, 52.9MB)
테스트 15 〉	통과 (18.67ms, 60.2MB)
테스트 16 〉	통과 (31.21ms, 65.2MB)
테스트 17 〉	통과 (7.06ms, 53.8MB)
테스트 18 〉	통과 (42.31ms, 66MB)
테스트 19 〉	통과 (9.25ms, 57MB)
테스트 20 〉	통과 (18.01ms, 56.6MB)
테스트 21 〉	통과 (20.53ms, 60.9MB)
테스트 22 〉	통과 (46.55ms, 64.7MB)
테스트 23 〉	통과 (49.22ms, 64.8MB)
테스트 24 〉	통과 (1.02ms, 52.6MB)
테스트 25 〉	통과 (1.09ms, 52.9MB)
테스트 26 〉	통과 (16.05ms, 58.6MB)
테스트 27 〉	통과 (3.57ms, 51.7MB)
테스트 28 〉	통과 (0.70ms, 52.2MB)
테스트 29 〉	통과 (1.08ms, 51.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Tree{
        Node head;
        int size;

        Tree(){
            head=null;
            this.size = 0;
        }

        public void push(Node node){
            if(head==null){
                head = node;
                return;
            }
            Node currentNode = head;
            Node parentNode = null;
            while(true){
                parentNode = currentNode;
                if(node.x > parentNode.x){
                    if(parentNode.right == null){
                        parentNode.right = node;
                        return;
                    }
                    currentNode = parentNode.right;
                }
                else{
                    if(parentNode.left == null){
                        parentNode.left = node;
                        return;
                    }
                    currentNode = parentNode.left;
                }
            }
        }
        public void preOrder(Node node) {
            if(node != null) {
                dataList.add(node.data);
                if(node.left != null) preOrder(node.left);
                if(node.right != null) preOrder(node.right);
            }
        }
        public void postOrder(Node node) {
            if(node != null) {
                if(node.left != null) postOrder(node.left);
                if(node.right != null) postOrder(node.right);
                dataList.add(node.data);
            }
        }
    }
    static class Node{
        int data,x,y;
        Node left, right;
        Node(int data,int x, int y){
            this.data = data;
            this.x =  x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
    }
    static Node root;
    static ArrayList<Integer> dataList;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        ArrayList<Node> list = new ArrayList<>();
        Tree tree = new Tree();
        for(int i = 0; i < nodeinfo.length; i++){
            list.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }
        Collections.sort(list, new Comparator<Node>(){
            public int compare(Node node1, Node node2){
                if(node1.y - node2.y>0)
                    return -1;
                else if(node1.y == node2.y)
                    return node1.x-node2.x;
                else
                    return 1;
            }
        });
        for(Node n : list){
            tree.push(n);
        }
        Node root = list.get(0);
        for(int i = 0; i < answer.length; i++){
            dataList = new ArrayList<>();
            if(i==0)
                tree.preOrder(root);
            else
                tree.postOrder(root);
            int idx = 0;
            for(int num: dataList){
                answer[i][idx++] = num;
            }
        }
        return answer;
    }
}
