package category.backtracking.queen;

import java.util.*;

public class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Deque<String> path = new LinkedList<>();
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        // HashMap<from, TreeMap<to, count>>
        // t.get(0) = from
        // t.get(1) = to
        // count 票数
        for (List<String> t : tickets) {
            String from = t.get(0);
            String to = t.get(1);
            map.putIfAbsent(from, new TreeMap<>());
            TreeMap<String, Integer> treeMap = map.get(from);
            treeMap.put(to, treeMap.getOrDefault(to, 0) + 1);
        }
        // 起点
        path.addLast("JFK");
        dfs(tickets.size(), 0, path, map);
        return new ArrayList<>(path);
    }

    // 带返回值表示找到一组就可以结束
    private boolean dfs(int ticketNum, int progress, Deque<String> res, Map<String, TreeMap<String, Integer>> map) {
        if (progress == ticketNum) {
            return true;
        }
        // 出发的起点的路径
        String from = res.peekLast();
        TreeMap<String, Integer> tos = map.get(from);
        if (tos == null || tos.isEmpty()) { // 判空
            return false;
        }
        // 还有可以找的目的地
        // <to, count>
        for (Map.Entry<String, Integer> target : tos.entrySet()) {
            int count = target.getValue();
            if (count == 0) {
                continue;
            }
            // 有票的目的地才能继续找
            String key = target.getKey();
            // 选择
            res.addLast(key);
            target.setValue(count - 1);

            //  找到任何一组合适的值就能返回了
            if (dfs(ticketNum, progress + 1, res, map)) {
                return true;
            }
            // 撤销选择
            res.removeLast();
            target.setValue(count);
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> l0 = new ArrayList<>();
        l0.add("JFK");
        l0.add("SFO");
        List<String> l1 = new ArrayList<>();
        l1.add("JFK");
        l1.add("ATL");
        List<String> l2 = new ArrayList<>();
        l2.add("SFO");
        l2.add("ATL");
        List<String> l3 = new ArrayList<>();
        l3.add("ATL");
        l3.add("JFK");
        List<String> l4 = new ArrayList<>();
        l4.add("ATL");
        l4.add("SFO");
        input.add(l0);
        input.add(l1);
        input.add(l2);
        input.add(l3);
        input.add(l4);

        new Solution332().findItinerary(input);
    }

}
