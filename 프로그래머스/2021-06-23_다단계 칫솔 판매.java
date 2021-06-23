/*
정확성  테스트
테스트 1 〉	통과 (0.11ms, 51.8MB)
테스트 2 〉	통과 (0.41ms, 53.4MB)
테스트 3 〉	통과 (0.25ms, 53MB)
테스트 4 〉	통과 (1.43ms, 53MB)
테스트 5 〉	통과 (6.12ms, 53.1MB)
테스트 6 〉	통과 (7.54ms, 67MB)
테스트 7 〉	통과 (35.14ms, 66.4MB)
테스트 8 〉	통과 (131.00ms, 66.6MB)
테스트 9 〉	통과 (951.69ms, 70.5MB)
테스트 10 〉	통과 (6738.02ms, 92.2MB)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	실패 (시간 초과)
채점 결과
정확성: 76.9
합계: 76.9 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        ArrayList<String> enrollList = new ArrayList<>(Arrays.asList(enroll));
        ArrayList<String> referralList = new ArrayList<>(Arrays.asList(referral));
        for(int i = 0; i < seller.length; i++){
            int cost = amount[i]*100;
            String parent = referralList.get(enrollList.indexOf(seller[i]));
            String child = seller[i];
            while(true){
                if(cost < 1)
                    break;
                int nextCost = cost/10;
                answer[enrollList.indexOf(child)] += cost - nextCost;
                if(parent.equals("-"))
                    break;
                cost = nextCost;
                child = parent;
                parent = referralList.get(enrollList.indexOf(child));
            }
        }

        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.22ms, 52MB)
테스트 2 〉	통과 (0.25ms, 52.7MB)
테스트 3 〉	통과 (0.31ms, 52.2MB)
테스트 4 〉	통과 (0.32ms, 52.2MB)
테스트 5 〉	통과 (0.60ms, 53.8MB)
테스트 6 〉	통과 (7.48ms, 67.4MB)
테스트 7 〉	통과 (7.05ms, 67.3MB)
테스트 8 〉	통과 (8.18ms, 63.4MB)
테스트 9 〉	통과 (12.71ms, 67.8MB)
테스트 10 〉	통과 (31.04ms, 92.8MB)
테스트 11 〉	통과 (27.98ms, 92.2MB)
테스트 12 〉	통과 (26.05ms, 91.9MB)
테스트 13 〉	통과 (24.35ms, 89.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Person{
        int sum;
        String name;
        Person parent;
        Person(int sum, String name, Person parent){
            this.sum = sum;
            this.name = name;
            this.parent = parent;
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        HashMap<String, Person> map = new HashMap<>();

        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i],new Person(0,enroll[i],null));
        }

        for(int i = 0; i < referral.length; i++){
            if(referral[i].equals("-"))
                continue;
            map.get(enroll[i]).parent = map.get(referral[i]);
        }

        for(int i = 0; i < seller.length; i++){
            int price = amount[i]*100;
            Person p = map.get(seller[i]);
            while(true){
                int nextPrice = price/10;
                p.sum += price-nextPrice;
                if(p.parent == null || nextPrice < 1)
                    break;
                p = p.parent;
                price = nextPrice;
            }
        }
        for(int i = 0; i < enroll.length; i++){
            answer[i] = map.get(enroll[i]).sum;
        }
        return answer;
    }
}
