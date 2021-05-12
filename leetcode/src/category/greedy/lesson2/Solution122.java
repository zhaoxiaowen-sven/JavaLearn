package category.greedy.lesson2;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        for (int i = 1; i< n ;i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution122().maxProfit(new int[]{7,1,5,3,6,4});
    }
}
