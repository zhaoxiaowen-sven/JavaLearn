package hot100;

public class Solution033 {

    public int search2(int[] nums, int target) {
        // 数组从任意位置劈开后，至少有一半是有序的，什么意思呢？
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // nums[start] <= nums[mid]
            //
//            if (nums[mid] > nums[start]) {
             // [3, 1]
            if (nums[start] <= nums[mid]) { //左半段有序, mid > start [ ]
                if (target < nums[mid] && target >= nums[start]) { // 要再次判断target 在这个范围内 [ )
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {// mid <= end ( ]
                if (target > nums[mid] && target <= nums[end]) {// 右半段有序, ( ]
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        // 1. 第一步先找到k
        int k = nums.length - 1;
        while (k > 0 && nums[k - 1] <= nums[k]) {
            k--;
        }
        if (k == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        // 2.分段二分查找
        int ans = binarySearch(nums, 0, k - 1, target);
        if (ans != -1) {
            return ans;
        } else {
            ans = binarySearch(nums, k, nums.length - 1, target);
            return ans;
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{3, 1};
        System.out.println(new Solution033().search2(nums, 1));
//        System.out.println(new Solution033().search2(nums, 9));
//        System.out.println(new Solution033().search2(nums, 0));
    }
}
