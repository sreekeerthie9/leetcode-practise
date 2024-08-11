class articulationpoint{
    boolean has;
    int time;
    articulationpoint(boolean has,int time){
        this.has = has;
        this.time = time;
    }
}
class Solution {
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int land = 0;
        int cnt = 0;
        articulationpoint art = new articulationpoint(false,0);
        int[][] dt = new int[rows][cols];
        int[][] lrt = new int[rows][cols];
        int[][] parent = new int[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(dt[i],-1);
            Arrays.fill(lrt[i],-1);
            Arrays.fill(parent[i],-1);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    land++;
                    if(dt[i][j]==-1){
                        findarticulation(grid,i,j,dt,lrt,parent,art);
                        cnt++;
                    }
                }
            }
        }
        if(cnt==0 || cnt>=2){
            return 0;
        }
        if(land==1){
            return 1;
        }
        if(art.has){
            return 1;
        }
        return 2;
    }

    static void findarticulation(int[][] grid,int row,int col,int[][] dt,int[][] lrt,int[][] parent,articulationpoint art){
        int rows = grid.length;
        int cols = grid[0].length;
        dt[row][col] = lrt[row][col] = art.time;
        art.time++;
        
        int child = 0;
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d : dir){
            int newrow = row+d[0];
            int newcol = col+d[1];
            if(isvalid(grid,newrow,newcol)){
                if(dt[newrow][newcol]==-1){
                    child++;
                    parent[newrow][newcol] = row*cols+col;
                    findarticulation(grid,newrow,newcol,dt,lrt,parent,art);
                    lrt[row][col] = Math.min(lrt[row][col],lrt[newrow][newcol]);
                    if(lrt[newrow][newcol]>dt[row][col] && parent[row][col]!=-1){
                        art.has = true;
                    }
                }
                else if(newrow*cols+newcol!=parent[row][col]){
                    lrt[row][col] = Math.min(lrt[row][col],lrt[newrow][newcol]);
                }
            }
        }
        if(parent[row][col]==-1 && child>1){
            art.has = true;
        }
    }
    
    
    static boolean isvalid(int[][] grid,int row,int col){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1){
            return true;
        }
        return false;
    }
}