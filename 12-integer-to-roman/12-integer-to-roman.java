class Solution {
    public String intToRoman(int num) {
        int[] vals = new int[]      { 1000, 900,  500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[] { "M", "CM" , "D","CD", "C","XC","L","XL","X", "IX", "V","IV","I"};
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(num > 0 && i<13)
        {
            while(vals[i] <= num)
            {
                sb.append(strs[i]);
                num = num -vals[i];
            }
            i++;
        }
        return sb.toString();
    }
}