class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> edges = new HashMap<>();
        HashSet<String> res = new HashSet<>();
        HashMap<String,Integer> visited = new HashMap<>();
        HashSet<String> hsSup = new HashSet<>();
        
        for(String sup : supplies )
        {
            hsSup.add(sup);
        }
        
        for(int i=0; i<recipes.length; i++)
        {
            String item = recipes[i];
            edges.put(item, new ArrayList<>());
            for(String s : ingredients.get(i))
            {
                edges.get(item).add(s);
            }
        }
        
        for(String item : recipes)
        {
           if(visited.getOrDefault(item,0) == 2 || dfs(item, edges, hsSup, visited))
           {
               res.add(item);
           }   
        }
        
        return new ArrayList<>(res);
    }
    
    public boolean dfs(String item, HashMap<String, List<String>> edges, HashSet<String> hsSup,  HashMap<String,Integer> visited)
    {
        if(visited.getOrDefault(item,0) == 1)
        {
            return false;
        }
        
        visited.put(item, 1);
        for(String dep : edges.get(item))
        {
            if(hsSup.contains(dep))
            {
               continue;
            }
            else if(edges.containsKey(dep) && dfs(dep, edges, hsSup, visited))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        visited.put(item,2);
        hsSup.add(item);
        return true;
    }
}