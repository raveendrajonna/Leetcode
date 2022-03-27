class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<supplies.length; i++)
        {
            hs.add(supplies[i]);
        }
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<recipes.length; i++)
        {
            hm.put(recipes[i], ingredients.get(i));
        }
        
        HashMap<String,Integer> visited = new HashMap<>();
        
        List<String> res = new ArrayList<>();
        
        for(String key : hm.keySet())
        {
            if(!visited.containsKey(key))
               dfs(key, hm, visited, hs, res); 
        }
        return res;
        
    }
    
    public boolean dfs(String item, HashMap<String, List<String>> hm, HashMap<String,Integer> visited, HashSet<String> hs, List<String> res)
    {
        if(visited.getOrDefault(item,0) == 2)
            return  true ;
        
        if(visited.getOrDefault(item,0) == 1)
            return false;
        
        visited.put(item,1);
        if(!hm.containsKey(item) && !hs.contains(item))
            return false;
        
        for(String dep : hm.get(item))
        {
            boolean val =  (hs.contains(dep) || dfs(dep, hm, visited, hs, res));
            if(val == false)
                return false;
        }
        
        visited.put(item,2);
        hs.add(item);
        res.add(item);
        return true;
    }
}