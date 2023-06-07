class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findLeftIndex(nums, target);
        int rightIndex = findRightIndex(nums, target);

        if (leftIndex <= rightIndex) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int findLeftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;

                if (nums[mid] == target) {
                    leftIndex = mid;
                }
            } else {
                left = mid + 1;
            }
        }

        return leftIndex;
    }

    private int findRightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;

                if (nums[mid] == target) {
                    rightIndex = mid;
                }
            } else {
                right = mid - 1;
            }
        }

        return rightIndex;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Target 1: " + target1 + ", Result: [" + result1[0] + ", " + result1[1] + "]"); // Output: [3, 4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("Target 2: " + target2 + ", Result: [" + result2[0] + ", " + result2[1] + "]"); // Output: [-1, -1]

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("Target 3: " + target3 + ", Result: [" + result3[0] + ", " + result3[1] + "]"); // Output: [-1, -1]
    }
}
