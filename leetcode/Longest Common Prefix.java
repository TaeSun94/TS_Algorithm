import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        int min_len = Integer.MAX_VALUE;
        String tempStr = "";
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            if(min_len > len) {
                min_len = len;
                tempStr = strs[i];
            }
        }

        String res = "";
        if(tempStr.length() == 0) {
            return res;
        }
        
        int idx = 0;
        while(idx < min_len) {
            boolean flag = false;
            res += tempStr.charAt(idx);
            for(int i = 0; i < strs.length; i++) {
                if(strs[i].equals(tempStr)) {
                    continue;
                }
                if(!strs[i].substring(0,idx+1).equals(res)) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                res = res.substring(0,idx);
                break;
            }
            idx++;
        }

        return res;
    }
}
