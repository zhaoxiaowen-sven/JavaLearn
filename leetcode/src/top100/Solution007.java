package top100;

public class Solution007 {

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0;
        while (left < right) {
            // right - left 距离
            int curArea = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(curArea, max);
            // 选取高度较高ode
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // 暴力解法
    public int maxArea2(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int high = Math.min(height[i], height[j]);
                int w = j - i;
                if (w * high > max) {
                    max = w * high;
                }
            }
        }
        return max;
    }

    public void test() {
        int[] num = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(num));
        System.out.println(1/ 10);
    }
}
