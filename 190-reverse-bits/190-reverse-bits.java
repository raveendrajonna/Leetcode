public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        int i=0;
        while(i<32)
        {
           res = res + (n & 1);
           n = n >> 1;
           if (i < 31) // CATCH: for last digit, don't shift!
            res = res << 1;

           i++;
        }
        return res;
    }
}