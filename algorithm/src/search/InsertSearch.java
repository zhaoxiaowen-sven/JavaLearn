package search;

public class InsertSearch {
    public static int search(int[] sortedList, int key) {
        int find = -1;
        int low = 0;
        int high = sortedList.length - 1;
        while (low < high) {
            int mid = low + (high - low) * (key - sortedList[low]) / (sortedList[high] - sortedList[low]);
            if (key < sortedList[mid]) {
                high = mid - 1;
            } else if (key > sortedList[mid]) {
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
