package 쩜문제추천;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> set = new ArrayList<>();
		ArrayList<Integer> tmpSet = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
		for (int m = 0; m < M; m++) {
			String[] split = br.readLine().split(" ");
			if (split.length > 1) {
				if (split[0].equals("add")) {
					if(!set.contains(Integer.parseInt(split[1]))) {
						set.add(Integer.parseInt(split[1]));
					}
				} else if (split[0].equals("remove")) {
					if(set.contains(Integer.parseInt(split[1]))) {
						set.remove(set.indexOf(Integer.parseInt(split[1])));
					}
				} else if (split[0].equals("check")) {
//					System.out.println(set.toString());
					if(set.contains(Integer.parseInt(split[1]))) {
						sb.append(1+"\n");
					}
					else {
						sb.append(0+"\n");
					}
				} else {
					if(set.contains(Integer.parseInt(split[1]))) {
						set.remove(set.indexOf(Integer.parseInt(split[1])));
					}
					else {
						set.add(Integer.parseInt(split[1]));
					}
				}
			} else {
				if (split[0].equals("all")) {
					set = (ArrayList<Integer>) tmpSet.clone();
				} else {
					set.clear();
				}
			}
		}
		System.out.println(sb.toString());
	}
}
