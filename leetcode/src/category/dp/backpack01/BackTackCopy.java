package category.dp.backpack01;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class BackTackCopy {

    private int backpack(int n, int w, int[] val, int[] weight) {
        int size = weight.length;
        // 表示容量为 j 时， 前 i 个物品可以装的最大价值
        int[][] dp = new int[size + 1][w + 1];
        // i=0 时
        for (int j = 0; j <= size; j++) {
            dp[0][j] = 0;
        }
        // j = 0;
        for (int i = 0; i <= size; i++) {
            dp[i][0] = 0;
        }
        //                i 个物品放不放,    物品索引从0 开始，所以取重量或价值时 i-1
        // dp[i][j] = max(dp[i - 1][j], dp[i-1][j - w[i - 1]] + value[i - 1]])

        // i = 1,
        // j = 1 , dp[1][1] = dp[0][1] , dp[0][1-w[1]] + value[0] = 15
        // j = 2
        // j = 3
        // j = 4

        // i =2
        for (int i = 1; i <= size; i++) { // 物品
            for (int j = 1; j <= w; j++) { // 容量
                if (j - weight[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - weight[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j]; // 前i个
                }
            }
        }
        return dp[n][w];
    }

    private int backpack2(int n, int w, int[] val, int[] weight) {
        int size = weight.length;
        // 表示容量为 j 时， 前 i 个物品可以装的最大价值
        int[] dp = new int[w + 1];

        //
        // dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + value[i - 1]])
         //  观察dp 数组 可以消掉 i-1
         // dp[j] = max(dp[j], dp[j - w[i - 1]]  + value[i - 1]])
         // 可以看出 dp[j] 由上一步的dp[j]推到出的
        // i =2
        for (int i = 1; i <= size; i++) { // 物品
            for (int j = w; j >= 0; j--) { // 容量
                if (j - weight[i - 1] >=0) {
                    dp[j] = Math.max(dp[j],
                            dp[j - weight[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[w];
    }

    private int backpack3(int n, int w, int[] val, int[] weight) {
        int size = weight.length;
        // 表示容量为 j 时， 前 i 个物品可以装的最大价值
        int[] dp = new int[w + 1];

        //
        // dp 4
         //      w[i - 1]  val[i -1]  dp[4]
        // i= 1，    1         15        dp[4] = max(dp[4], dp[4 - 1] + val[0]) = 15
        // i= 2      2        20        dp[4] = max(dp[4], dp[4 - 2] + val[1])  = 20
        // i= 3     3        35         dp[4]                                   = 35

         // dp[2] = max(dp[2], dp[2-])


        for (int j = w; j >= 0; j--) { // 容量
            for (int i = 1; i <= size; i++) { // 物品
                if (j - weight[i - 1] >=0) {
                    dp[j] = Math.max(dp[j],
                            dp[j - weight[i - 1]] + val[i - 1]);
                }
                 DpUtils.dump(dp);

            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 4;
        int[] val = {15, 20, 35};
        int[] weight = {1, 2, 3};

        System.out.println(new BackTackCopy().backpack(n, w, val, weight));

        System.out.println(new BackTackCopy().backpack2(n, w, val, weight));

        System.out.println(new BackTackCopy().backpack3(n, w, val, weight));
    }


}
