package Graph;

public class IsPathExist {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3},{3,2}};
        Solution n = new Solution();
        System.out.print(n.is_Possible(grid));
    }

}
 class Solution{
    int sourcei=-1;
    int sourcej=-1;
    int destinationi=-1;
    int destinationj=-1;
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        boolean[][] vis=new boolean[grid.length][grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    sourcei=i;
                    sourcej=j;
                }
                if(grid[i][j]==2){
                    destinationi=i;
                    destinationj=j;
                }

            }
        }
        return isPathPossible(grid,grid.length,grid[0].length,sourcei,sourcej,vis);
    }

    public boolean isPathPossible(int[][] grid,int n,int m,int i,int j,boolean[][] vis)
    {
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0 || vis[i][j]==true)
            return false;
        if(grid[i][j]==2) return true;
        else{
            vis[i][j]=true;
            return isPathPossible(grid,n,m,i-1, j,vis) || isPathPossible(grid,n,m,i+1, j,vis) ||   isPathPossible(grid,n,m,i, j-1,vis)
                    || isPathPossible(grid,n,m,i, j+1,vis);
        }


    }
}

