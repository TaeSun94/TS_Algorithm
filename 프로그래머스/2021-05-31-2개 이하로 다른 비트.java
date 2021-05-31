/*
10,11번 시간초과 코드
*/
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String numberbinary = Long.toBinaryString(numbers[i]);
            String tmp = "";
            for(int j = 0; j<numberbinary.length(); j++){
                tmp+="1";
            }
            if(numberbinary.equals(tmp)){

                continue;
            }
            for(long j = numbers[i]+1;;j++){
                String tmpbinary = Long.toBinaryString(j);
                int cnt = 0;
                if(numberbinary.length() < tmpbinary.length()){
                    cnt+=1;
                }

                for(int k = 0; k <numberbinary.length(); k++){
                    if(cnt>2)
                        break;
                    if(numberbinary.charAt(k)!= tmpbinary.charAt(k+tmpbinary.length()-numberbinary.length())){
                        cnt+=1;
                    }
                }

                if(cnt<=2){
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}

/*
올 통과 코드
*/

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String numberbinary = Long.toBinaryString(numbers[i]);
            String tmp = "";
            for(int j = 0; j<numberbinary.length(); j++){
                tmp+="1";
            }
            if(numberbinary.equals(tmp)){
                long num = 0;

                for(int j = tmp.length()-1; j > 0; j--){
                    num += Math.pow(2,tmp.length()-1-j);
                }
                num += Math.pow(2,tmp.length());
                answer[i] = num;
            }
            else{
                tmp = numberbinary;
                int pos = 0;
                for(int j = numberbinary.length()-1; j >= 0; j--){
                    if(numberbinary.charAt(j)=='0'){
                        tmp = tmp.substring(0,j)+"1"+tmp.substring(j+1,tmp.length());
                        pos = j;
                        break;
                    }
                }

                for(int j= pos+1; j < tmp.length(); j++){
                    if(tmp.charAt(j)=='1'){
                        tmp = tmp.substring(0,j)+"0"+tmp.substring(j+1, tmp.length());
                        break;
                    }
                }
                long num = 0;
                for(int j = tmp.length()-1; j >=0; j--){
                    if(tmp.charAt(j)=='1')
                        num += Math.pow(2,tmp.length()-j-1);
                }
                answer[i] = num;
            }
        }
        return answer;
    }
}
