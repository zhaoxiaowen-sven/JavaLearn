package category.dp.houserob;

public class DropEggs {

    public int drop(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        //  # 最坏情况下的最少扔鸡蛋次数
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(drop(k - 1, i - 1),
                    drop(k, n - i)) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new DropEggs().drop(2, 2));
    }
}
