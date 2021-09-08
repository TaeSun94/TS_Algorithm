package 쩜문제추천;
import java.util.*;
public class Hashing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next().trim();
		long number = 0;
		for(int i = 0; i < str.length(); i++) {
			number += (str.charAt(i)-'a'+1)*Math.pow(31, i)%1234567891;
		}
		System.out.println(number%1234567891);
	}
}
