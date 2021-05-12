package category.backtracking.queen;

public class Solution037 {
    public void solveSudoku(char[][] board) {
        int n = board.length;

        dfs(board, n);
    }

    private boolean dfs(char[][] board, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                // 字符
                for (char c = '1'; c <= '9'; c++) {
                    if (!isValid(board, row, col, c, n)) { // (row, col) 这个位置放k是否合适
                        continue;
                    }
                    board[row][col] = c;
                    if (dfs(board, n)) { // 如果找到合适一组立刻返回
//                        System.out.println("true");
                        return true;
                    }
                    board[row][col] = '.';
                }
                return false; // 9个数都试完了，都不行，那么就返回false
            }
        }
        return true; // 遍历完没有返回false，说明找到了合适棋盘位置了
    }

    // 同行是否重复
    //同列是否重复
    //9宫格里是否重复
    private boolean isValid(char[][] board, int row, int col, char c, int n) {
        // 1、判断行
        for (int i = 0; i < n; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }
        // 2、判断列
        for (int j = 0; j < n; j++) {
            if (board[j][col] == c) {
                return false;
            }
        }

        // 3、判断同9宫格
        int beginX = getBeginIndex(row);
        int endX = getEndIndex(row);

        int beginY = getBeginIndex(col);
        int endY = getEndIndex(col);

        for (int i = beginX; i < endX; i++) {
            for (int j = beginY; j < endY; j++) {
                if (i == row || j == col) {
                    continue;
                }
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getBeginIndex(int row) {
        int beginX;
        if (row < 3) {
            beginX = 0;
        } else if (row < 6) {
            beginX = 3;
        } else {
            beginX = 6;
        }
        return beginX;
    }

    private int getEndIndex(int index) {
        int end;
        if (index < 3) {
            end = 3;
        } else if (index < 6) {
            end = 6;
        } else {
            end = 9;
        }
        return end;
    }
}
