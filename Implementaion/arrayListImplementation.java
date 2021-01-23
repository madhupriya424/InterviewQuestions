Note: Method implemented here:
add(): void
remove(): int num
remove(int n): void
size(): int size
toString(): String res
getArray(): void
resize(): void
get(int n): int index
use of private variable.

/*package whatever //do not write package name here */

import java.util.*;

class ArrayList {
    private int arr[];
    private int capacity;
    private int size;
    
    ArrayList(int totalSize) {
        this.capacity = totalSize;
        this.size = 0;
        this.arr = new int[capacity];
    }
    
    public void add(int item) {
        if(size == capacity)
            resize(arr, capacity);
        arr[size] = item;
        size++;
    }
    
    public int get(int num){
        if(size == 0)
            return -1;
        for(int i = 0; i < size; i++) {
            if(arr[i] == num)
                return i;
        }   
        return -1;
    }
    
    public int remove() {
        if(size == 0)
            return -1;
        int temp = arr[size - 1];    
        size--;  
        return temp;
    }
    
     public void remove(int num) {
        if(size == 0)
            return;
        for(int i = 0; i < size; i++) {
            if(arr[i] == num) {
                while(i++ < size) {
                    arr[i-1] = arr[i];
                }
                size--;    
            }
        }
    }
    
    public void resize(int arr[], int capacity) {
        int temp[] = new int[2 * capacity];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
       
        this.arr = temp;  // Changes will be done on global now after adding 'this'
        this.capacity = arr.length;
    }
    
    public int size() {
        return this.size;
    }
    
    public void getArray() {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i]+" ");
        System.out.println();    
    }
    
    public String toString() {
        String result = "";
        for (int i = 0; i < this.size(); i++) {
            result += arr[i]+" ";
        }
        return result;
    }
    
    
    
	public static void main (String[] args) {
	    ArrayList al = new ArrayList(5);
	    al.add(3);
	    al.add(5);
	    al.add(2);
	    System.out.println("removed: " +al.remove());
	    System.out.println("removed: " +al.remove());
	    al.add(1);
	    al.add(8);
	    System.out.println("removed: " +al.remove());
	    al.add(3);
	    System.out.println("removed: " +al.remove());
	    System.out.println("Checking resize Method:");
	    al.add(9);
	    al.add(2);
	    al.add(7);
	    al.add(4);
	    al.add(8);
	    al.add(6);
	    System.out.println("Total Size: " +al.size());
	    System.out.println("Array elements: "+al.toString());
	    al.getArray();
	    System.out.println("Index 9: " +al.get(9));
	    System.out.println("Index 4: " +al.get(4));
	    System.out.println("Index 5: " +al.get(5));
	    al.remove(9);
	    al.remove(7);
	    System.out.println("Final Array elements: ");
	    al.getArray();
	}
}

O/P:
removed: 2
removed: 5
removed: 8
removed: 3
Checking resize Method:
Total Size: 8
Array elements: 3 1 9 2 7 4 8 6 
3 1 9 2 7 4 8 6 
Index 9: 2
Index 4: 5
Index 5: -1
Final Array elements: 
3 1 2 4 8 6 
