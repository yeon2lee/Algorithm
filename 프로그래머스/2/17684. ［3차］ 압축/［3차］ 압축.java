import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int idx = 0;

        while (idx + 1 < msg.length()){
            String cur = "";
            String pre = String.valueOf(msg.charAt(idx));

            for (int i = 1; idx + i <= msg.length() ; i++) {
                cur = msg.substring(idx, idx + i);
                if(!map.containsKey(cur)){
                    map.put(cur, map.size() + 1);
                    break;
                }
                pre = cur;
            }

            result.add(map.get(pre));
            idx = idx + pre.length();
        }

        if (idx == msg.length() - 1){
            result.add(map.get(String.valueOf(msg.charAt(idx))));
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}