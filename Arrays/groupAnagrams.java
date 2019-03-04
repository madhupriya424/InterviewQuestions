Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
-----------------------------------------------------------------------------------------------------------------------------

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        char arr[];
        
        List<List<String>> li = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        for(String s: strs){
            arr = s.toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);
            if(!hm.containsKey(st)) {
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                hm.put(st, al);
            }else{
                ArrayList<String> al = hm.get(st);
                al.add(s);
            }  
        }
        
        for(Map.Entry<String, ArrayList<String>> s: hm.entrySet()){
            li.add(s.getValue());
        }
            
        return li; 
    }
}
