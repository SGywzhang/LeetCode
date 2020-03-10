package ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        System.out.println(shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}}));
    }

    public static int shortestDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];
        int res = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    bfs(grid, distance, reach, i, j);
                    count++;
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(reach[i][j] == count){
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res;
    }

    static void bfs(int[][] grid, int[][] distance, int[][] reach, int i , int j){

        int[] dx = {1 , -1, 0 , 0};
        int[] dy = {0 , 0, 1, -1};

        Queue<int[]> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.offer(new int[]{i, j});
        q2.offer(1);

        while(!q1.isEmpty()){
            int[] dir = q1.poll();
            int dis = q2.poll();

            for(int k = 0; k < 4; k++){
                int x = dir[0] + dx[k];
                int y = dir[1] + dy[k];

                if(x >= 0 && x < grid.length && y >= 0 && y <grid[0].length && grid[x][y] == 0){
                    grid[x][y] = -1;
                    q1.offer(new int[]{x, y});
                    q2.offer(dis + 1);
                    distance[x][y] += dis;
                    reach[x][y]++;
                }
            }
        }
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == -1) {
                    grid[m][n] = 0;
                }
            }
        }

    }
}
