import java.util.Arrays;
import java.util.Stack;

public class Quick_sort_iteration {
    public static void main(String[] args) {
        int[] array = {7, -2, 4, 1, 6, 5, 0, -4, 2};
        quickSortIterative(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSortIterative(int[] array, int start, int end) {
        // Используем стек для хранения диапазонов подмассивов
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, end});

        while (!stack.isEmpty()) {
            int[] part = stack.pop();
            int partitionStart = part[0];
            int partitionEnd = part[1];

            if (partitionStart >= partitionEnd) continue;

            int indexPivot = partition(array, partitionStart, partitionEnd);

            // Добавляем подмассивы в стек для последующей сортировки
            // правая ветка
            if (indexPivot + 1 < partitionEnd) {
                stack.push(new int[]{indexPivot + 1, partitionEnd});
            }
            // левая ветка
            if (partitionStart < indexPivot - 1) {
                stack.push(new int[]{partitionStart, indexPivot - 1});
            }
        }
    }

    private static int partition(int[] array, int partitionStart, int partitionEnd) {
        int pivot = array[partitionEnd];                        //choose pivot element
        System.out.println("pivot = " + pivot);
        int index = partitionStart;
        // перемещать элементы влево и вправо от опорного
        for (int i = partitionStart; i < partitionEnd; i++) {
            if (array[i] <= pivot) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, partitionEnd, index);

        return index;
    }

    private static void swap(int[] array, int source, int destination) {
        int temp = array[source];
        array[source] = array[destination];
        array[destination] = temp;
    }

}
