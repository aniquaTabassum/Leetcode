import java.util.HashMap;
import java.util.Map;

class Main {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indiceMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++)
        {
            indiceMap.put(nums[i],i);
        }

        for(int i=0; i<nums.length;i++)
        {
            int compliment = target - nums[i];
            if(indiceMap.containsKey(compliment) &&  indiceMap.get(compliment)!=i)
                return new int[] {i, indiceMap.get(compliment)};
        }
        throw new IllegalArgumentException("No solution found");
    }
}