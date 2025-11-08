import java.util.*;

class EqualFrequency{
    public boolean equalFrequency(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Try removing one occurrence of each character
        for (char ch : word.toCharArray()) {
            freqMap.put(ch, freqMap.get(ch) - 1); // remove one occurrence

            if (freqMap.get(ch) == 0) {
                freqMap.remove(ch); // clean up if count becomes 0
            }

            if (allFrequenciesEqual(freqMap)) {
                return true; // if all are equal after removal → success
            }

            // restore original count for next check
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        return false;
    }

    // Step 3: Helper function to check if all frequencies are equal
    private boolean allFrequenciesEqual(Map<Character, Integer> map) {
        int freqValue = -1;
        for (int val : map.values()) {
            if (freqValue == -1) freqValue = val; // set first value
            else if (val != freqValue) return false; // mismatch → not equal
        }
        return true;
    }

    public static void main(String[] args) {
        EqualFrequency s = new EqualFrequency();
        System.out.println(s.equalFrequency("abcc")); // true
        System.out.println(s.equalFrequency("aazz")); // false
        System.out.println(s.equalFrequency("aabc")); // true
    }
}
