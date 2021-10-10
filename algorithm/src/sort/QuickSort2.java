package sort;

import java.util.Deque;

public class QuickSort2 {

    public static void main(String[] args) {
//        int[] arr = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        int[] arr = new int[]{60, 26, 54,77,55,93};
//        int[] arr = new int[]{5, 0, 3, -1,1};
        new QuickSort2().quickSort(arr, 0 , arr.length - 1);
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
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

//    private int partition(int[] nums, int low, int high) {
//        int pivot = nums[high];
//        while (low < high) {
//            while (low < high && nums[low] >= pivot) {
//                low++;
//            }
//            nums[high] = nums[low];
//            while (low < high && nums[high] <= pivot) {
//                high--;
//            }
//            nums[low] = nums[high];
//        }
//        nums[high] = pivot;
//        return low;
//    }
}
