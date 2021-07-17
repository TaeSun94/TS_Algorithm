/*
수식을 만들더라도 java 11버전에선 Scanner를 이용하는 것보단 bufferedReader 이용하여 풀이해야 시간초과를 없앨 수 있던 문제.
*/
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
        int count = (V-B)/(A-B);
        //x를 구하기 위한 점화식 AX - B(X-1)>= V 큰 정수 x를 구하기 문제
        if((V-B)%(A-B)!=0){
            count++;
        }
        System.out.println(count);
	}
}
