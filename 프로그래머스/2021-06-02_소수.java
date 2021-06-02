/*
에라토스테네스의 체 이용
n 까지의 모든 소수를 판별
시간 복잡도: O(nloglogn)
*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[n+1];
        check[0] = true;
        check[1] = true;
        for(int i = 2; i <= n; i++){
            if(check[i]) continue;
            for(int j = i+i; j <= n; j += i){
                check[j] = true;
            }
        }
        for(boolean flag: check){
            if(!flag)
                answer++;
        }
        return answer;
    }
}
