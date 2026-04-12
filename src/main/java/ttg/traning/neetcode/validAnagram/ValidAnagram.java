package ttg.traning.neetcode.validAnagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ttg
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<String, Integer> mapS = new HashMap<>();
        for (char ch : s.toCharArray()) {
            String chStr = String.valueOf(ch);
            if (mapS.containsKey(chStr)) {
                mapS.put(chStr, mapS.get(chStr) + 1);
            } else {
                mapS.put(chStr, 1);
            }
        }

        Map<String, Integer> mapT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            String chStr = String.valueOf(ch);
            if (mapT.containsKey(chStr)) {
                mapT.put(chStr, mapT.get(chStr) + 1);
            } else {
                mapT.put(chStr, 1);
            }
        }

        for (Map.Entry<String, Integer> entryS : mapS.entrySet()) {
            if (!mapT.containsKey(entryS.getKey()) || !Objects.equals(mapT.get(entryS.getKey()), entryS.getValue())) {
                return false;
            }
        }
        for (Map.Entry<String, Integer> entryT : mapT.entrySet()) {
            if (!mapS.containsKey(entryT.getKey()) || !Objects.equals(mapS.get(entryT.getKey()), entryT.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }

    public boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
