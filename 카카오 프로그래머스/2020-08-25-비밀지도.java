import java.util.Arrays;
import java.util.Scanner;
/*
int n = 5;
int[] arr1 = {9,20,28,18,11};
int[] arr2 = {30,1,21,17,28};


int n = 6;
int[] arr1 = {46,33,33,22,31,50};
int[] arr2 = {27,56,19,14,14,10};
 */
public class 비밀지도 {
	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = {46,33,33,22,31,50};
		int[] arr2 = {27,56,19,14,14,10};

		//2진수로 변환
		int[][] map1 = new int[n][n];
		int[][] map2 = new int[n][n];

		for(int i = 0; i < n; i++) {
			int tmp = arr1[i];
			for(int j = 0; j < n; j++) {
				if(tmp-Math.pow(2, n-j-1)>=0) {
					tmp -= Math.pow(2, n-j-1);
					map1[i][j] = 1;
				}
				else {
					map1[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			int tmp = arr2[i];
			for(int j = 0; j < n; j++) {
				if(tmp-Math.pow(2, n-j-1)>=0) {
					tmp -= Math.pow(2, n-j-1);
					map2[i][j] = 1;
				}
				else {
					map2[i][j] = 0;
				}
			}
		}
		//answer배열
		char[][] answer = new char[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map1[i][j] == 1 ||map2[i][j] == 1) {
					answer[i][j]='#';
				}
				else {
					answer[i][j] =' ';
				}
			}
		}
		for(int i = 0; i < n; i++) {
			String tp = new String(answer[i]);
			System.out.println(tp);
		}
		System.out.println();
		//최종 나오는 string 배열
		String[] ans = new String[n];
		for(int i = 0; i < n; i++) {
			String tmp = "";
			for(int j = 0; j < n; j++) {
				tmp += answer[i][j];
			}
			ans[i] = tmp;
		}
		System.out.println(Arrays.toString(ans));
	}
}
