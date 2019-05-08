/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;


class GFG {
    static String trimZero(StringBuilder str){
        int i=0;
          while(i<str.length()){
              if(str.charAt(i)=='0')
                 str.deleteCharAt(i);
              else 
                 break;
          }
          
          if(str.length()==0)
            return "0";
        
          return str.toString();    
    }
    
    static String importMessag(String A){
        String str[] = A.trim().split("\\D+");  
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0;i<str.length;i++){   System.out.println("aaa :"+str[i]);
            if(!str[i].equals("")){
            String st = trimZero(new StringBuilder(str[i]));
            BigInteger big = new BigInteger(st);
            //Long num = Long.parseLong(st);
          // BigInteger modd = BigInteger.valueOf(26);//System.out.println("aaa :"+BigInteger.intValue(big.mod(modd)));
            sb.append((char)(big.mod(new BigInteger("26")).add(new BigInteger("97"))).intValue());
            }
        }
        
        return sb.toString();
    }
    
    
	public static void main (String[] args) {
		System.out.println(importMessag("i45love14you690"));
	}
}

// i45love14you690  too
// 028     c
// 0000000    a
// utkarsh028   c
