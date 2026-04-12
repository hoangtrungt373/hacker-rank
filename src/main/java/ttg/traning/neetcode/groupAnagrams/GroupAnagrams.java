package ttg.traning.neetcode.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import ttg.traning.neetcode.validAnagram.ValidAnagram;

/**
 *
 * @author ttg
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> strArr = Arrays.stream(strs).toList();
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }

        ValidAnagram validAnagram = new ValidAnagram();
        Set<String> existing = new HashSet<>();
        for (int s = 0; s < strArr.size(); s++) {
            String strS = strArr.get(s);
            if (existing.contains(strS)) continue;
            List<String> subArr = new ArrayList<>();
            subArr.add(strS);
            for (int t = 0; t < strArr.size(); t++) {
                String strT = strArr.get(t);
                if (s != t && validAnagram.isAnagramV2(strS, strT)) {
                    subArr.add(strT);
                }
            }
            result.add(subArr);
            existing.addAll(subArr);
        }
        return result;
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) {
            return result;
        }

        Map<List<Integer>, List<String>> countFreqStrMap = new HashMap<>();
        for (String s : Arrays.stream(strs).toList()) {
            List<Integer> freg = countFreq(s);
            countFreqStrMap.computeIfAbsent(freg, k -> new ArrayList<>()).add(s);
        }

        return countFreqStrMap.values().stream().toList();
    }

    private List<Integer> countFreq(String s) {
        int[] count = new int[26];
        for (Character c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return Arrays.stream(count).boxed().toList();
    }

    public List<List<String>> groupAnagramsV3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // Create a string key like "#1#2#0#3..."
            StringBuilder keyBuilder = new StringBuilder();
            for (int num : count) {
                keyBuilder.append('#').append(num);
            }
            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
