/*
정확성  테스트
테스트 1 〉	통과 (8.72ms, 54.4MB)
테스트 2 〉	통과 (7.73ms, 53.5MB)
테스트 3 〉	통과 (9.24ms, 52.1MB)
테스트 4 〉	실패 (7.64ms, 53.3MB)
테스트 5 〉	실패 (7.75ms, 53.2MB)
테스트 6 〉	통과 (10.79ms, 52.1MB)
테스트 7 〉	통과 (21.12ms, 53.7MB)
테스트 8 〉	통과 (28.39ms, 53.2MB)
테스트 9 〉	통과 (9.75ms, 53.5MB)
테스트 10 〉	통과 (10.27ms, 53MB)
테스트 11 〉	통과 (9.99ms, 53.7MB)
테스트 12 〉	실패 (16.40ms, 53.2MB)
테스트 13 〉	통과 (13.16ms, 53.3MB)
테스트 14 〉	실패 (9.42ms, 53.8MB)
테스트 15 〉	통과 (12.32ms, 52.6MB)
테스트 16 〉	통과 (9.72ms, 53.5MB)
테스트 17 〉	통과 (9.93ms, 53.6MB)
테스트 18 〉	통과 (10.01ms, 52.8MB)
테스트 19 〉	실패 (10.44ms, 53MB)
테스트 20 〉	실패 (9.80ms, 53.2MB)
테스트 21 〉	통과 (21.69ms, 53.4MB)
테스트 22 〉	통과 (13.30ms, 52.9MB)
테스트 23 〉	통과 (9.69ms, 53.8MB)
테스트 24 〉	통과 (16.19ms, 52.8MB)
테스트 25 〉	실패 (8.51ms, 52.6MB)
테스트 26 〉	실패 (7.89ms, 52.4MB)
테스트 27 〉	실패 (8.55ms, 53.6MB)
테스트 28 〉	실패 (8.75ms, 53.4MB)
테스트 29 〉	통과 (38.32ms, 58MB)
테스트 30 〉	실패 (31.08ms, 57.7MB)
채점 결과
정확성: 63.3
합계: 63.3 / 100.0
*/
import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        for(int i = 0; i < musicinfos.length; i++){
            String[] arr = musicinfos[i].split(",");
            String[] start = arr[0].split(":");
            String[] end = arr[1].split(":");

            int runningTime = (Integer.parseInt(end[0])-Integer.parseInt(start[0]))*60+Integer.parseInt(end[1])-Integer.parseInt(start[1]);
            String song = "";
            Queue<String> que = new LinkedList<>();
            for(int j = 0; j < arr[3].length(); j++){
                String tmp =""+arr[3].charAt(j);
                if(j!= arr[3].length()-1&&arr[3].charAt(j+1)=='#'){
                    tmp += '#';
                    j+=1;
                }
                que.add(tmp);
            }
            for(int j = 0; j < runningTime/que.size(); j++){
                song += arr[3];
            }
            for(int j = 0; j < runningTime%que.size(); j++){
                song += que.poll();
            }
            if(song.contains(m)){
                answer = arr[2];
            }
        }

        return answer;
    }
}

/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (14.74ms, 52.1MB)
테스트 2 〉	통과 (14.63ms, 54.5MB)
테스트 3 〉	통과 (15.24ms, 53.2MB)
테스트 4 〉	실패 (23.74ms, 53.7MB)
테스트 5 〉	통과 (17.90ms, 53.7MB)
테스트 6 〉	통과 (19.90ms, 53.4MB)
테스트 7 〉	실패 (메모리 초과)
테스트 8 〉	실패 (메모리 초과)
테스트 9 〉	실패 (메모리 초과)
테스트 10 〉	실패 (메모리 초과)
테스트 11 〉	실패 (메모리 초과)
테스트 12 〉	실패 (메모리 초과)
테스트 13 〉	실패 (메모리 초과)
테스트 14 〉	실패 (메모리 초과)
테스트 15 〉	실패 (메모리 초과)
테스트 16 〉	실패 (메모리 초과)
테스트 17 〉	실패 (메모리 초과)
테스트 18 〉	실패 (메모리 초과)
테스트 19 〉	실패 (메모리 초과)
테스트 20 〉	실패 (메모리 초과)
테스트 21 〉	실패 (메모리 초과)
테스트 22 〉	실패 (메모리 초과)
테스트 23 〉	실패 (메모리 초과)
테스트 24 〉	실패 (메모리 초과)
테스트 25 〉	통과 (16.56ms, 53.1MB)
테스트 26 〉	통과 (14.90ms, 53.7MB)
테스트 27 〉	실패 (19.64ms, 53.4MB)
테스트 28 〉	실패 (17.26ms, 53.7MB)
테스트 29 〉	통과 (56.67ms, 70.3MB)
테스트 30 〉	실패 (메모리 초과)
채점 결과
정확성: 26.7
합계: 26.7 / 100.0
*/
import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String str = "";
        for(int i = 0; i < m.length(); i++){
            char c = m.charAt(i);
            if(i!= m.length()-1 && m.charAt(i+1)=='#'){
                c = (char)(c+32);
                i+=1;
            }
            str += c;
        }
        m = str;
        for(int i = 0; i < musicinfos.length; i++){
            String[] arr = musicinfos[i].split(",");
            String[] start = arr[0].split(":");
            String[] end = arr[1].split(":");
            int runningTime = (Integer.parseInt(end[0])-Integer.parseInt(start[0]))*60+Integer.parseInt(end[1])-Integer.parseInt(start[1]);
            String song = "";
            Queue<String> que = new LinkedList<>();
            for(int j = 0; j < arr[3].length(); j++){
                String tmp =""+arr[3].charAt(j);
                if(j!= arr[3].length()-1&&arr[3].charAt(j+1)=='#'){
                    tmp = ""+(char)(arr[3].charAt(j)+32);
                    j+=1;
                }
                que.add(tmp);
                song+=tmp;
            }
            for(int j = 0; j < runningTime/que.size()-1; j++){
                song += song;
            }
            for(int j = 0; j < runningTime%que.size(); j++){
                song += que.poll();
            }
            if(song.contains(m)){
                answer = arr[2];
            }
        }

        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (14.55ms, 53.5MB)
테스트 2 〉	통과 (16.41ms, 54.1MB)
테스트 3 〉	통과 (14.62ms, 52.4MB)
테스트 4 〉	통과 (14.76ms, 52.9MB)
테스트 5 〉	통과 (14.37ms, 53.8MB)
테스트 6 〉	통과 (20.98ms, 53.5MB)
테스트 7 〉	통과 (16.54ms, 54MB)
테스트 8 〉	통과 (32.00ms, 54.2MB)
테스트 9 〉	통과 (19.88ms, 54MB)
테스트 10 〉	통과 (25.92ms, 53.8MB)
테스트 11 〉	통과 (23.03ms, 53.4MB)
테스트 12 〉	통과 (16.73ms, 53.6MB)
테스트 13 〉	통과 (15.87ms, 53.4MB)
테스트 14 〉	통과 (17.76ms, 53.7MB)
테스트 15 〉	통과 (16.16ms, 52.7MB)
테스트 16 〉	통과 (22.29ms, 53.8MB)
테스트 17 〉	통과 (19.56ms, 53.1MB)
테스트 18 〉	통과 (16.44ms, 54MB)
테스트 19 〉	통과 (22.27ms, 57.5MB)
테스트 20 〉	통과 (29.97ms, 55.2MB)
테스트 21 〉	통과 (18.89ms, 55.1MB)
테스트 22 〉	통과 (17.84ms, 53.8MB)
테스트 23 〉	통과 (20.04ms, 52.9MB)
테스트 24 〉	통과 (16.21ms, 54MB)
테스트 25 〉	통과 (16.18ms, 53.6MB)
테스트 26 〉	통과 (14.74ms, 54.2MB)
테스트 27 〉	통과 (14.72ms, 52.8MB)
테스트 28 〉	통과 (14.86ms, 53.2MB)
테스트 29 〉	통과 (65.91ms, 70.7MB)
테스트 30 〉	통과 (67.66ms, 70.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String str = "";
        for(int i = 0; i < m.length(); i++){
            char c = m.charAt(i);
            if(i!= m.length()-1 && m.charAt(i+1)=='#'){
                c = (char)(c+32);
                i+=1;
            }
            str += c;
        }
        m = str;
        int maxTime = 0;
        for(int i = 0; i < musicinfos.length; i++){
            String[] arr = musicinfos[i].split(",");
            String[] start = arr[0].split(":");
            String[] end = arr[1].split(":");
            int runningTime = (Integer.parseInt(end[0])-Integer.parseInt(start[0]))*60+Integer.parseInt(end[1])-Integer.parseInt(start[1]);
            String song = "";
            for(int j = 0; j < arr[3].length(); j++){
                String tmp =""+arr[3].charAt(j);
                if(j!= arr[3].length()-1&&arr[3].charAt(j+1)=='#'){
                    tmp = ""+(char)(arr[3].charAt(j)+32);
                    j+=1;
                }
                song+=tmp;
            }
            String melody = "";
            for(int j = 0; j < runningTime/song.length(); j++){
                melody += song;
            }
            for(int j = 0; j < runningTime%song.length(); j++){
                melody += song.charAt(j);
            }
            if(melody.contains(m)){
                if(maxTime<runningTime){
                    answer = arr[2];
                    maxTime = runningTime;
                }
            }
        }

        return answer;
    }
}
