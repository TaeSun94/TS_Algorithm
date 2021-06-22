/*
정확성  테스트
테스트 1 〉	통과 (0.33ms, 52.9MB)
테스트 2 〉	통과 (3.98ms, 54MB)
테스트 3 〉	통과 (1.22ms, 52.9MB)
테스트 4 〉	통과 (0.79ms, 53.1MB)
테스트 5 〉	통과 (196.60ms, 87.4MB)
테스트 6 〉	통과 (25.99ms, 54.8MB)
테스트 7 〉	통과 (6.40ms, 53MB)
테스트 8 〉	통과 (3.60ms, 52.3MB)
테스트 9 〉	통과 (10.33ms, 53.5MB)
테스트 10 〉	통과 (62.95ms, 66.1MB)
테스트 11 〉	통과 (9.00ms, 54MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static HashSet<HashSet<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
		dfs(new LinkedHashSet<>(), user_id, banned_id);
        return result.size();
    }

	private static void dfs(HashSet<String> set, String[] user_id, String[] banned_id) {
		// TODO Auto-generated method stub
		if(set.size() == banned_id.length) {
            if(checkId(set, banned_id)){
                result.add(new HashSet<>(set));
            }
			return;
		}
		for(String id: user_id){
            if(!set.contains(id)){
                set.add(id);
                dfs(set,user_id,banned_id);
                set.remove(id);
            }
        }
	}
    private static boolean checkId(HashSet<String> set, String[] banned_id){
        int idx = 0;
        for(String id : set){
        	if(!isDifferent(id,banned_id[idx++])){
                return false;
            }
        }
        return true;
    }
    private static boolean isDifferent(String id, String banned_id){
        if(id.length() != banned_id.length())
            return false;
        for(int i = 0; i < id.length(); i++){
            if(banned_id.charAt(i)=='*')
                continue;
            if(id.charAt(i) != banned_id.charAt(i))
                return false;
        }
        return true;
    }
}
