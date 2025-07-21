import java.util.*;

class Solution {
    class Node{
        int[] data;
        int key;
        
        Node (int[] data, int key) {
            this.data = data;
            this.key = key;
        }
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        ArrayList<Node> al = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            al.add(new Node(data[i], col-1));
        }
        
        Collections.sort(al, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.data[o1.key] == o2.data[o2.key]) {
                    return o2.data[0] - o1.data[0];
                } else {
                    return o1.data[o1.key] - o2.data[o2.key];
                }
            }
        });
      
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = row_begin-1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < al.get(i).data.length; j++) {
                sum += al.get(i).data[j] % (i+1);
            }
            list.add(sum);
        }

        for (int i = 0; i < list.size(); i++) {
            answer = answer ^ list.get(i);
        }
        
        return answer;
    }
}
