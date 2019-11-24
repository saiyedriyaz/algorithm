package net.demo.challanges;

// Leetcode: Walls and Gates
public class WallsAndGatesDFS {
    public static void main(String[] args) {
        int[][] rooms = new int[][]{
                {99, -1, 0, 99},
                {99, 99, 99, -1},
                {99, -1, 99, -1},
                {0, -1, 99, 99}
        };
        print(rooms);
        System.err.println("--------");
        new WallsAndGatesDFS().wallsAndGates(rooms);
        print(rooms);
    }

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    updateDistance(i, j, 0, rooms);
                }
            }
        }
    }

    private void updateDistance(int row, int column, int distance, int[][] rooms) {
        if (row < 0 || column < 0 || row >= rooms.length || column >= rooms.length || distance > rooms[row][column]) {
            return;
        }
        rooms[row][column] = distance;
        updateDistance(row, column - 1, distance + 1, rooms); // left
        updateDistance(row, column + 1, distance + 1, rooms); // right
        updateDistance(row - 1, column, distance + 1, rooms); // above
        updateDistance(row + 1, column, distance + 1, rooms); // below
    }

    private static void print(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.err.print(rooms[i][j] + " ");
            }
            System.err.println();
        }
    }
}
