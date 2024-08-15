public class Sort_merg {
    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        System.out.println(getElemFromTwoMergSortArr(arr1, arr2, k));
    }

    public static int getElemFromTwoMergSortArr (int[] arr1, int[] arr2, int k) {
        int result = 0;
        int counter = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        // если запрашиваемый элемент больше размера результирующего массива
        if (k > arr1.length + arr2.length) {
            return -1;
        }

        // поиск k элемента без слияния массивов
        while (counter != k) {
            if (arr1[pointer1] < arr2[pointer2]) {
                result = arr1[pointer1];
                pointer1++;
            }  else {
                result = arr2[pointer2];
                pointer2++;
            }
            counter++;
        }

        return result;
    }
}
