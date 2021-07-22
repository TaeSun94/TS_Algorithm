import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	static HashMap<String, PriorityQueue<Integer>> gorillas;
	static long sumMoney;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int Q = Integer.parseInt(st.nextToken());
		sumMoney = 0;
		gorillas = new HashMap<>();
		for(int i = 0; i < Q; i++) {
			String[] splitQuery = br.readLine().split(" ");
			execQuery(splitQuery);
		}
		bw.write(sumMoney+"\n");
		bw.flush();
		bw.close();
	}
	private static void execQuery(String[] splitQuery) {
		// TODO Auto-generated method stub
		if(splitQuery[0].equals("1")) {
			addInfo(splitQuery);
		}
		else {
			buyInfo(splitQuery);
		}
		return;
	}
	private static void addInfo(String[] splitQuery) {
		if(gorillas.containsKey(splitQuery[1])) {
			for(int i = 3; i < splitQuery.length; i++) {
				gorillas.get(splitQuery[1]).add(Integer.parseInt(splitQuery[i]));
			}
		}
		else {
			gorillas.put(splitQuery[1], new PriorityQueue<>(Collections.reverseOrder()));
			for(int i = 3; i < splitQuery.length; i++) {
				gorillas.get(splitQuery[1]).add(Integer.parseInt(splitQuery[i]));
			}
		}
	}
	private static void buyInfo(String[] splitQuery) {
		// TODO Auto-generated method stub
		if(gorillas.containsKey(splitQuery[1])) {
			int cnt = 0;
			while(cnt<Integer.parseInt(splitQuery[2])) {
				if(gorillas.get(splitQuery[1]).size()==0) {
					break;
				}
				sumMoney += gorillas.get(splitQuery[1]).poll();
				cnt++;
			}
		}
		return;
	}
}
