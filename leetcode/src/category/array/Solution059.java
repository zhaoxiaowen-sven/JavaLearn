package category.array;

import java.util.HashMap;

public class Solution059 {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0;
        int mid = n / 2;
        int[][] arr = new int[n][n];
        int loop = n / 2;
        int count = 1;
        int offset = 1;

        /**
         *  (0,0) (0,1) (0,2)
         *  (1,0) (1,1) (1,2)
         *  (2,0) (2,1) (2,2)
         *
         *  (0,0) (0,1) (0,2)（0,3）
         *  (1,0) (1,1) (1,2)（1,3）
         *  (2,0) (2,1) (2,2)（2,3）
         *  (3,0) (3,1) (3,2)（3,3）
         *  // 前闭后开
         */

        while (loop-- > 0) {
            int i = startX;
            int j = startY;

            // [ )
            // 上行左到右, i 保持不变
            while (j < n - offset + startY) { // + startY 从startY开始的
                arr[startX][j] = count++;
                j++;
            }

            // 右列 上到下 j保持不变
            while (i < n - offset + startX) {
                arr[i][j] = count++;
                i++;
            }

            // 下行 右到左
            while (j > startY) {
                arr[i][j] = count++;
                j--;
            }
            // 左列 下到上
            while (i > startX) {
                arr[i][j] = count++;
                i--;
            }

            startX++;
            startY++;

            offset += 2;
        }

        if (n % 2 == 1) {
            arr[mid][mid] = count;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new Solution059().generateMatrix(3);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        System.out.println(map.get(0));
//        new Solution059().generateMatrix(5);
    }
}
