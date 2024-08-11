class Solution {
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int cnt = countislands(grid);
        if(cnt!=1){
            return 0;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    continue;
                }
                grid[i][j] = 0;
                int newcnt = countislands(grid);
                if(newcnt!=1){
                    return 1;
                }
                grid[i][j] = 1;
            }
        }
        return 2;
    }
    static int countislands(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int cnt = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    bfs(grid,i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void bfs(int[][] grid,int row,int col,boolean[][] visited){
        visited[row][col] = true;
        if(isvalid(grid,row,col+1,visited)){
            bfs(grid,row,col+1,visited);
        }
        if(isvalid(grid,row,col-1,visited)){
            bfs(grid,row,col-1,visited);
        }
        if(isvalid(grid,row+1,col,visited)){
            bfs(grid,row+1,col,visited);
        }
        if(isvalid(grid,row-1,col,visited)){
            bfs(grid,row-1,col,visited);
        }
    }
    static boolean isvalid(int[][] grid,int row,int col,boolean[][] visited){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1 && !visited[row][col]){
            return true;
        }
        return false;
    }
}