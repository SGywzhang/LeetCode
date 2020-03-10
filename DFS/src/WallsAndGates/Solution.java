package WallsAndGates;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0){
            return;
        }

        for(int i = 0; i< rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0) {
                    fill(rooms, i, j, 0);
                }
            }
        }
    }

    void fill(int[][] rooms, int i, int j, int val){

        if(i < 0 || i >= rooms.length ||
           j < 0 || j >= rooms[0].length || rooms[i][j] < val) return;

        rooms[i][j] = val;

        fill(rooms, i + 1, j, val + 1);
        fill(rooms, i - 1, j, val + 1);
        fill(rooms, i, j + 1, val + 1);
        fill(rooms, i , j - 1, val + 1);
    }
}
