import java.util.*;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class CodingChallenge062019 {

    /**
     * My approach :: divide and conquer.
     * Sort the list and add the first to the last item in the list.
     * If the sum is lower than the target, increase the index of the lowest to the next number in the array.
     * If the sum is higher than the target, decrease the index of the highest number in the array to the next one.
     * If the sum equals the target return true.
     * Continue to loop through the array as long as we aren't hitting the outer bounds of the array.
     *
     * @param arr given array
     * @param target target sum
     * @return is there a combination that is the target
     */
    public static boolean findTarget(int[] arr, int target) {
        int lowest = 0;
        int highest = arr.length-1;

        // if the array is bigger than zero, sort it, else return false
        if (arr.length > 0) {
            Arrays.sort(arr);
        }
        else {
            return false;
        }

        // continue until we hit the outer bounds of the array
        while (lowest < arr.length && highest >= 0) {
            int sum = arr[lowest] + arr[highest];
            if (sum == target) {
                System.out.println(arr[lowest] + " + " + arr[highest]);
                return true;
            }
            if (sum < target) {
                lowest++;
            }
            if (sum > target) {
                highest--;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        int[] arr = {12, 15, 5, 3, 13, 6, 8, 11, 20, 7};
        int target = 17;

        boolean result = findTarget(arr, target);
        System.out.println(result);
    }
}
