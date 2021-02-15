import java.util.Arrays;

/*
3번의 기회
점수는 0~10
S D T -> 1제곱 2제곱 3제곱, 점수마다 하나씩 존재
*->해당 점수와 바로 전에 얻은 점수를 각 2배 #->해당점수는 마이너스, 점수마다 둘 중 하나만 존재 or 존재x
*는 *와 #의 중첩가능 **-> 4배 *# -> -2배

1S2D*3T -> 2, 8, 27 => 37
 */
/*
"1S2D*3T"
"1D2S#10S"
"1D2S0T"
"1S*2T*3S"
"1D#2S*3S"
"1T2D3D#"
"1D2S3T*"
 */
public class 다트게임 {
	public static void main(String[] args) {
		//점수 배열 생성
		int[] score = new int[3];

		//string 값을 갖고 각 score에 점수 넣기
		String data ="1D2S#10S";
		int idx = 0;
		for(int i = 0; i < 3; i++) {
			int round_score = 0;
			boolean check = false;
			String tmp = "";
			for(int j = idx; j < data.length(); j++) {
				//숫자 만들기
				if(data.charAt(j)-'0' >= 0&&data.charAt(j)-'0' <= 9) {
					if(check) {
						break;
					}
					tmp += data.charAt(j);
					idx++;
				}
				//1번째 조건 S,D,T 관련 제곱근처리
				else if(data.charAt(j)=='S'||data.charAt(j)=='D'||data.charAt(j)=='T') {
					check = true;
					round_score = Integer.parseInt(tmp);
					idx++;
					if(data.charAt(j)=='S') {
						continue;
					}
					else if(data.charAt(j)=='D') {
						round_score = (int)Math.pow(round_score, 2);
					}else {
						round_score = (int)Math.pow(round_score, 3);
					}
				}
				//*,#에 대한 처리
				else {
					idx++;
					if(data.charAt(j)=='*') {
						if(i>0) {
							score[i-1] *= 2;
						}
						round_score *= 2;
					}
					else {
						round_score *= -1;
					}
				}
			}
			//점수 배열에 넣기
			score[i] = round_score;
		}
		int answer = 0;
		for(int i = 0; i<3; i++) {
			answer += score[i];
		}
		System.out.println(answer);
	}
}
