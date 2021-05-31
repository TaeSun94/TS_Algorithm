class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int count = 0;
        int zero = 0;
        while(true){
            if(s.equals("1")){
                answer[0] = count;
                answer[1] = zero;
                break;
            }
            String str = "";
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i)=='1'){
                    str += '1';
                }
                else
                    zero++;
            }
            s = Integer.toBinaryString(str.length());
            count++;
        }

        return answer;
    }
}
