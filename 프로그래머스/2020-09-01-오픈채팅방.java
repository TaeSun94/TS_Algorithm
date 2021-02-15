package 코딩테스트문제;
import java.util.*;

//20분 걸림
// uid를 이용한 해쉬 맵생성.
/*
String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

 */
public class 오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[][] change_record = new String[record.length][2];
		HashMap<String, String> hm = new HashMap<String, String>();
		int idx = 0;
		for(int i = 0; i < record.length; i++) {
			String tmp = record[i];
			String[] parse = tmp.split(" ");
			if(hm.containsKey(parse[1])) {
				if(parse[0].equals("Change")) {
					hm.remove(parse[1]);
					hm.put(parse[1], parse[2]);
				}
				else if(parse[0].equals("Enter")) {
					hm.remove(parse[1]);
					hm.put(parse[1], parse[2]);
				}
			}
			else {
				hm.put(parse[1], parse[2]);
			}
			if(parse[0].equals("Enter")) {
				change_record[idx][0] = "님이 들어왓습니다.";
				change_record[idx][1] = parse[1];
				idx++;
			}
			else if(parse[0].equals("Leave")) {
				change_record[idx][0] = "님이 나갔습니다.";
				change_record[idx][1] = parse[1];
				idx++;
			}
		}
		String[] answer = new String[idx];
		for(int i = 0; i < idx; i++) {
			answer[i] = hm.get(change_record[i][1])+change_record[i][0];
		}
		System.out.println(Arrays.toString(answer));
	}
}
