https://ide.geeksforgeeks.org/GUfbGT0DDW

class PriorityQueue {
    int[] arr;
    int size;
    
    PriorityQueue() {
        arr = new int[1000];
        size = 0;
    }
    
    public void add(int item) {
        arr[size] = item;
        size++;
        
        shiftUp(size - 1);
    }
    
    public int getParent(int index){
        return (index - 1)/2;
    }
    
    public void shiftUp(int index) {
        if(index != 0) {
            int parentIndex = getParent(index);
            
            if(arr[parentIndex] > arr[index]) {
                //swap
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];
                arr[index] = temp;
                
                shiftUp(parentIndex);
            }
        }
    }
    
    public void  remove() {
        if(isEmpty()) {
            // throw new Exception();
            return;
        }
        int res = arr[0];
        size--;
        
        // swap first and last element
        int temp = arr[size-1];
        arr[size-1] = arr[0];
        arr[0] = temp;
        

        shiftDown(0);
    }
    
    public void shiftDown(int i){
        
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        
        if(l<size && arr[largest]> arr[l]){
            largest = l;
        }
        if(r<size && arr[largest]> arr[r]){
            largest = r;
        }
        
        if(largest!=i){
            // swap(arr[largest], arr[i]);
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            
            shiftDown(largest);
        }
    }
    
    
    public int peek(){
        return arr[0];
    }
    
    public boolean isEmpty(){
        if(size==0)
          return true;
        return false;  
    }
    
    public int size(){
        return size;
    }
    
    
// Methods to implement
    
// add
// remove
// peek
// isEmpty
// size

    public static void main(String args[]){
        PriorityQueue pq = new PriorityQueue();
        pq.add(3);
        pq.add(2);
        pq.add(4);
        pq.add(5);
        pq.add(7);
        
        System.out.println(pq.peek());   //2
        pq.remove();
        System.out.println(pq.peek());   //3
        System.out.println(pq.size());   //4
        System.out.println(pq.isEmpty()); //false
        pq.add(9);
        pq.add(1);
        System.out.println(pq.peek());  //1
        pq.remove();
        System.out.println(pq.peek());  //2
    }
}


Output:
2
3
4
false
1
2


























