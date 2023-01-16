package Graph;

public class NoOfIslands {
        // Function to find the number of islands.
        public int numIslands(char[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int count=0;

            for(int i =0;i<grid.length;i++){
                for(int j =0;j<grid[0].length;j++){

                    if(!visited[i][j] && grid[i][j] ==1){
                        dfsutil(visited, grid, i , j, grid.length,grid[0].length);
                        count++;
                    }
                }
            }


            return count;

        }

        private static void dfsutil(boolean[][] visited,char[][] grid, int i , int j, int n , int m){

            if(i<0 || i>=n || j<0 || j>=m|| visited[i][j]==true || grid[i][j]==0 ){
                return;
            }

            visited[i][j] = true;

            dfsutil(visited, grid,i-1,j-1, n,m);
            dfsutil(visited, grid,i-1,j+1, n,m);
            dfsutil(visited, grid,i-1,j, n,m);
            dfsutil(visited, grid,i+1,j-1, n,m);
            dfsutil(visited, grid,i+1,j+1, n,m);
            dfsutil(visited, grid,i+1,j, n,m);
            dfsutil(visited, grid,i,j-1, n,m);
            dfsutil(visited, grid,i,j+1, n,m);
        }

        public static void main(String[] args){
            char[][] grid = new char[][]{{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}};
            NoOfIslands n=new NoOfIslands();
            System.out.print(n.numIslands(grid));
        }

    }
