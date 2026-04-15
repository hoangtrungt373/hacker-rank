package ttg.traning.neetcode.lruCache;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ttg
 */
public class LRUCache {

    class Node {
        int num;
        int freq;
        long time; // increasing counter
    }

    private Map<Integer, Integer> map;
    private Map<Integer, Integer> freqMap;
    TreeMap<Integer, Deque<Integer>> freqToNums;

    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        freqToNums = new TreeMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            updateFreq(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            updateFreq(key);
        } else {
            if (map.size() == capacity) {
                removeLeast(key);
            }
            map.put(key, value);
            updateFreq(key);
        }
    }

    private void updateFreq(int num) {
        int oldFreq = freqMap.getOrDefault(num, 0);
        int newFreq = oldFreq + 1;
        freqMap.put(num, newFreq);

        if (oldFreq > 0) {
            Deque<Integer> list = freqToNums.getOrDefault(oldFreq, new ArrayDeque<>());
            list.remove(num);
            if (list.isEmpty()) freqToNums.remove(oldFreq);
        }

        freqToNums
                .computeIfAbsent(newFreq, k -> new ArrayDeque<>())
                .add(num);
    }

    private void removeLeast(int currentNum) {
        int leastFreq = freqToNums.firstKey();
        Deque<Integer> leastFreqNums = freqToNums.firstEntry().getValue();
        int least = leastFreqNums.getFirst();
        leastFreqNums.remove(least);
        if (leastFreqNums.isEmpty()) freqToNums.remove(leastFreq);
        freqMap.remove(least);
        map.remove(least);
    }
}
