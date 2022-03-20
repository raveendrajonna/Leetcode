class Solution {
      
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        
        return helper(num);
    }
    
    public String helper(int num)
    {
        String res;
        if(num >= 1000000000)
        {
           res =  helper(num/1000000000)+" Billion "+ helper(num%1000000000);
        }
        else if(num >= 1000000)
        {
            res = helper(num/1000000)+" Million "+ helper(num%1000000);
        }
        else if( num >= 1000)
        {
            res = helper(num/1000)+" Thousand "+ helper(num%1000);
        }
        else if(num >= 100)
        {
            res = helper(num/100)+" Hundred "+helper(num%100);
        }
        else if(num >=20)
        {
            res = tens[num/10]+" "+ones[num%10];
        }
        else
        {
           res = ones[num];
        }
        return res.trim();
    }
}