class Solution {
    public int brokenCalc(int startValue, int target) {
        int steps = 0;
        while(target > startValue)
        {
            target = (target%2 == 0) ? target/2 : target+1;
            steps++;
        }
        steps += (startValue-target);
        return steps;
    }
}