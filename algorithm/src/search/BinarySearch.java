package search;

public class BinarySearch {
    public static int search(int[] arr, int key) {
        int find = -1;
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                find = mid;
            }
        }
        if (find != -1) {
            System.out.println("find " + find);
        } else {
            System.out.println("not find " + find);
        }
        return find;
    }
}
