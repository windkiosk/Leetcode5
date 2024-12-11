package leetcode_problems;

public class P289_GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] % 10 == 0) {
                    if (checkDeadCell(x, y, board)) {
                        board[y][x] = board[y][x] + 10;
                    }
                } else {
                    if (checkAliveCell(x, y, board)) {
                        board[y][x] = board[y][x] + 10;
                    }
                }
            }
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == 10) {
                    board[y][x] = 1;
                }
                if (board[y][x] == 11) {
                    board[y][x] = 0;
                }
            }
        }
    }

    boolean checkAliveCell(int x, int y, int[][] board) {
        int c = 0;

        // left top
        if (isAlive(x - 1, y - 1, board)) {
            c++;
        }
        // top
        if (isAlive(x, y - 1, board)) {
            c++;
        }
        // right top
        if (isAlive(x + 1, y - 1, board)) {
            c++;
        }
        // right
        if (isAlive(x + 1, y, board)) {
            c++;
        }
        // right bottom
        if (isAlive(x + 1, y + 1, board)) {
            c++;
        }
        // bottom
        if (isAlive(x, y + 1, board)) {
            c++;
        }
        // left bottom
        if (isAlive(x - 1, y + 1, board)) {
            c++;
        }
        // left
        if (isAlive(x - 1, y, board)) {
            c++;
        }

        if (c < 2) {
            return true;
        } else if (c > 3) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkDeadCell(int x, int y, int[][] board) {
        int c = 0;

        // left top
        if (isAlive(x - 1, y - 1, board)) {
            c++;
        }
        // top
        if (isAlive(x, y - 1, board)) {
            c++;
        }
        // right top
        if (isAlive(x + 1, y - 1, board)) {
            c++;
        }
        // right
        if (isAlive(x + 1, y, board)) {
            c++;
        }
        // right bottom
        if (isAlive(x + 1, y + 1, board)) {
            c++;
        }
        // bottom
        if (isAlive(x, y + 1, board)) {
            c++;
        }
        // left bottom
        if (isAlive(x - 1, y + 1, board)) {
            c++;
        }
        // left
        if (isAlive(x - 1, y, board)) {
            c++;
        }
        return c == 3;
    }

    boolean isAlive(int x, int y, int[][] board) {
        if (isLegal(x, y, board)) {
            if (board[y][x] % 10 == 1) {
                return true;
            }
        }
        return false;
    }

    boolean isLegal(int x, int y, int[][] board) {
        if (x < 0 || y < 0 || x >= board[0].length || y >= board.length) return false;
        return true;
    }
}
