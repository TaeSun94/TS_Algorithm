class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = (int)(Math.log(n) / Math.log(2));
        int left = 1;
        int right = n;
        while(true){
            if(answer == 1){
                break;
            }
            if(a>(left+right)/2 && b >(left+right)/2){
                left = (left+right)/2+1;
                answer-=1;
            }
            else if( a <= (left+right)/2 && b <= (left+right)/2){
                right = (left+right)/2;
                answer-=1;
            }
            else
                break;
        }
        return answer;
    }
}
