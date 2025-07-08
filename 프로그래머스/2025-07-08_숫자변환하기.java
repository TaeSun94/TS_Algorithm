import java.util.*;

class Solution {
    class Node {
        int cost;
        int count;
        Node(int cost, int count) {
            this.cost = cost;
            this.count = count;
        }
    }

    public int solution(int x, int y, int n) {
        int answer = Integer.MAX_VALUE;
        
        Queue<Node> que = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        visited[x] = true;
        que.add(new Node(x, 0));
        
        while(!que.isEmpty()) {
            Node node = que.poll();
            if(node.cost == y) {
                answer = node.count;
                break;
            }
            if(node.cost + n <= y && !visited[node.cost + n]) {
                visited[node.cost + n] = true;
                que.add(new Node(node.cost + n, node.count + 1));
            }
            if(node.cost*2 <= y && !visited[node.cost*2]) {
                visited[node.cost*2] = true;
                que.add(new Node(node.cost*2, node.count + 1));
            }
            if(node.cost*3 <= y && !visited[node.cost*3]) {
                visited[node.cost*3] = true;
                que.add(new Node(node.cost*3, node.count + 1));
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
