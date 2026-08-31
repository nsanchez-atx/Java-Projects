// Finds how many standalone islands there are using recursion. 1 is land, and 0 is water.

public class islandFinder {

    public static void main(String[] args)
    {
        int[][] map = generate(10, 10);
        System.out.println(island(map));
    }
    public static int island(int[][] map)
    {
       int island = 0;
       for(int col = 0; col < map.length; col++ )
       {
           for(int row = 0; row <map[col].length; row++)
           {
               if(map[row][col] == 1)
               {
                   island++;
                   map = check(row, col, map);
               }
           }
       }
       return island;
    }
    public static int[][] check(int row, int col, int[][] map)
    {
        map[row][col] = 0;
        for(int i = row -1; i <= row+1;i++)
        {
            if(i >= 0 && i < map.length)
            {
                for (int j = col-1; j <= col+1; j++)
                {
                    if(j >= 0 && j < map[i].length)
                    {
                        if(map[i][j] == 1)
                        {
                            check(i, j, map);
                        }
                    }
                }
            }  
        }
        return map;
    }
    public static int[][] generate(int row, int col)
    {
        int[][] arr = new int[row][col];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j <arr[i].length; j++)
            {
                arr[i][j] = (int)(Math.random() * 2); 
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
        return arr;
    }
}
