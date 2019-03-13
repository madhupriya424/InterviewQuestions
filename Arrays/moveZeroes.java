283. Move Zeroes

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

Sol:

class Solution {
    public void moveZeroes(int[] nums) {
        int pushToLast = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
            nums[pushToLast++]=nums[i];
        }
        
        for(int i=pushToLast;i<nums.length;i++){
            nums[i]=0;
        }
        
        for(int i: nums)
            System.out.print(i+" ");
    }
}

-------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public void moveZeroes(int[] nums) {
      int i=0, j=1;
       while(i<nums.length && j<nums.length){
           while(i<nums.length && nums[i]!=0){
               i++;
               j=i+1;
           }
           while(i<nums.length && j<nums.length && nums[j]==0)
               j++;
           
           if(i<nums.length && j<nums.length){
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
               i++;
               j++;
           }
       }
    }
}
-----------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public void moveZeroes(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            int j=i;
            int flag=0;
            
            while(j!=nums.length && nums[j]==0){
                j++;
                flag=1;
            }
            
            if(j!=nums.length && flag==1){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                flag=0;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
