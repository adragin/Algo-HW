package HW_15.lesson_15_20241017;

public class WindowsSliding_2 {
    public static void main(String[] args) {
        int[] arr = {1, 45, 2, 10, 23, 3, 1, 0, 20};
        int k = 4; // размер окна
        System.out.println("Стандартный перебор maxSum = "+maxSumNaiveApproach(arr, k));
        System.out.println("Скользящее окно maxSum = "+maxSumSlidingWindow(arr, k));

    }

    // Стандарный перебор
    public static int maxSumNaiveApproach(int[] arr, int k) {
        int length = arr.length;
        int max = 0;

        for (int i = 0; i < length - k + 1; i++) {
            int current = 0;
            for (int j = 0; j < k; j++) {
                current = current + arr[i + j];
                max = Math.max(current, max);
            }
        }
        return max;
    }

    // Подход скользящее окно
    public static int maxSumSlidingWindow(int[] arr, int k) {
        int length = arr.length;
        if (length < k) {
            System.out.println("wrong size of array");
            return -1;
        }

        int min = 0;
        // сумма первого окна
        for (int i = 0; i < k; i++)
            min += arr[i];

        int windowSum = min;
        for (int i = k; i < length; i++) {
            windowSum += arr[i] - arr[i - k];
            min = Math.min(min, windowSum);
        }

        return min;
    }

}
