package category.dp.backpack;

public class Solution {

    private int backpack(int n, int w, int[] val, int[] weight) {
        // dp[i][w] , 重量为w的i件物品的最大价值
        int[][] dp = new int[n + 1][w + 1];

        // dp[i][j] = Math.max(dp[i - 1, j], dp[i - 1] [w - weight[i] + value[i]])
        // 数组的索引从0开始，遍历从1开始，所以，递推公式中，所有的 取数组元素的i
        // weight[i] 以及  value[i], 都要减1，相当于 数组向前移动一位
        // dp[i][j] = Math.max(dp[i - 1, j], dp[i - 1] [w - weight[i - i] + value[i - 1]])


        // 关于二维数组的长度说明
        // w 必须选是数组宽度 而且w >= weight[] 中的任意一个元素
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j - weight[i - 1] < 0) { // 注意之类取的是 当前背包大小是j
                    dp[i][j] = dp[i - 1][j];//
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j], //
                            val[i - 1] + dp[i - 1][w - weight[i - 1]]//
                    );
                }
            }
        }
        dumpDp(dp);
        return dp[n][w];
    }


    // n 是要选取的物品的个数， w是限制的是物品的总重量
    private int backpack2(int n, int w, int[] value, int[] weight) {
        // dp[i][j] , 重量为j的i件物品的最大价值
        int nums = weight.length;
        int[][] dp = new int[nums + 1][w + 1];

        // 初始化 dp[i][0], i是物品的数量，应该 == val.length == weight
        // 当重量为 0 时， dp[i][0]的值，能放大最大价值
        for (int i = 0; i < nums; i++) {
            dp[i][0] = 0;
        }
        // 初始化d[0][j],
        // 放入【物品0】时， dp[0][j]的值，最大价值，注意【物品0】 不能重复放
        for (int j = w; j >= weight[0]; j--) {
            // 递归公式
            // dp[i][j] = Math.max(dp[i - 1, j], dp[i - 1] [w - weight[i] + value[i]])
            // i = 0 , i -1 怎么理解？
            // 只放入【物品0】时，value的最大值
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        // 先遍历物品个数， 物品个数从1开始
        // 物品的个数和weight数组长度是一样的，索引范围[0, nums- 1]
        for (int i = 1; i < nums; i++) {
            // 物品的重量
            for (int j = 0; j <= w; j++) {
                if (j - weight[i] < 0) { // weight[i] 当前物品的重量
                    dp[i][j] = dp[i - 1][j];//
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j], //
                            value[i] + dp[i - 1][w - weight[i]]//
                    );
                }
            }
        }

//        // 先遍历物品个数
//        for (int j = 0; j <= w; j++) {
//            //物品个数从1开始
//            for (int i = 1; i <= nums; i++) {
//                if (j - weight[i]  < 0) {
//                    dp[i][j] = dp[i - 1][j];//
//                } else {
//                    dp[i][j] = Math.max(
//                            dp[i - 1][j], //
//                            value[i] + dp[i - 1][w - weight[i]]//
//                    );
//                }
//            }
//        }
        dumpDp(dp);

        return dp[n - 1][w];
    }

    private void dumpDp(int[][] dp) {
        StringBuilder builder = new StringBuilder();
        for (int[] arr : dp) {
            for (int i : arr) {
                builder.append(i).append(",");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }


    private int backpack3(int n, int w, int[] value, int[] weight) {
        // 容量为j的背包的最大价值
        int[] dp = new int[w + 1];
        //dp[j] = max(dp[j], dp[j-weight[i] + value[i]])
                    //容量的范围 j
                    // 4       3       2       1       0                j - weight[i] 的范围
        // 物品                                         物品重量weight[i]
        // 放物品1 的时候，j最大价值都是15，除了j=0，因为没有容量
        //  0        15       15     15      15       0      1          3   1   1   0   -1
        // 放完1后就开始比较了，上次放的容量d[i] 和 将要放入的容量，dp[j - weight[i]] + value[i] 的大小
        // 比如 新dp4 满足 4 > weight[1](3) dp 4 = max (dp[4](15), dp[j - weight[i] (剩余容量的最大值)] == dp[1] + value[1]) ==20);
        // 同理可知dp[3] = max(dp[3] , dp[3-3] + 20) = 20
        // 接下来的 j = 2 < (weight[1] =3),所以后面的都放不了了
        //  1        35      20     15     15        0        3          1   0   -1  -2  -3
        // 再走下一轮 只有j= 4满足条件 4 >= weight[2]
        //  2        35     20     15     15       0          4         0    -1  -2  -3   -4

        int nums = weight.length;
        for (int i = 0; i < nums; i++) {//for 循环表达的意思是放 n 件物品，背包的最大价值
            for (int j = w; j >= weight[i]; j--) { // dp[4] 不能累计到dp[3]
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                dump(dp);
            }
            dump(dp);
        }


        return dp[w];
    }
    private void dump(int[] dp) {
        StringBuilder builder = new StringBuilder();
        for (int i :dp) {
            builder.append(i).append(",");
        }
        builder.append("\n");

        System.out.println(builder.toString());
    }
    public static void main(String[] args) {
        int n = 3;
        int w = 4;
        int[] val = {15, 20, 35};
        int[] weight = {1, 3, 4};
//        System.out.println(new Solution().backpack(3, w, val, weight));
//
//        System.out.println(new Solution().backpack2(3, w, val, weight));

        System.out.println(new Solution().backpack3(3, w, val, weight));
    }
}
