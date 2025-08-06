class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n/a > 0) {
            int newN = (n / a) * b;
            answer += newN;
            n = newN + n%a;
        }
        
        return answer;
    }
}
