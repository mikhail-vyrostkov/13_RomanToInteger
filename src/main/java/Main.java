import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(Solution.romanToInt(s));
    }

    public static class Solution {

        public static int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int out = map.get(s.charAt(s.length() - 1));
            for (int i = s.length() - 1; i > 0; i--) {
                if (map.containsKey(s.charAt(i))) {
                    if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                        out = out - map.get(s.charAt(i - 1));
                    } else {
                        out = out + map.get(s.charAt(i - 1));
                    }
                } else {
                    return 0;
                }
            }
            return out;
        }
    }
}
