package NumberOfIslands;

import java.util.LinkedList;

//class Solution {
//    public int numIslands(char[][] grid) {
//        int res = 0;
//
//        LinkedList<int[]> queue = new LinkedList<>();
//
//        for(int i = 0; i < grid.length; i++){
//            for(int j = 0; j < grid[0].length; j++){
//                if(grid[i][j] == '1'){
//                    res++;
//                    dfs(grid,i,j);
//                }
//            }
//        }
//        return res;
//    }
//
//    public void dfs(char[][]grid,int x, int y){
//        if(x < 0 || x > grid.length - 1 ||
//                y < 0 || y > grid[0].length - 1 ||
//                grid[x][y] != '1'){
//            return;
//        }
//        grid[x][y] = '*';
//        dfs(grid, x, y - 1);
//        dfs(grid, x, y + 1);
//        dfs(grid, x - 1, y);
//        dfs(grid, x + 1, y);
//    }
//}

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        LinkedList<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    grid[i][j] = '*';
                    queue.offer(new int[]{i,j});
                    bfs(grid,queue);
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, LinkedList<int[]> queue){

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x < 0 || x > grid.length - 1 ||
                        y < 0 || y > grid[0].length - 1||
                        grid[x][y] != '1')
                    continue;

                grid[x][y] = '*';
                queue.offer(new int[]{x,y});
            }

        }
    }
}
