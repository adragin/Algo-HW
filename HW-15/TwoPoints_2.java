package HW_15.lesson_15_20241017;

public class TwoPoints_2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 10};
        int[] arr2 = {8, 20, 30};

        findPairSumTwoPoint(arr1, arr2);
    }

    private static void findPairSumTwoPoint(int[] arr1, int[] arr2) {
        int min = Integer.MAX_VALUE;
        int poinet1 = 0;
        int poinet2 = 0;
        int absSubs;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                absSubs = Math.abs(arr1[i] - arr2[j]);
                if (absSubs < min) {
                    min = absSubs;
                    poinet1 = i;
                    poinet2 = j;
                }
            }
        }

        System.out.println("A[" + poinet1 + "] = " + arr1[poinet1]);
        System.out.println("B[" + poinet2 + "] = " + arr2[poinet2]);
    }
}
