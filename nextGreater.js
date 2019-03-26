Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1 

Input:
The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. Each test case consists of two lines. The first line contains an integer N denoting the size of the array. The Second line of each test case contains N space separated positive integers denoting the values/elements in the array A.

Output:
For each test case, print in a new line, the next greater element for each array element separated by space in order.

https://practice.geeksforgeeks.org/problems/next-larger-element/0


/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    public static int[] nextGreater(int arr[]){
        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(i==arr.length-1){
                res[i]=-1;
                st.push(arr[i]);
            }else{
                while(!st.isEmpty() && arr[i]>st.peek()){
                    st.pop();
                }
                
                if(!st.isEmpty())
                    res[i]=st.peek();
                else
                    res[i]=-1;
                st.push(arr[i]);
            }
        }
        
        return res;
    }
	public static void main (String[] args) {
	    int arr[]={11, 13, 21, 3};
	    int res[] =nextGreater(arr);
	    for(Integer i: res)
		    System.out.print(i+" ");
	}
}
