import java.util.*;

class Solution {
    static int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(res,0, n,q,ans);
        return answer;
    }
    
    public void dfs(ArrayList<Integer> list, int idx, int n, int[][] q, int[] ans) {
        if(list.size() == 5) {
            Set<Integer> set = new HashSet<>(list);
            boolean flag = false;
            for(int i = 0; i < q.length; i++) {
                int counts = 0;
                for (int code: q[i]) {
                    if(set.contains(code)) {
                        counts++;
                    }
                }
                
                if(ans[i] != counts) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                answer++;
            }
            return;
        }
        
        for(int i = idx + 1; i <= n; i++) {
            list.add(i);
            dfs(list, i, n, q, ans);
            list.remove(list.size() - 1);
        }
    }
}
