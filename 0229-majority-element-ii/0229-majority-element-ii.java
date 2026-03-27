class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int min = nums.length / 3;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);

            if (mp.get(num) > min && !l.contains(num)) {
                l.add(num);
            }
        }

        return l;
    }
}