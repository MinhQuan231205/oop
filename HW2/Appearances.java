import java.util.*;
public class Appearances {
    public static  <T> int sameCount(Collection<T> a, Collection<T> b) {
        Map<Integer, Integer> a0 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> b0 = new HashMap<Integer, Integer>();
        int key = 0;

        for (T x : a) {
            key = x.hashCode();
            if (a0.containsKey(key)) {
                a0.replace(key, a0.get(key) + 1);
            }
            else {
                a0.put(key, 1);
            }
        }
        for (T y : b) {
            key = y.hashCode();
            if (b0.containsKey(key)) {
                b0.replace(key, b0.get(key) + 1);
            } else {
                b0.put(key, 1);
            }
        }

        int cnt = 0;
        for (int i : a0.keySet()) {
            if (b0.containsKey(i)) {
                if (b0.get(i).equals(a0.get(i)))
                    cnt++;
            }
        }
        return cnt;
    }

}
