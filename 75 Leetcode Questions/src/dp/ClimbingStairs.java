package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * When attempting this question my initial solution had failed due to the time limit being exceeded. This caused
 * a realization that I should be caching values instead of recomputing the same values every time.
 *
 * As an example: n = 5
 *
 * At each invocation of utility we will recursively invoke utility twice, once subtracting 1, again subtracting 2.
 *
 * utility(5) = utility(4) + utility (3)
 * utility (4) = utility(3) + utility(2)
 * utility (3) = utility(2) + utility(1)
 *
 * Note that utility(3) is re-calculated many times, it is used in determining utility(5) and also again in utility(4).
 * This re-computation is expensive and we can advantage from caching here. Cache = Data structure used to store data for
 * re-querying. Map<Integer, Integer>.
 *
 * Time complexity:
 *  O(2^n) - without caching (each invocation of utility, spans another 2 invocations of utility).
 *  O(n) - with caching (each invocation of utility will still invoke 2 other invocations, however the values are only computed once)
 *       - the size of the recursion tree is n.
 *
 * Space complexity:
 *  O(n) - the depth of the recursion tree can be a maximum of n.
 */
class ClimbingStairs {

    public int climbStairs(int n) {
        // stair height -> number of permutations.
        Map<Integer, Integer> cache = new HashMap<>();
        return utility(n, cache);
    }

    public int utility(int n, Map<Integer, Integer> cache) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            if (cache.get(n) != null) {
                return cache.get(n);
            }
            int result = utility(n-1, cache) + utility(n-2, cache);
            cache.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        ClimbingStairs instance = new ClimbingStairs();
        System.out.println(instance.climbStairs(3));
        System.out.println(instance.climbStairs(5));
        System.out.println(instance.climbStairs(10));
        System.out.println(instance.climbStairs(44));
    }

}