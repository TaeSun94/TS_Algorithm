/*
정확성  테스트
테스트 1 〉	통과 (0.20ms, 52.9MB)
테스트 2 〉	실패 (5.34ms, 53.6MB)
테스트 3 〉	실패 (3.57ms, 52.1MB)
테스트 4 〉	실패 (12.36ms, 54.1MB)
테스트 5 〉	실패 (19.00ms, 54.7MB)
테스트 6 〉	실패 (18.41ms, 55.8MB)
테스트 7 〉	실패 (73.63ms, 70.3MB)
테스트 8 〉	실패 (100.85ms, 72.4MB)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (0.07ms, 53MB)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	실패 (시간 초과)
테스트 14 〉	실패 (6.73ms, 72.7MB)
테스트 15 〉	실패 (7.10ms, 72.1MB)
테스트 16 〉	실패 (5.53ms, 72.7MB)
테스트 17 〉	실패 (0.03ms, 67.5MB)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	실패 (4202.01ms, 361MB)
테스트 20 〉	실패 (0.03ms, 72.9MB)
테스트 21 〉	실패 (14.38ms, 86.1MB)
테스트 22 〉	실패 (6.76ms, 72.3MB)
테스트 23 〉	실패 (시간 초과)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	실패 (0.03ms, 72.9MB)
테스트 26 〉	실패 (50.56ms, 85MB)
테스트 27 〉	실패 (시간 초과)
테스트 28 〉	통과 (78.09ms, 67.9MB)
채점 결과
정확성: 7.1
합계: 7.1 / 100.0
*/
import java.util.*;
class Solution {
    static int result;
    public int solution(int[] a) {
        result = 0;
        powerSet(a);
        int answer = result;
        return answer;
    }
    static void powerSet(int[] a) {
		for(int i = 0; i <(1<<a.length);i++) {
            ArrayList<Integer> list = new ArrayList<>();
			for(int j = 0; j<a.length; j++) {
				if((i&(1<<j))!= 0) {
					list.add(a[j]);
				}
			}
            if(list.size()!=0 && list.size()%2==0){
                // System.out.println(list.toString());
                boolean flag = false;
                ArrayList<Integer> n = new ArrayList<>();
                for(int k = 0; k < list.size()/2;k+=2){
                    int left = list.get(k);
                    int right = list.get(k+1);
                    if(left==right){
                        flag = true;
                        break;
                    }
                    if(n.size() == 0){
                        n.add(left);
                        n.add(right);
                    }
                    else{
                        if(!n.contains(left) && !n.contains(right)){
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag){
                    result = Math.max(list.size(),result);
                }
            }
		}
	}
}
/*
Second Try -> 완전 탐색을 통하여 계산. 2의 배수인지 확인후 계산.
정확성  테스트
테스트 1 〉	통과 (0.15ms, 54MB)
테스트 2 〉	실패 (1.28ms, 52.5MB)
테스트 3 〉	통과 (3.40ms, 52.4MB)
테스트 4 〉	통과 (7.24ms, 59.1MB)
테스트 5 〉	실패 (14.35ms, 53.6MB)
테스트 6 〉	실패 (14.57ms, 57.6MB)
테스트 7 〉	실패 (85.81ms, 76.9MB)
테스트 8 〉	통과 (144.80ms, 83.2MB)
테스트 9 〉	통과 (8684.19ms, 372MB)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	실패 (시간 초과)
테스트 14 〉	실패 (시간 초과)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	실패 (시간 초과)
테스트 17 〉	실패 (시간 초과)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	실패 (시간 초과)
테스트 20 〉	실패 (시간 초과)
테스트 21 〉	실패 (시간 초과)
테스트 22 〉	실패 (시간 초과)
테스트 23 〉	실패 (시간 초과)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	실패 (시간 초과)
테스트 26 〉	실패 (시간 초과)
테스트 27 〉	실패 (시간 초과)
테스트 28 〉	실패 (4.91ms, 52.6MB)
채점 결과
정확성: 17.9
합계: 17.9 / 100.0
*/
import java.util.*;
class Solution {
    static boolean[] check;
    static int max;
    public int solution(int[] a) {
        int answer = -1;
        max = 0;
        for(int i = 0; i <= a.length; i++){
            if(max > 0)
                break;
            if(i==a.length){
                return 0;
            }
            check = new boolean[a.length];
            if((a.length-i)%2 != 0){
                continue;
            }
            //i개의 원소를 밴 나머지 리스트
            dfs(0,i,a);
        }
        return max;
    }
    public void dfs(int idx, int count, int[]a){
        if(count == 0){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < check.length; i++){
                if(!check[i])
                    list.add(a[i]);
            }
            //스타수열 체크
            if(starArrayCheck(list)){
                max = Math.max(list.size(),max);
            }
            return;
        }
        for(int i = idx; i < a.length; i++){
            if(!check[i]){
                check[i] = true;
                dfs(i+1, count-1,a);
                check[i] = false;
            }
        }
        return;
    }
    public boolean starArrayCheck(ArrayList<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i <list.size(); i+=2){
            if(set.isEmpty()){
                set.add(list.get(i));
                set.add(list.get(i+1));
            }
            else{
                if(set.contains(list.get(i))){
                    if(set.contains(list.get(i+1))){
                        continue;
                    }
                    else{
                        set.clear();
                        set.add(list.get(i));
                    }
                }
                else if(set.contains(list.get(i+1))){
                    if(set.contains(list.get(i))){
                        continue;
                    }
                    else{
                        set.clear();
                        set.add(list.get(i+1));
                    }
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
