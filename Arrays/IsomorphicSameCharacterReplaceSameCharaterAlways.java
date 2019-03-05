205. Isomorphic Strings
Easy

663

183

Favorite

Share
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.

----------------------------------------------------------------------------------------------------------------------------------

Method 1:
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), t.charAt(i));
            }else{
                char ch = hm.get(s.charAt(i));
                if(ch!=t.charAt(i))
                    return false;
            }
        }
        
        hm = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!hm.containsKey(t.charAt(i))){
                hm.put(t.charAt(i), s.charAt(i));
            }else{
                char ch = hm.get(t.charAt(i));
                if(ch!=s.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
===================================================================================================================================

Method 2:

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Character> h = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0; i<s.length(); i++){
            if(h.containsKey(s.charAt(i))){
                if(h.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            else{
                if(set.contains(t.charAt(i)))
                    return false;
                h.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}

==================================================================================================================================

Method 3:

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashMap<Character, Character> hm1 = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(hm1.containsKey(t.charAt(i)) && hm1.get(t.charAt(i))!=s.charAt(i))
                return false;
            else if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), t.charAt(i));
                hm1.put(t.charAt(i), s.charAt(i));
            }
            else{
                char ch = hm.get(s.charAt(i));
                if(ch!=t.charAt(i))
                    return false;
            }
        } 
        return true;
    }
}
