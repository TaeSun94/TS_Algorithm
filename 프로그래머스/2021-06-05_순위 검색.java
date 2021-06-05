/*
정확성  테스트
테스트 1 〉	통과 (5.18ms, 52.9MB)
테스트 2 〉	실패 (런타임 에러)
테스트 3 〉	실패 (런타임 에러)
테스트 4 〉	실패 (런타임 에러)
테스트 5 〉	통과 (57.37ms, 56.6MB)
테스트 6 〉	통과 (48.55ms, 62MB)
테스트 7 〉	실패 (런타임 에러)
테스트 8 〉	통과 (110.96ms, 77.3MB)
테스트 9 〉	통과 (134.21ms, 85.4MB)
테스트 10 〉	통과 (130.91ms, 85.8MB)
테스트 11 〉	통과 (46.00ms, 56.6MB)
테스트 12 〉	통과 (53.85ms, 61MB)
테스트 13 〉	실패 (런타임 에러)
테스트 14 〉	통과 (97.94ms, 70.9MB)
테스트 15 〉	통과 (99.06ms, 72.4MB)
테스트 16 〉	실패 (런타임 에러)
테스트 17 〉	통과 (47.05ms, 57.3MB)
테스트 18 〉	통과 (101.78ms, 70.6MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 26.7
효율성: 0.0
합계: 26.7 / 100.0
*/
import java.util.*;
class Solution {
    static HashMap<String, ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(int i = 0; i < info.length; i++){
            dfs("",info[i].split(" "),0);
        }

        int[] answer = new int[query.length];
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
            // System.out.println(key+" "+map.get(key).toString());
        }
        for(int i = 0; i < query.length; i++){
          String[] query_data = query[i].split(" ");
			String[] data = new String[5];
			int idx = 0;
			for(int j = 0; j < query_data.length; j++) {
				if(query_data[j].equals("and"))
					continue;
				data[idx++] = query_data[j];
			}
            for(int num: map.get(str)){
                if(num >= score){
                    break;
                }
                pos++;
            }
            answer[i] = map.get(str).size()- pos;
        }
        return answer;
    }
    public void dfs(String st, String[] info, int cnt){
        if(cnt == 4){
            if(map.containsKey(st)){
                map.get(st).add(Integer.parseInt(info[cnt]));
            }
            else{
                map.put(st,new ArrayList<>());
                map.get(st).add(Integer.parseInt(info[cnt]));
            }
            return;
        }
        dfs(st+"-",info,cnt+1);
        dfs(st+info[cnt],info,cnt+1);
    }
}


/*
정확성  테스트
테스트 1 〉	통과 (3.96ms, 53.7MB)
테스트 2 〉	통과 (4.61ms, 52.6MB)
테스트 3 〉	통과 (6.00ms, 52.7MB)
테스트 4 〉	통과 (15.23ms, 55.8MB)
테스트 5 〉	통과 (25.79ms, 55.9MB)
테스트 6 〉	통과 (46.16ms, 64.2MB)
테스트 7 〉	통과 (28.02ms, 56.1MB)
테스트 8 〉	통과 (134.61ms, 89.4MB)
테스트 9 〉	통과 (133.91ms, 90.1MB)
테스트 10 〉	통과 (129.99ms, 81.6MB)
테스트 11 〉	통과 (31.15ms, 54.8MB)
테스트 12 〉	통과 (46.54ms, 55.3MB)
테스트 13 〉	통과 (30.76ms, 56.2MB)
테스트 14 〉	통과 (86.14ms, 60.3MB)
테스트 15 〉	통과 (97.27ms, 73.7MB)
테스트 16 〉	통과 (25.78ms, 55.3MB)
테스트 17 〉	통과 (48.90ms, 62MB)
테스트 18 〉	통과 (87.09ms, 67.7MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 40.0
효율성: 0.0
합계: 40.0 / 100.0
*/
import java.util.*;
class Solution {
    static HashMap<String, ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(int i = 0; i < info.length; i++){
            dfs("",info[i].split(" "),0);
        }

        int[] answer = new int[query.length];
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
        }
        for(int i = 0; i < query.length; i++){
            String[] query_data = query[i].split(" ");
			String[] data = new String[5];
			int idx = 0;
			for(int j = 0; j < query_data.length; j++) {
				if(query_data[j].equals("and"))
					continue;
				data[idx++] = query_data[j];
			}
            String str = "";
            for(int j = 0; j < data.length-1; j++){
                str += data[j];
            }
            // System.out.println(str);
            int pos = 0;
            if(!map.containsKey(str)){
                continue;
            }
            // int low = 0;
            // int high = map.get(str).size()-1;
            // while(low<=high){
            //     int mid=(low+high)/2;
            //     if(map.get(str).get(mid)<Integer.parseInt(data[4])){
            //         low=mid+1;
            //     }else{
            //         high=mid-1;
            //     }
            // }
            // answer[i] = map.get(str).size() - low;
            for(int num: map.get(str)){
                if(num >= Integer.parseInt(data[4])){
                    break;
                }
                pos++;
            }
            answer[i] = map.get(str).size()- pos;
        }
        return answer;
    }
    public void dfs(String st, String[] info, int cnt){
        if(cnt == 4){
            if(map.containsKey(st)){
                map.get(st).add(Integer.parseInt(info[cnt]));
            }
            else{
                map.put(st,new ArrayList<>());
                map.get(st).add(Integer.parseInt(info[cnt]));
            }
            return;
        }
        dfs(st+"-",info,cnt+1);
        dfs(st+info[cnt],info,cnt+1);
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (4.48ms, 52.6MB)
테스트 2 〉	통과 (4.93ms, 52.6MB)
테스트 3 〉	통과 (6.69ms, 52.7MB)
테스트 4 〉	통과 (21.08ms, 55.1MB)
테스트 5 〉	통과 (24.51ms, 56MB)
테스트 6 〉	통과 (32.25ms, 60.8MB)
테스트 7 〉	통과 (27.21ms, 56.8MB)
테스트 8 〉	통과 (110.54ms, 82.2MB)
테스트 9 〉	통과 (137.09ms, 84.5MB)
테스트 10 〉	통과 (137.95ms, 86.2MB)
테스트 11 〉	통과 (29.99ms, 54.8MB)
테스트 12 〉	통과 (36.54ms, 58.9MB)
테스트 13 〉	통과 (30.09ms, 55.6MB)
테스트 14 〉	통과 (77.79ms, 68.3MB)
테스트 15 〉	통과 (69.13ms, 66.4MB)
테스트 16 〉	통과 (30.00ms, 55.3MB)
테스트 17 〉	통과 (34.79ms, 55MB)
테스트 18 〉	통과 (92.86ms, 70.3MB)
효율성  테스트
테스트 1 〉	통과 (1172.87ms, 239MB)
테스트 2 〉	통과 (1082.09ms, 210MB)
테스트 3 〉	통과 (1110.40ms, 210MB)
테스트 4 〉	통과 (1108.56ms, 216MB)
채점 결과
정확성: 40.0
효율성: 60.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static HashMap<String, ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(int i = 0; i < info.length; i++){
            dfs("",info[i].split(" "),0);
        }

        int[] answer = new int[query.length];
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
        }
        for(int i = 0; i < query.length; i++){
            String[] query_data = query[i].split(" ");
			String[] data = new String[5];
			int idx = 0;
			for(int j = 0; j < query_data.length; j++) {
				if(query_data[j].equals("and"))
					continue;
				data[idx++] = query_data[j];
			}
            String str = "";
            for(int j = 0; j < data.length-1; j++){
                str += data[j];
            }
            if(!map.containsKey(str)){
                continue;
            }
            int low = 0;
            int high = map.get(str).size()-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(map.get(str).get(mid)<Integer.parseInt(data[4])){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            answer[i] = map.get(str).size() - low;
            // int pos = 0;
            // for(int num: map.get(str)){
            //     if(num >= Integer.parseInt(data[4])){
            //         break;
            //     }
            //     pos++;
            // }
            // answer[i] = map.get(str).size()- pos;
        }
        return answer;
    }
    public void dfs(String st, String[] info, int cnt){
        if(cnt == 4){
            if(map.containsKey(st)){
                map.get(st).add(Integer.parseInt(info[cnt]));
            }
            else{
                map.put(st,new ArrayList<>());
                map.get(st).add(Integer.parseInt(info[cnt]));
            }
            return;
        }
        dfs(st+"-",info,cnt+1);
        dfs(st+info[cnt],info,cnt+1);
    }
}
