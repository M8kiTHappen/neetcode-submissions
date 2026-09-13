class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (A.length > B.length) {
            A = nums2;
            B = nums1;
        }

        int x = A.length;
        int y = B.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (x + y + 1) / 2 - partX;

            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : A[partX - 1];
            int minRightX = (partX == x) ? Integer.MAX_VALUE : A[partX];
            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : B[partY - 1];
            int minRightY = (partY == y) ? Integer.MAX_VALUE : B[partY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted, or invalid input");
    }
}