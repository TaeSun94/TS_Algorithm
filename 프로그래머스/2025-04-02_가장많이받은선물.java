import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> ranks = new HashMap<>();
        HashMap<String, Integer> indexs = new HashMap<>();
        int[][] giftCounts = new int[friends.length][friends.length];
        
        for (int i = 0; i < friends.length; i++) {
            ranks.put(friends[i],0);
            indexs.put(friends[i],i);
        }
        
        for (int i = 0; i < gifts.length; i++) {
            String[] splitGiftsData = gifts[i].split(" ");
            int recipientIndex = indexs.get(splitGiftsData[1]);;
            int giverIndex = indexs.get(splitGiftsData[0]);
            
            ranks.replace(splitGiftsData[0], ranks.get(splitGiftsData[0]) + 1);
            ranks.replace(splitGiftsData[1], ranks.get(splitGiftsData[1]) - 1);
            
            giftCounts[giverIndex][recipientIndex]++;
        }
        
        for (int i = 0; i < giftCounts.length; i++) {
            int sum = 0;
            
            for (int j = 0; j < giftCounts[i].length; j++) {
                if(i==j) {
                    continue;
                }
                
                if(giftCounts[i][j] == giftCounts[j][i]) {
                    if(ranks.get(friends[i]) > ranks.get(friends[j])) {
                        sum++;
                    }
                } else if (giftCounts[i][j] > giftCounts[j][i]) {
                    sum++;
                }
            }
            
            answer = answer < sum ? sum : answer;
        }
        
        return answer;
    }
}
