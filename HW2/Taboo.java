import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Taboo<T> {
    private List<T> rule;

    public Taboo(List<T> rule) {
        this.rule = rule;
    }
    public Set<T> noFollow(T elem) {
        Set<T> set = new HashSet<T>();
        for (int i=0; i<rule.size()-1; i++) {
            T x = rule.get(i);
            T y = rule.get(i+1);
            if (y != null && x != null && x.equals(elem)) {
                set.add(y);
            }
        }
        return set;
    }
    public void reduce(List<T> list) {
        for (int i=0; i<list.size()-1; i++) {
            T x = list.get(i);
            T y = list.get(i+1);
            if (noFollow(x).contains(y)) {
                list.remove(i+1);
                i--;
            }
        }
    }
}
