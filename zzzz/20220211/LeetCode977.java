public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int[] newNum = new int[nums.length];
        for(int index = 0; index < nums.length; index++) {
            newNum[index] = (int)Math.pow(nums[index],2);
        }
        mergeSort(0, newNum.length - 1, newNum);
        return newNum;

    }

    public void mergeSort(int left, int right, int[] arr) {
        if(left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(left, mid, arr);
        mergeSort(mid + 1, right, arr);
        merge(left,mid, right, arr);
    }

    public void merge(int left, int mid, int right, int[] arr) {
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int index = 0;
        while(p1 <= mid && p2 <= right) {
            if(arr[p1] < arr[p2]) {
                help[index++] = arr[p1++];
            } else {
                help[index++] = arr[p2++];
            }
        }
        while(p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while(p2 <= right) {
            help[index++] = arr[p2++];
        }

        for(int newIndex = 0; newIndex < help.length; newIndex++) {
            arr[newIndex + left] = help[newIndex];
        }
    }

    public static void main(String[] args) {
        LeetCode977 cur = new LeetCode977();
        System.out.println(cur.sortedSquares(new int[]{-4, -1, 0, 3, 10}).toString());

    }
}
