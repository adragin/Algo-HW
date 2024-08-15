import java.util.Arrays;

public class Merge_Sort_desc {
    public static void main(String[] args) {
        /*  mergeSortDesc(arr) - method that descending sorts arr[] using marge()
        *   merge(array, leftArr, rightArr) - merge two sorted subarrays to array[]
        */

        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(arr));
        mergeSortDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortDesc(int[] array) {
        int lengthArr = array.length;    // длинна массивы
        if (lengthArr == 1) {            // условие выхода из рекурсии
            return;
        }

        int mid = (lengthArr % 2 != 0) ? lengthArr / 2 + 1 : lengthArr / 2; //левый подмассив больше, когда не парный размер
        int[] leftArr = new int[mid];               // левый  подмассив
        int[] rightArr = new int[lengthArr - mid];  // правый подмассив

        // копируем элементы из массива в подмассивы
        for (int i = 0; i < mid; i++) {
            leftArr[i] = array[i];
        }

        // копируем элементы из массива в подмассивы
        System.arraycopy(array, 0, leftArr, 0, mid);
        System.arraycopy(array, mid, rightArr, 0, lengthArr - mid);

        System.out.println(Arrays.toString(leftArr) + " <==> " + Arrays.toString(rightArr));

        mergeSortDesc(leftArr);
        mergeSortDesc(rightArr);

        // когда мы достигли базового условия
        merge(array, leftArr, rightArr);

    }

    private static void merge(int[] array, int[] leftArr, int[] rightArr) {
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;

        // контролируем индексы подмассивов
        int leftPointer = 0;
        int rightPointer = 0;

        // контролируем индекс в основном массиве
        int arrayPointer = 0;

        while (leftPointer < leftArrLength && rightPointer < rightArrLength) {
            // Изменение знака в следующей строке с '<' на '>' меняет сортировку с "по возрастанию" на  "по убыванию" 
            if (leftArr[leftPointer] > rightArr[rightPointer]) {    // сравниваем элемент в левом и правом подмассиве
                array[arrayPointer] = leftArr[leftPointer];         // если условие верно, то элемент в левом меньше ->
                // сохраняем его в 0 ячейку основного массива
                leftPointer++;                      // и увеличиваем индексы в новом и в проверяемых массивах
                arrayPointer++;
            } else {
                array[arrayPointer] = rightArr[rightPointer];
                rightPointer++;
                arrayPointer++;
            }
        }

        // копируем элементы (если остались) из левого
        while (leftPointer < leftArrLength) {
            array[arrayPointer] = leftArr[leftPointer];
            leftPointer++;
            arrayPointer++;
        }

        // копируем элементы (если остались) из правого
        while (rightPointer < rightArrLength) {
            array[arrayPointer] = rightArr[rightPointer];
            rightPointer++;
            arrayPointer++;
        }

        System.out.println(Arrays.toString(leftArr) + " + " +
                            Arrays.toString(rightArr) + " ===> " +
                            Arrays.toString(array));
    }

}
