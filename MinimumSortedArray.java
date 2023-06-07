class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 4, 5, 1, 2};
        int min1 = solution.findMin(nums1);
        System.out.println("Minimum: " + min1); // Output: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int min2 = solution.findMin(nums2);
        System.out.println("Minimum: " + min2); // Output: 0

        int[] nums3 = {11, 13, 15, 17};
        int min3 = solution.findMin(nums3);
        System.out.println("Minimum: " + min3); // Output: 11
    }
}
