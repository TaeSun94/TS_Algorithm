import java.util.*;

class Solution {
    private int MIN_VALUE = Integer.MAX_VALUE;
    private Set<String> visited;
    
    public int solution(int[][] info, int n, int m) {
        visited = new HashSet();
        dfs(info, 0, 0, n, m, 0);
        
        return MIN_VALUE == Integer.MAX_VALUE ? -1 : MIN_VALUE;
    }
    
    public void dfs(int[][] info, int aValue, int bValue, int n, int m, int idx) {
        if(idx == info.length) {
            MIN_VALUE = MIN_VALUE > aValue ? aValue : MIN_VALUE;
            return;
        }
        if(MIN_VALUE <= aValue) {
            return;
        }
        
        String key = aValue + " " + bValue+ " "+idx;
        if(visited.contains(key)) {
            return;
        }

        if(bValue + info[idx][1] < m) {
            dfs(info, aValue, bValue + info[idx][1], n, m, idx+1);
        }
        if(aValue + info[idx][0] < n) {
            dfs(info, aValue + info[idx][0], bValue, n, m, idx+1);
        }
        
        visited.add(key);
    }
}
