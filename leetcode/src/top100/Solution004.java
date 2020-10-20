package top100;

public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1 != null ? nums1.length : 0;
        int len2 = nums2 != null ? nums2.length : 0;
        int len = len1 + len2;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merge = new int[len];
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }

        while (i < len1 && k < len) {
            merge[k++] = nums1[i++];
        }

        while (j < len2 && k < len) {
            merge[k++] = nums2[j++];
        }

        // 偶数
        if (k % 2 == 0) {
            return (merge[k / 2 - 1] + merge[k / 2]) / 2.0d;
        } else {
            // 奇数
            return merge[k / 2];
        }
    }

    public void test() {
        int[] num1 = {1, 3};
        int[] num2 = {2, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
