package hashmap;

import java.util.HashSet;

public class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = n;
        while (true) {
             sum = getSum(sum);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) { //
                return false;
            } else {
                set.add(sum);
            }
        }
    }

    private int getSum(int n) { // 理解快乐数的规则
        int sum = 0;
        while (n > 0) {
            sum += (n % 10 ) * (n % 10); // 先取余
            n = n/10; // 取整
        }
        return sum;
    }
}
