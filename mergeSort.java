//请记住！！！！Java在Arrays类里面自带了sort函数，which is very efficient！！！！！
//如果在大程序中需要排序，请直接用Arrays.sort(array)!!!!!!!
class Solution {
    public int[] sortArray(int[] nums) {
        return sort_merge(nums);   
    }
    
    public int[] sort_merge(int[] subArray){
        if (subArray.length==1){
            return subArray;
        }
        int half = 0;
        half = subArray.length/2;
        int[] left_Array = Arrays.copyOfRange(subArray, 0, half);
        int[] right_Array = Arrays.copyOfRange(subArray,half,subArray.length);
        //sublist include the left but exclude the right
        
        left_Array = sort_merge(left_Array);
        right_Array = sort_merge(right_Array);
        
        // the code above is the divide step
        
        //the code below is the conquer step
        return mergeSortedList(left_Array,right_Array); 
        
    }
    
    public int[] mergeSortedList(int[] left_Array,int[] right_Array){
        int p = 0;
        int q = 0;
        int count = 0;
        int[] result = new int[left_Array.length+right_Array.length];
        while(p<left_Array.length && q<right_Array.length){
            if(left_Array[p]<=right_Array[q]){
                result[count] = left_Array[p];
                count++;
                p++;
            }else{
                result[count] = right_Array[q];
                count++;
                q++;
            }  
        }
        if(p == left_Array.length){
            while(count<result.length){
                result[count] = right_Array[q];
                count++;
                q++;
            }
        }else if(q == right_Array.length){
            while(count<result.length){
             result[count] = left_Array[p];
                count++;
                p++;
            }
        }
        return result;
    }  
}
