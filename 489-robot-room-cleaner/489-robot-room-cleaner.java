/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[][] dirArr = new int[][] { {-1,0} , {0, 1} , { 1,0} , {0,-1}};
    public void cleanRoom(Robot robot) {
        HashSet<String> hs = new HashSet<>();
    
        dfs(robot, 0, 0 , 0, hs);
    }
    
    public void dfs(Robot robot, int r, int c, int dir, HashSet<String> hs)
    {
       if(hs.contains(r+"@"+c))
           return;
        
           hs.add(r+"@"+c);
           robot.clean();
        
        for(int i=0; i<4; i++)
        {
            int nr = r +dirArr[(dir+i)%4][0];
            int nc = c + dirArr[(dir+i)%4][1];
            
            if(!hs.contains(nr+"@"+nc) && robot.move())
            {
                dfs(robot, nr, nc, (dir+i)%4, hs);
            }
            robot.turnRight();         
        }
        
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}