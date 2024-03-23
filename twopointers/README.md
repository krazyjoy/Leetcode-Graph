## 2460. Apply Operations to an Array

```agsl
for(int right=0; right<nums.length-1; right++){
            if(nums[right] == nums[right+1]) {
                nums[right] *= 2;
                nums[right + 1] = 0;
            }
        }
        for(int i=0, left=0; i<nums.length; i++){
            if(nums[i]!=0){
                /* set nums[i] = 0, after changing nums[left] to nums[i]
                 */

                int tmp = nums[i];
                nums[i] = 0;
                nums[left] = tmp;
                left += 1;
            }

        }
        System.out.println(Arrays.toString(nums));
        return nums;
```

### Remove Target Element In Place
Input: nums=[3,2,2,3], val=3
Output: 2, nums=[2,2,_,_]

**condition to insert: nums[right] != val
```agsl
int left=0;
for(int right=0; right<nums.length; right++){
   if(nums[right] != val){
        nums[left] = nums[right];
        left += 1;
   }
}

return left;
```