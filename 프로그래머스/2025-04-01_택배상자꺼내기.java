class Solution {
    public int solution(int n, int w, int num) {
        // 1. Num의 위치 파악
        int numDepth = num/w;
        if (num % w == 0) {
            numDepth -=1;
        }
        int numIndex = num%w;

        // depth의 Even Odd에 따라 index가 달라짐
        if(numDepth%2 == 0) {
            if (numIndex == 0) {
                numIndex = w;
            }
        } else {
            if (numIndex == 0) {
                numIndex = 1;
            } else {
                numIndex = w + 1 - numIndex;
            }
        }

        // 2. num으로 최상단에 데이터가 있는지 파악
        boolean flag = false;
        int maxDepth = n/w;
        
        if(maxDepth%2 == 0) {
            int highestNumIndex = maxDepth * w + numIndex;
            if(highestNumIndex <= n) {
                flag = true;
            }
        } else {
            int highestNumIndex = (maxDepth + 1)*w - numIndex + 1;
            if(highestNumIndex <= n) {
                flag = true;
            }
        }
        
        // 3. 최종 depth에서 Num의 depth를 제외한 데이터 추출
        int answer = maxDepth;
        if(flag) {
            answer += 1;
        }
        
        answer -= numDepth;
        return answer;
    }
}
