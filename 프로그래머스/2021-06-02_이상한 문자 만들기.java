class Solution {
    public String solution(String s) {
        String answer = "";
        int pos = 0;
        s = s.toLowerCase();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i)==' '){
                pos = 0;
                answer+= " ";
                continue;
            }
            if(pos%2==0){
                answer += (char)(s.charAt(i)-32);
            }
            else{
                answer += s.charAt(i);
            }
            pos++;
        }
        return answer;
    }
}
