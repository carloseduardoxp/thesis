
public class DeepSeek {



    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                temp[j++] = nums[i];
            }
        }

        // Copy back to original array if needed
        System.arraycopy(temp, 0, nums, 0, j);
        return j;
    }

}
