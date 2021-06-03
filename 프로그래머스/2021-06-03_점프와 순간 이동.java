/*
풀이: integer값을 binary로 변환하여 1의 갯수로 판별
이제까지 이동한 거리 x 2에서 건전지 소모가 일어나지 않는다 => shift연산은 1의 갯수가 늘어나지 않고 10진법 숫자에 x2값이랑 같다를 이용함
*/
public class Solution {
    public int solution(int n) {
        int ans = 0;
        String str = Integer.toBinaryString(n);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='1')
                ans++;
        }
        return ans;
    }
}
