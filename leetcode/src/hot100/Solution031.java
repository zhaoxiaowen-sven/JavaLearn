package hot100;


public class Solution031 {
    public void nextPermutation(int[] nums) {
        // 1.从后向前找相邻逆序(前面小于后面)的排列的数，记录索引i
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 2.若上一步没找到，说明已经是最大的数了，要整体逆序
        if (i < 0) {
            reverse(nums, 0, nums.length);
            return;
        }

        // 3.找到后从[i, end]中，从后向前找第一个大于i的数
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i]) { // 注意：<=
            j--;
        }

        // 4.交换
        swapInt(nums, i, j);

        // 5.从[i, end) 进行逆序
        reverse(nums, i + 1, nums.length);
    }

    private void swapInt(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int length) {
        // [ ]
        int start = i;
        int end = length - 1;
        while (start <= end) {
            swapInt(nums, start, end);
            start++;
            end --;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new Solution031().nextPermutation(nums);
    }
}
