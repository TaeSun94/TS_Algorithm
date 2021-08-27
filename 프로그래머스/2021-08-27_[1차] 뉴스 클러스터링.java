/*
정확성  테스트
테스트 1 〉	통과 (9.02ms, 72.3MB)
테스트 2 〉	통과 (9.58ms, 68.9MB)
테스트 3 〉	통과 (8.38ms, 60.5MB)
테스트 4 〉	통과 (14.77ms, 74.9MB)
테스트 5 〉	통과 (7.68ms, 59.4MB)
테스트 6 〉	통과 (10.19ms, 61.2MB)
테스트 7 〉	통과 (9.05ms, 60MB)
테스트 8 〉	통과 (8.39ms, 72.2MB)
테스트 9 〉	통과 (11.95ms, 76.6MB)
테스트 10 〉	통과 (11.12ms, 59.6MB)
테스트 11 〉	통과 (13.40ms, 60.5MB)
테스트 12 〉	통과 (10.13ms, 75.7MB)
테스트 13 〉	통과 (10.45ms, 73.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < str1.length()-1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z'){
                if(map1.containsKey(c1+""+c2)){
                    map1.replace(c1+""+c2,map1.get(c1+""+c2)+1);
                }
                else{
                    map1.put(c1+""+c2,1);
                }
                set.add(c1+""+c2);
            }
        }
        for(int i = 0; i < str2.length()-1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z'){
                if(map2.containsKey(c1+""+c2)){
                    map2.replace(c1+""+c2,map2.get(c1+""+c2)+1);
                }
                else{
                    map2.put(c1+""+c2,1);
                }
            }
            set.add(c1+""+c2);
        }
        double union = 0;
        double combine = 0;
        // System.out.println(set.size());
        for(String str: set){
            if(map1.containsKey(str) && map2.containsKey(str)){
                if(map1.get(str)>map2.get(str)){
                    union += map1.get(str);
                    combine += map2.get(str);
                }
                else if(map1.get(str)<map2.get(str)){
                    union += map2.get(str);
                    combine += map1.get(str);
                }
                else{
                    union += map1.get(str);
                    combine += map1.get(str);
                }
            }
            else if(map1.containsKey(str)){
                union += map1.get(str);
            }
            else if(map2.containsKey(str)){
                union += map2.get(str);
            }
        }
        if(combine == 0.0 && union == 0.0){
            return 65536;
        }
        answer = (int)(combine/union*65536);
        return answer;
    }
}
