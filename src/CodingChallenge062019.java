import java.util.*;

public class CodingChallenge062019 {

    public static boolean findTarget(int[] arr, int target) {
        int lowest = 0;
        int highest = arr.length-1;
        Arrays.sort(arr);

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
