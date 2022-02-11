import java.util.HashMap;
import java.util.HashSet;

class LeetCode904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(left <= right && right < fruits.length) {
            if(map.size() < 2 || (map.size() == 2 && map.containsKey(fruits[right]))) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                max = Math.max(max,right - left + 1);
                right++;
            } else {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if(map.getOrDefault(fruits[left], 0) <= 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode904 cur = new LeetCode904();
        System.out.println(cur.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
