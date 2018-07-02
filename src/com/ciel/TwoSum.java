class Solution {
    public int[] twoSum(int[] nums, int target) {
    	/* 
    	 * 参考：https://tonghuashuo.github.io/blog/leetcode-01-two-sum.html
    	 * https://blog.csdn.net/liuzhixiong_521/article/details/79921661
    	 */
    	
    	
        /* 
         * 方案1：首先对数组排序，然后设定两个指针i和j，i指向数组的开始位置，j指向数组 的结束位置，临时变量sum=i+j，sum小于target时i++，sum大于target时j--，sum等于
        target时结束，返回结果。因为还需要返回原始数组的下标，所以要先复制一个出来，单独进行排序，找到匹配的元素后，再看这两个元素在原始数组中的位置。
                            时间复杂度o(nlogn)，空间复杂度o(1)
        */
        
        int [] res = new int[2];
        
        // step1. 复制nums数组
        int[] copylist = new int[nums.length];   
        System.arraycopy(nums, 0, copylist, 0, nums.length);  
        Arrays.sort(copylist);    
        
        // step2. 找到copylist中的两个加数
        int low = 0;
        int high = copylist.length - 1;
        /* 假定了每组输入有且只有一组符合条件的解，所以如果原始数组中有重复的元素（比如：3+3=6），最多只会出现两次，如果出现三次及以上就会存在多个解，
         * 想清楚了这一点就好办了，如果刚好是这种情况，那一定是从两头找过来到某两个相邻的位置相遇了
         */
        while(low < high){
            if(copylist[low] + copylist[high] < target){
                low++;
            }else if(copylist[low] + copylist[high] > target){
                high--;
            }else{
                res[0] = copylist[low];
                res[1] = copylist[high];
                break;
            }
        }
        
        // step3. 确定两个加数在nums中的下标
        int index1 = -1, index2 = -1;
        for(int i=0; i<nums.length; ++i){
            if(nums[i] == res[0] && index1 == -1){
                index1 = i;
            }else if(nums[i] == res[1] && index2 == -1){
                index2 = i;
            }
        }
        res[0] = index1;
        res[1] = index2;
        Arrays.sort(res);
        
        return res;
    }
}