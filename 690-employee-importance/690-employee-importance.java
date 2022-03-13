/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};   
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
       HashMap<Integer, Employee> hm = new HashMap<>();
        for(int i=0; i<employees.size(); i++)
        {
            hm.put(employees.get(i).id, employees.get(i));
        }
        int[] res = new int[1];
        HashSet<Integer> visited = new HashSet<>();
        util(id, hm, res, visited);
        return res[0];
    }
    
    public void util(int id,HashMap<Integer,Employee> hm,int[] res, HashSet<Integer> visited)
    {
        if(visited.contains(id))
            return;
        
        res[0] += hm.get(id).importance;
        visited.add(id);
        
        for(int i=0; i< hm.get(id).subordinates.size(); i++)
        { 
            int e =  hm.get(id).subordinates.get(i);
            util(e, hm, res, visited);
        }
    }
}