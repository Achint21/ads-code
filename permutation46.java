class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> current,
                            List<List<Integer>> result) {

        // Base case
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number
        for (int num : nums) {

            // Don't use a number that is already present
            if (current.contains(num)) {
                continue;
            }

            current.add(num);

            backtrack(nums, current, result);

            // Undo the choice
            current.remove(current.size() - 1);
        }
    }
}