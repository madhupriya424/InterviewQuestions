Maximum of all subarrays of size k

Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum for every subarray of size k.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ K ≤ N
0 ≤ A[i] <= 107

Example:
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6

-----------------------------------------------------------------------------------------------------------------------------------

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static Deque<Integer> de;
    
    public static void maxOfAllSubOfSizeK(int arr[], int k){
        de = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder(); 
        
        int i;
        for(i=0;i<k;i++){
            
            while(!de.isEmpty() && arr[i]>=arr[de.peekLast()]){
                de.removeLast();
            }
            
            de.addLast(i);
        }
        
        
        for(i=k;i<arr.length;i++){
            
            
            sb.append(arr[de.peek()]+" ");
            
            // remove the window pop out
            while((!de.isEmpty()) && de.peek()<=i-k){
                de.removeFirst();
            }
            
            // if arr[i] greter than last(rear) value then remove element till it gets less in deque.
            while((!de.isEmpty()) && arr[i]>=arr[de.peekLast()]){
                de.removeLast();
            }
            
            de.addLast(i);
        }
        
        sb.append(arr[de.peek()]);
        
        System.out.println(sb);
        
    }
    
	public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	while(t-->0){
	    int n = sc.nextInt();
	    int k = sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0;i<n;i++)
	        arr[i]=sc.nextInt();
	    maxOfAllSubOfSizeK(arr, k);
	}
	}
}
