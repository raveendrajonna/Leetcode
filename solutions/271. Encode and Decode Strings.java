public class Codec {
​
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
        for(String s : strs)
        {
            sb.append(s.length());
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }
​
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<s.length())
        {
            int slash = s.indexOf("/", i);
            int size = Integer.parseInt(s.substring(i,slash));
            i= slash+size+1;
            res.add(s.substring(slash+1,i));
        }
        return res;
    }
}
​
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
