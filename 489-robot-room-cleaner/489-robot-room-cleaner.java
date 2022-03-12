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
    int[] ra = new int[] {-1, 0,  1,  0};
    int[] ca = new int[] { 0, 1, 0, -1};
    public void cleanRoom(Robot robot) {
        HashSet<String> hs = new HashSet<>();
        clean(robot, 0, 0, 0, hs);
    }
    
    public void clean(Robot robot, int r, int c, int dir, HashSet<String> hs)
    {
        hs.add(r+"-"+c);
        //System.out.println(r+"-"+c +", dir :" + dir);
        robot.clean();

   for (int i = dir; i < dir + 4;  i++)
        {
            int nr = r+ra[i%4];
            int nc = c+ca[i%4];
            if(!hs.contains(nr+"-"+nc) && robot.move())
            {
                clean(robot, nr, nc, (i%4), hs);
            }
            robot.turnRight();
        }
        goBack(robot);
        
    }
    
    public void goBack(Robot robot)
    {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
        
    }
}