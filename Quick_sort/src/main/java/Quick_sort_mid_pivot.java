import java.util.Arrays;

public class Quick_sort_mid_pivot {
    public static void main(String[] args) {
        int[] array = {7, -2, 4, 1, 6, 5, 0, -4, 2};
        quickSortRecursive(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSortRecursive(int[] array, int start, int end) {
        if (start >= end) { // условие выходы из рекурсии
            //System.out.println("start "+ start + " end " + end);
            return;
        }
        int indexPivot = partition(array, start, end);
        quickSortRecursive(array, start, indexPivot - 1);   //левая ветвь
        quickSortRecursive(array, indexPivot + 1, end);    // правая ветвь

    }

    private static int partition(int[] array, int partitionStart, int partitionEnd) {
//  берем средний индекс текущей подветки
        int middle = partitionStart + (partitionEnd - partitionStart) / 2;
        int pivot = array[middle];  //choose pivot element
        // System.out.println(Arrays.toString(array));
        System.out.println("pivot = " + pivot);

//  Перемещение опорного элемента в конец подмассива
        swap(array, middle, partitionEnd);

        int index = partitionStart;
        // перемещать элементы влево(меньшие) и вправо(большие) от опорного
        for (int i = partitionStart; i < partitionEnd; i++) {
            if (array[i] <= pivot) {       // изменение '<=' на '>=' разворачивает сортировку
                swap(array, i, index);
                index++;
            }
        }
//  Переместить опорный элемент на его окончательное место
        swap(array, partitionEnd, index);

        return index;
    }

    private static void swap(int[] array, int source, int destination) {
        if (source == destination) return;
        int temp = array[source];
        array[source] = array[destination];
        array[destination] = temp;
    }

}
