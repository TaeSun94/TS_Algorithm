import java.util.*;

class Solution {
    class Node {
        int start;
        int end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[] solution(int[] sequence, int k) {
        ArrayList<Node> al = new ArrayList<>();
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int sum = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            if (sum == k) {
                al.add(new Node(start, end));
            }
            
            if (sum + sequence[i] > k) {
                while(sum +sequence[i] > k) {
                    sum -= sequence[start++];
                }
            }
            sum += sequence[i];
            end = i;
        }
        
        if (sum == k) {
            al.add(new Node(start, end));
        }
        
        int len = Integer.MAX_VALUE;
        
        for (Node node: al) {
            int length = node.end - node.start + 1;
            
            if(len > length) {
                start = node.start;
                end = node.end;
                len = length;
            }
        }
        
        answer[0] = start;
        answer[1] = end;
        
        return answer;
    }
}
