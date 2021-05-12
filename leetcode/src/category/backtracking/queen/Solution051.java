package category.backtracking.queen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        dfs(n, 0, chessboard, res);
        return res;
    }

    private void dfs(int n, int row, char[][] chessboard, List<List<String>> res) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        // col 代表列， row 代表行
        for (int col = 0; col < n; col++) {
            if (!isValid(chessboard, row, col, n)) {
                continue;
            }
            chessboard[row][col] = 'Q';
            dfs(n, row + 1, chessboard, res);
            chessboard[row][col] = '.';
        }
    }

    // 检查[row][col] 是否可以放置元素
    //      col
    // row  [0,0] [0,1] [0,2] [0,3]
    //      [1,0] [1,1] [1,2] [1,3]
    //      [2,0] [2,1] [2,2] [2,3]
    //      [3,0] [3,1] [3,2] [3,3]
    private boolean isValid(char[][] chessboard, int row, int col, int n) {
        // 检查上方
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
