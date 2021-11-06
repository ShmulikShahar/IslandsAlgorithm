package IslandsAlgorithm;

public class Islands {

	public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        
        String[] strIslands = new String[] {"XOXX", 
                                            "XOXO", 
                                            "OOXX"};
        
        int islands = CountIslands(strIslands);
        
        
        String strCountIslands = String.valueOf(islands);
        System.out.println("Number of Islands is: " + strCountIslands);
    }
    
    private static void SignIsland(boolean[][] belongsToIsland, String[] strArr, int row, int col)
    {
        int rowCount = strArr.length;
        int colCount = strArr[0].length();
        
        
        if(strArr[row].charAt(col) != 'X')
        {
            return;
        }
        else
        {
            belongsToIsland[row][col] = true;
            
            if(col<colCount-1)
            {
                SignIsland(belongsToIsland, strArr, row, col+1);
            }
            
            
            if(row<rowCount-1)
            {
                SignIsland(belongsToIsland, strArr, row+1, col);
                
                if(col>0)
                {
                    SignIsland(belongsToIsland, strArr, row+1, col-1);
                }
            
                if(col<colCount-1)
                {
                    SignIsland(belongsToIsland, strArr, row+1, col+1);
                }
            }
        }
    }
    
    private static int CountIslands(String[] strArr)
    {
        int counter = 0;
        int rowCount = strArr.length;
        int colCount = strArr[0].length();
        boolean[][] belongsToIsland = new boolean[rowCount][colCount];
         
        for(int i = 0; i < rowCount; i++)
        {
            for(int j = 0; j < colCount; j++)
            {
                  belongsToIsland[i][j] = false;
            }
        }
        
        for(int i = 0; i < rowCount; i++)
        {
              for(int j = 0; j < colCount; j++)
              {
                  if((strArr[i].charAt(j) == 'X') && belongsToIsland[i][j] == false)
                  {
                    counter++;
                    SignIsland(belongsToIsland, strArr, i, j);
                  }
              }
          }
          
          return counter;
    }
}
