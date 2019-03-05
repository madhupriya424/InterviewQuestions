451. Sort Characters By Frequency
Medium
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
------------------------------------------------------------------------------------------------------------------------
Sol:

class Solution {
    class Pair {
        char ch;
        int value;
        
        Pair(char ab, int bd){
            ch=ab;
            value=bd;
        }
        
        public String toString(){
            return this.ch+" "+this.value+" ";
        }
    }
    
    class SortByValue implements Comparator<Pair>{
            public int compare(Pair a, Pair b){
                return b.value - a.value;
            }
    }
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        ArrayList<Pair> al = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch, 1);
            }else{
                int n = hm.get(ch);
                hm.put(ch, n+1);
            }
        }
           
        for(Map.Entry<Character, Integer> m: hm.entrySet()){
            // System.out.println(m.getKey()+" "+m.getValue());
            al.add(new Pair(m.getKey(), m.getValue()));
        }       
             
        Collections.sort(al, new SortByValue());      
        System.out.println(al);
        
        StringBuilder str = new StringBuilder();
        for(int i=0;i<al.size();i++){
             for(int j=0;j<al.get(i).value;j++){
                str.append(al.get(i).ch);
        } 
        }
        
        return str.toString();
    }
}
