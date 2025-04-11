import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int genreTotal = genreMap.get(genres[i]);
            map.put((genres[i] + "," + i), new ArrayList<>(Arrays.asList(genreTotal, plays[i], i)));
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            List<Integer> v1 = map.get(o1);
            List<Integer> v2 = map.get(o2);
    
            if (!v1.get(0).equals(v2.get(0))) {
                return v2.get(0) - v1.get(0); 
            } else if (!v1.get(1).equals(v2.get(1))) {
                return v2.get(1) - v1.get(1); 
            } else {
                return v1.get(2) - v2.get(2); 
            }
        });
        
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String key : keySet) {
            String[] splited = key.split(",");
            int count = countMap.getOrDefault(splited[0], 0);
            if (count < 2) {
                answer.add(Integer.parseInt(splited[1]));  
            }
            countMap.put(splited[0], count + 1);
        }
            
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}