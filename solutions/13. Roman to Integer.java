class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('M',1000);
        hm.put('D', 500);
        hm.put('C',100);
        hm.put('L',50);
        hm.put('X',10);
        hm.put('V',5);
        hm.put('I',1);
       
        int sum=0;
        for(int i=0; i<s.length(); i++)
        {
           if(i <s.length()-1 && hm.get(s.charAt(i)) < hm.get(s.charAt(i+1)) )
           {
               sum = sum-hm.get(s.charAt(i));
           }
           else
           {
               sum = sum + hm.get(s.charAt(i));
           }
        }
        return sum;
    }
}
