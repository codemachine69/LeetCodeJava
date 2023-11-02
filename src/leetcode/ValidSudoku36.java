package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] squares = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int squareNum = i / 3 * 3 + j / 3;
                    if (rows[i][num] == 1 || cols[j][num] == 1 || squares[squareNum][num] == 1) return false;
                    rows[i][num] = cols[j][num] = squares[squareNum][num] = 1;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku_neetcode(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Pair, HashSet<Character>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (rows.get(i) == null) rows.put(i, new HashSet<>());
                if (cols.get(j) == null) cols.put(j, new HashSet<>());
                squares.computeIfAbsent(new Pair(i / 3, j / 3), k -> new HashSet<>());
                if (rows.get(i).contains(board[i][j]) || cols.get(j).contains(board[i][j]) || squares.get(new Pair(i / 3, j / 3)).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(new Pair(i / 3, j / 3)).add(board[i][j]);
            }
        }

        return true;
    }

    public boolean isValidSudoku_stringhashing(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if (!hs.add(s + i) || !hs.add(s + j) || !hs.add(i / 3 + s + j / 3)) return false;

                }
            }
        }
        return true;
    }
}

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        Pair p = (Pair) obj;
        return p.first == this.first && p.second == this.second;
    }
}
