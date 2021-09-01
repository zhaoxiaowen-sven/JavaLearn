package sort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class QuickSort2 {

    public static void main(String[] args) {
//        int[] arr = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
//        int[] arr = new int[]{60, 26, 54,77,55,93};
//        int[] arr = new int[]{5, 0, 3, -1,1};

//        new QuickSort2().quickSort(arr, 0 , arr.length - 1);
//        SortHelper.dump(arr);
//        int[] arr = new int[]{3, 2, 1,};
//        canJump(arr);
//        int[][] arr = new int[][]{
//                {1,2,3,4},{5,6,7,8},{9,10,11,12},
//                {13,14,15,16}};
//        rotate(arr);
//        int[] arr = new int[]{0,1,0,2};
//        trap(arr);

        int[] nums = new int[]{3,2,1,1,4};
        findDisappearedNumbers(nums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        int end = nums.length;

        while (index < end) {
            if(nums[index] == index + 1) {
                index ++;
            } else {
                // 数字的值减1 就是索引的下标
                int targetIndex = nums[index] - 1;
                // 重复了
                if (nums[targetIndex] == nums[index]) {
                    index ++;
                    continue;
                }

                // 交换
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[index];
                nums[index] = temp;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < end; i++) {
            if(nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }


    public static void rotate(int[][] matrix) {
        int start = 0;
        int n = matrix.length - 1;
        int gap = n;
//        while (gap > 0) {
        // gap = 2
        int j = 0;
//            for (int j = start; j< start + gap; j++) {
        int temp = matrix[start][start];
        matrix[start][start] = matrix[start + gap][start];

        // z左下角
        matrix[start + gap][start] = matrix[start + gap][start + gap];
        // 右下角
        matrix[start + gap][start + gap] = matrix[start][start + gap];
        // 右上角
        matrix[start][start + gap] = temp;
//            }
//            start += 1;
//            gap -= 2;
//        }
        System.out.println(matrix);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            //
            max = Math.max(max, nums[i] + i);
            if(max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partion = partition(nums, low, high);
            quickSort(nums, low, partion - 1);
            quickSort(nums, partion + 1, high);
        }
    }

    private int partion(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        while (low < high) {
            while (low < high && nums[low] >= pivot) {
                low ++;
            }
            nums[high] = nums[low];
            while (low < high && nums[high] <= pivot) {
                high --;
            }
            nums[low] = nums[high];
        }
        nums[high] = pivot;
        return low;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int index = partition(nums, 0, nums.length - 1);
        while (index != k - 1) {
            if(index < k - 1){
                index = partition(nums, index + 1, nums.length- 1);
            } else if (index > k - 1) {
                index = partition(nums, 0, index  -1);
            }
        }
        return nums[index];
    }

    public static int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int ans = 0;
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        for (int i = 1; i< height.length;i++) {
            if (height[st.peek()] >= height[i]) {
                st.push(i);
            } else {
                while (!st.isEmpty() && height[st.peek()] < height[i]) {
                    int mid = st.pop();
                    if (!st.isEmpty()) {
                        int left = st.peek();
                        int h1 = Math.min(height[i], height[left]) - height[mid];
                        ans += h1 * (i - left - 1);
                    }
                }
                st.push(i);
            }
        }
        return ans;
    }
}
